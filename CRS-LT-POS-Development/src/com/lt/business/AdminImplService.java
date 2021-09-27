package com.lt.business;

import java.util.Scanner;

import com.lt.bean.Admin;
import com.lt.bean.Catlog;
import com.lt.bean.Course;
import com.lt.bean.Professor;
import com.lt.bean.Student;
import com.lt.bean.User;
import com.lt.client.AdminMenu;
import com.lt.dao.AdminDAOImpl;
import com.lt.dao.AdminDAOInterface;
import com.lt.dao.CourseDAOImpl;
import com.lt.dao.CourseDAOInterface;
import com.lt.dao.CoursecatalogDAOImpl;
import com.lt.dao.CoursecatalogDAOInterface;
import com.lt.dao.ProfessorDAOImpl;
import com.lt.dao.ProfessorDAOInterface;
import com.lt.dao.StudentDAOImpl;
import com.lt.dao.StudentDAOInterface;
import com.lt.dao.UserDAOImpl;
import com.lt.dao.UserDAOInterface;
import com.lt.exception.CourseFoundException;
import com.lt.exception.CourseNotFoundException;

/**
 * 
 * @author G4-FullStackGroup
 * Implementations of Admin Operations
 * 
 */
public class AdminImplService implements AdminInterface
{

	CourseInterface course1 = new CourseImplService();
	Course course=new Course();
    AdminDAOInterface ai=new AdminDAOImpl();
    
    /**
	 * Method to approve a Student 
	 * @param studentName
	 * @throws StudentNotFoundException 
	 */
	@Override
	public void approveStudent(String studentName) 
	{
		
		StudentDAOInterface si=new StudentDAOImpl();
		for( Student s: si.getStudentList())
		{
			if((s.getStudentName().equalsIgnoreCase(studentName)) && (s.getApproved()==0))
			{
				if(ai.adminApproval(studentName))
				{
					System.out.println(studentName+" "+"has been approved by admin please try to login");
				}
				else
					System.out.println(studentName+" "+"has not been approved");
			}		
		}
	}
	
	/**
	 * Method to add professor to user DB
	 * @param name,password,contact,emailId,address
	 * @throws UserNotAddedException
	 */
	@Override
	public boolean addProfessor(String name, String password, Long contact, String emailId, String address)
	{
		boolean checkProf=true;
		int profRole=2;
		UserDAOInterface d1=new UserDAOImpl();
		for(User u: d1.getUserCredential())
		{
			if(u.getUsername().equalsIgnoreCase(name))
			{
				 checkProf=false;
			}
		}
		if(checkProf)
		{
			d1.signupUser(name, password, profRole);
		}
		return checkProf;
	}
	
	/**
	 * Method to add Course to Course 
	 * @param courseId
	 * @throws CourseFoundException
	 */
	@Override
	public void addCourses() throws CourseFoundException 
	{
		AdminDAOInterface adminDao=new AdminDAOImpl();
		CoursecatalogDAOInterface ci=new CoursecatalogDAOImpl();
		System.out.println("Select the option from below course list");	
		System.out.println("CourseId  "+"|"+" CourseName");
		System.out.println("----------------------------");
		for(Catlog c:ci.viewCourses())
		{
			if(c.getCourseId()<=9)
			{
				System.out.println(c.getCourseId()+"         | "+c.getCourseName());
			}
			else
			{
				System.out.println(c.getCourseId()+"        | "+c.getCourseName());
			}
		}
		System.out.println("Enter the CourseId from the list to be added");
		Scanner in5 = new Scanner(System.in);
		int cId = in5.nextInt();
		for(Catlog cc:ci.viewCourses())
		{
			if((cc.getCourseId()==cId))
			{
				String cname=cc.getCourseName();
				if(adminDao.addCourse(cId,cname))
				{
					System.out.println(" ");
					break;
				}
				else
					System.out.println("Course was not added, please try again!!");
			}	
		}		
	}
	
	
	/**
	 * Method to Delete Course from Course 
	 * @param courseId
	 * @throws CourseNotFoundException 
	 */
	@Override
	public boolean deleteCourses() throws CourseNotFoundException 
	{
		
		AdminDAOInterface adminDao1=new AdminDAOImpl();
		System.out.println("Select the courseId to be deleted"+"\n");
		CourseDAOInterface c1=new CourseDAOImpl();
		System.out.println("CourseId  "+"|"+" CourseName");
		System.out.println("----------------------------");
		for(Course c:c1.getCourse())
		{
			if(c.getCourseId()<=9)
			{
				System.out.println(c.getCourseId()+"         | "+c.getCourseName());
			}
			else
			{
				System.out.println(c.getCourseId()+"        | "+c.getCourseName());
			}
		}
		System.out.println("Enter the CourseId from the list to be deleted");
		Scanner in5 = new Scanner(System.in);
		int cId = in5.nextInt();	
		for(Course cc:c1.getCourse())
		{
			if(cc.getCourseId()==cId)
			{
				String cname=cc.getCourseName();
				if(adminDao1.deleteCourse(cId,cname))
				{
					return true;
				}
				else
					return false;
			}
		}	
		return false;
		
	}
}
