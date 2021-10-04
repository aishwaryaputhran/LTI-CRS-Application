package com.lt.business;
import java.sql.SQLException;
import java.util.List;

import org.apache.log4j.Logger;

import com.lt.bean.Course;
import com.lt.bean.RegisteredCourse;
import com.lt.dao.CourseDAOImpl;
import com.lt.dao.CourseDAOInterface;
import com.lt.dao.RegisteredCourseDAOImpl;
import com.lt.dao.RegisteredCourseDAOInterface;
import com.lt.dao.SemesterRegistrationDAOImpl;

/*
 * 
 * @author G4-FullStackGroup
 * Interface implementation for RegisteredCourseImplService
 * 
 */
public class RegisteredCourseImplService implements RegisteredCourseInterface
{
private static volatile RegisteredCourseImplService instance = null;
private static Logger logger = Logger.getLogger(RegisteredCourseImplService.class);	
	private RegisteredCourseImplService()
    {
    }
    /**
    * Method to make RegisteredCourseImplService Singleton
    * @return
    */
    public static RegisteredCourseImplService getInstance()
    {
    if(instance == null)
    {
    synchronized(RegisteredCourseImplService.class){
    instance = new RegisteredCourseImplService();
    }
    }
    return instance;
    }
	
	RegisteredCourseDAOInterface regCourse =RegisteredCourseDAOImpl.getInstance();
	CourseDAOInterface daoCourse =CourseDAOImpl.getInstance();
	
	/**
	 * Method to get StudentDetails from DB
	 * @param StudentId,name,semester.
	 * @returns message.
	 */
	@Override 
	public boolean getStudentDetails(int studentId, String name,int semester) 
	{
		SemesterRegistrationDAOImpl sd= SemesterRegistrationDAOImpl.getInstance();

		boolean isRegistered=false;
		if(!sd.getRegisteredStudentById(studentId)) 
		{
			logger.info("Student has registered already");
			isRegistered=false; 
		}
		else
		{ 
			sd.addRegisteredStudent(studentId,name,semester); 
			isRegistered=true; 
		}
		return isRegistered;
	}


	@Override
	public String getCourseDetails() 
	{

		return null;
	}

	@Override
	public List<RegisteredCourse> viewRegCourses(int studentId) throws SQLException {
		return regCourse.viewRegisteredCourses(studentId);
	}

	/**
	 * Method to addCourse to  DB
	 * @param courseCode,studentId,courseList,registeredCourseList.
	 * @returns message.
	 */
	@Override
	public boolean addCourse(String courseCode, int studentId, List<Course> courseList, List<RegisteredCourse> registeredCourseList) { 
		
		boolean avail_course = false;
		boolean avail_reg_course = false;
		for(RegisteredCourse course : registeredCourseList)
		{
			if(courseCode.equalsIgnoreCase(course.getCourseId())) 
			{
				avail_reg_course = true;
			}
		}
		
		for(Course course : courseList)
		{
			if(courseCode.equalsIgnoreCase(course.getCourseCode())) 
			{
				avail_course = true;
			}
		}
		
		String courseName = daoCourse.getCourseById(courseCode);
		double courseFee = daoCourse.getFeeById(courseCode);
		if(avail_course || !avail_reg_course) {
		return regCourse.addCourses(courseCode, courseName, courseFee, studentId);
		}
		return avail_reg_course;
	}

	/**
	 * Method to dropCourse from  DB
	 * @param courseCode,studentId,registeredCourseList.
	 * @returns message.
	 */
	@Override
	public boolean dropCourse(String courseCode, int studentId, List<RegisteredCourse> registeredCourseList) {

		boolean avail_reg_course = false;
		for(RegisteredCourse course : registeredCourseList)
		{
			if(courseCode.equalsIgnoreCase(course.getCourseId())) 
			{
				avail_reg_course = true;
			}
		}

		if(avail_reg_course) {
			return regCourse.dropCourse(courseCode, studentId);

		}else {
			logger.info("Course Code "+courseCode+" not Available...");
		}
		return false;

	}
}