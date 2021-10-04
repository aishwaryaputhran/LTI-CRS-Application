package com.lt.business;
import java.util.Scanner;

import org.apache.log4j.Logger;

import com.lt.bean.Admin;
import com.lt.bean.Catlog;
import com.lt.bean.Course;
import com.lt.bean.Professor;
import com.lt.bean.Student;
import com.lt.bean.User;
import com.lt.client.AdminMenu;
import com.lt.client.ProfessorMenu;
import com.lt.dao.AdminDAOImpl;
import com.lt.dao.AdminDAOInterface;
import com.lt.dao.CourseDAOImpl;
import com.lt.dao.CourseDAOInterface;
import com.lt.dao.CoursecatalogDAOImpl;
import com.lt.dao.CoursecatalogDAOInterface;
import com.lt.dao.ProfessorDAOImpl;
import com.lt.dao.StudentDAOImpl;
import com.lt.dao.StudentDAOInterface;
import com.lt.dao.UserDAOImpl;
import com.lt.dao.UserDAOInterface;
import com.lt.exception.CourseFoundException;
import com.lt.exception.CourseNotFoundException;
/*
 * @author G4-FullStackGroup
 * Implementations of AdminServices 
 */
public class AdminImplService implements AdminInterface
{
	private static volatile AdminImplService instance = null;

	private static Logger logger = Logger.getLogger(AdminImplService.class);
	CourseInterface course1 = CourseImplService.getInstance();
	Course course=new Course();
	AdminDAOInterface ai= AdminDAOImpl.getInstance();

	private AdminImplService()
	{
	}
	/**
	 * Method to make AdminImplService Singleton
	 * @return
	 */
	public static AdminImplService getInstance()
	{
		if(instance == null)
		{
			synchronized(AdminImplService.class){
				instance = new AdminImplService();
			}
		}
		return instance;
	}
	/*
	 * Method to approve a Student 
	 * @param studentName
	 * @throws StudentNotFoundException 
	 */
	@Override
	public boolean approveStudent(int studentId) 
	{
		return ai.adminApproval(studentId);
	}
	/*
	 * Method to add professor to user DB
	 * @param name,password
	 * 
	 */
	@Override
	public boolean addProfessor(String name, String password)
	{
		boolean checkProf=true;
		int profRole=2;
		UserDAOInterface d1=UserDAOImpl.getInstance();
		for(User u: d1.getUserCredential())
		{
			if(u.getUsername().equalsIgnoreCase(name))
			{
				checkProf=false;
				break;
			}
		}
		if(checkProf)
		{
			d1.signupUser(name, password, profRole);
			checkProf=true;
		}
		return checkProf;
	}
	/*
	 * Method to add Course to Course 
	 * @throws CourseFoundException
	 */
	@Override
	public void addCourses() throws CourseFoundException 
	{
		AdminDAOInterface adminDao=AdminDAOImpl.getInstance();
		CoursecatalogDAOInterface ci=CoursecatalogDAOImpl.getInstance();
		logger.info("Select the option from below course list");	
		logger.info("CourseId  "+"|"+" CourseName");
		logger.info("----------------------------");
		for(Catlog c:ci.viewCourses())
		{
			logger.info(c.getCourseCode()+"         | "+c.getCourseName());

		}
		logger.info("Enter the CourseId from the list to be added");
		Scanner in = new Scanner(System.in);
		String CourseCode = in.next();
		for(Catlog catlog : ci.viewCourses())
		{
			if(CourseCode.equals(catlog.getCourseCode()))
			{
				String CourseName=catlog.getCourseName();
				//String ProfName=
				double CourseFee = catlog.getCourseFee();
				if(adminDao.addCourse(CourseCode,CourseName,CourseFee))
				{
					logger.info("course Added Sucessfully......");
					break;
				}
				else
					logger.info("Course was not added, please try again!!");
			}	
		}		
	}
	/*
	 * Method to Delete Course from Course table 
	 * @param courseId
	 * @throws CourseNotFoundException 
	 */
	@Override
	public void deleteCourses() throws CourseNotFoundException 
	{
		AdminDAOInterface adminDao1=new AdminDAOImpl();
		logger.info("Select the courseId to be deleted"+"\n");
		CourseDAOInterface c1=CourseDAOImpl.getInstance();
		logger.info("CourseCode  "+"|"+" CourseName");
		logger.info("----------------------------");
		for(Course course : c1.getCourse())
		{
			logger.info(course.getCourseCode()+"        | "+course.getCourseName());
		}
		logger.info("Enter the CourseId from the list to be deleted");
		Scanner in = new Scanner(System.in);
		String CourseId = in.next();	
		for(Course cc:c1.getCourse())
		{
			if(CourseId.equals(cc.getCourseCode()))
			{
				String courseName=cc.getCourseName();
				if(adminDao1.deleteCourse(CourseId,courseName))
				{
					logger.info("Course have been deleted Successfully..");
					break;
				}
				else {
					logger.info("Course was not deleted, please try again!!");
				}
			}
		}					
	}

}