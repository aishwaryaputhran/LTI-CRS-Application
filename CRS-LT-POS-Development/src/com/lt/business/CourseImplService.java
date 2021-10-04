package com.lt.business;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.lt.bean.Course;
import com.lt.dao.CourseDAOImpl;
import com.lt.dao.CourseDAOInterface;

/**
 * 
 * @author G4-FullStackGroup
 * Implementations of CourseImplService
 * 
 */
public class CourseImplService implements CourseInterface {


	private static Logger logger = Logger.getLogger(CourseImplService.class);
	List<Course> course1 = new ArrayList<Course>();
	Course objt = new Course();	
	CourseDAOInterface daoCourse =CourseDAOImpl.getInstance();

	private static volatile CourseImplService instance = null;

	private CourseImplService()
	{
	}
	/**
	 * Method to make AdminOperation Singleton
	 * @return
	 */
	public static CourseImplService getInstance()
	{
		if(instance == null)
		{
			synchronized(CourseImplService.class){
				instance = new CourseImplService();
			}
		}
		return instance;
	}


	@Override
	public String createCourse() {
		return "Course Added....";
	}

	@Override
	public String listCourse() {
		for(Course  cs : course1){

			logger.info("details of Course--> " +cs.getCourseCode() + " " +cs.getCourseName());
		}
		return "list course";
	}

	@Override
	public String updateCourse(Course courses) {
		if(courses!=null) {
			for(Course cs1: course1)
			{
				if(cs1.getCourseCode()==((Course) courses).getCourseCode())
				{
					cs1.setCourseName(((Course) courses).getCourseName());
				}
				//logger.info(cs.getCourseId()+ "\n" + cs.getCourseName());

			}
		}
		return "Course Updated";
	}

	/**
	 * Method to delete a Course 
	 * @param CourseId
	 * @throws StudentNotFoundException 
	 */
	@Override
	public String deleteCourse(String CourseId) {

		logger.info("details deleted of course--> "); 

		for(int i=0;i<course1.size();i++) {
			if(course1.contains(objt.getCourseCode())) {
				course1.remove(objt);
			}
		}
		for(Course cs : course1){
			logger.info("details of course--> "+cs.getCourseCode() + " " +cs.getCourseName());
		} 
		return "Course "+CourseId+" Delete Successfully... ";

	}

	@Override
	public List<Course> viewCourses() {
		// TODO Auto-generated method stub
		return daoCourse.getCourse();
	}
}