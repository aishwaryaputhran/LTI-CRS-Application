package com.lt.business;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import com.lt.bean.Course;
import com.lt.bean.Student;
import com.lt.bean.User;
import com.lt.client.CRSApplication;
import com.lt.client.StudentMenu;
import com.lt.dao.CourseDAOImpl;
import com.lt.dao.StudentDAOImpl;
import com.lt.dao.UserDAOImpl;
import com.lt.dao.UserDAOInterface;

public class StudentImplService implements StudentInterface
{
	UserDAOInterface uDao= new UserDAOImpl();
	StudentDAOImpl sDao= new StudentDAOImpl();
	
	GradeCardInterface gradeCard = new GradeCardImplService();
	CourseDAOImpl courseDAOImpl= new CourseDAOImpl();
	List<String> course = new ArrayList<String>();
	Course cc=new Course();
	List<Course> course1 = new ArrayList<Course>(); //emptylist
	
	@Override
	public boolean login(String studentName, String studentPassword) 
	{
		  
		  boolean isLogin=false;
		  for(User u: uDao.getUserCredential())
		  {
			    if((u.getUsername().equals(studentName)) && (u.getPassword().equals(studentPassword)))
			    {
			    	System.out.println("Login Successfull"+"\n"); 
			    	isLogin=true;
			    	break;
			    }				
		  }
		  
		  return isLogin;
		
	}
	
	@Override
	public boolean signup(String username,String password, long contact, String email, String address)
	{	
		 
		 boolean isSignup1=true;
		 System.out.println("********************");
		 for(User uc: uDao.getUserCredential())
		 {
			
		    if(uc.getUsername().equals(username))
		    {
		    	System.out.println("Username already exist"+"\n"); 
		    	isSignup1=false;
		    	break;
		    }
		} 
		if(isSignup1==true)
		{
			int role=1;
			sDao.signup(username, password, contact, email, address);
			uDao.signupUser(username, password,role);
			uDao.getUserCredential();
			System.out.println("UserProfile is created, Please login once Admin has approved your request"+ "\n");
			//CRSApplication.login();
			
		} 
		return isSignup1;
		
	}

	@Override
	public String viewGradeCard() 
	{	
		gradeCard.viewGradeCard();
		return null;
	}

	@Override
	public String courseSelection() 
	{
		Scanner in = new Scanner(System.in);
		System.out.println("Select the below options to complete course registeration "); 
		System.out.println("1. Add course"+" \n"+ "2. Drop course"+"\n"+"3. Exit");
		int option = in.nextInt();
		
		switch(option)
		{
			
			case 1:	System.out.println("Add course");
				    if(addCourse()==true)
					{
						System.out.println("Course added and registered sucessfully");
					}
				    break;
				    
			case 2: System.out.println("Drop course");
					if(dropCourse()==true)
					{
						System.out.println("Course has been deleted from your list");
					}
					break;
					
			case 3:  System.out.println("Exit");
					break;
					
		}
		return null;
	}

	@Override
	public String payFee() 
	{
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public boolean addCourse() 
	{
		
		  
//		  System.out.println("Please select the courseID fromt the below list");
//		  
//		  for (Course c : courseDAOImpl.getCourse()) 
//		  {
//			  System.out.println(c.getCourseId()+" " + c.getCourseName());  //display the course list
//		  }
//		  for(int i=0; i<6; i++)
//		  {
//			  Scanner in = new Scanner(System.in);
//			  System.out.println("Enter course Id: "); 
//			  String courseId = in.next();
//			  System.out.println("Enter course Name: "); 
//			  String courseName = in.next();
//			  course1.add(new Course(courseId,courseName));
//		  }
//		  
//		  return true;

		return true;		
		
	}

	@Override
	public boolean dropCourse() 
	{
		/*
		 * System.out.println("Please select the courseID fromt the below list");
		 * 
		 * for (Course c : course1) { System.out.println(c.getCourseId()+" " +
		 * c.getCourseName()); //display the course list }
		 * 
		 * Scanner in = new Scanner(System.in);
		 * System.out.println("Select the courseID to be deleted "); String courseId =
		 * in.next(); System.out.println("Enter course Name: "); String courseName =
		 * in.next();
		 * 
		 * for (Course c : course1) { if(c.getCourseId()==courseId ||
		 * c.getCourseName()==courseName) { course1.remove(c);
		 * System.out.println("Course has been removed"); System.out.println(course1); }
		 * else continue;
		 * 
		 * }
		 * 
		 * return true;
		 */
		return true;
		
	}




}
