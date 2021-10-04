package com.lt.client;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;
import java.util.Scanner;

import org.apache.log4j.Logger;

import com.lt.bean.Course;
import com.lt.bean.Student;
import com.lt.business.AdminImplService;
import com.lt.business.AdminInterface;
import com.lt.business.CourseImplService;
import com.lt.business.CourseInterface;
import com.lt.business.GradeCardImplService;
import com.lt.business.GradeCardInterface;
import com.lt.business.SemesterRegistrationImplService;
import com.lt.business.SemesterRegistrationInterface;
import com.lt.business.StudentImplService;
import com.lt.business.StudentInterface;
import com.lt.business.UserImplService;
import com.lt.business.UserInterface;
import com.lt.dao.UserDAOImpl;
import com.lt.dao.UserDAOInterface;

public class CRSApplication {
	
	public static void main(String[] args)
	{
		StudentMenu studentMenu=new StudentMenu();
		ProfessorMenu professorMenu= new ProfessorMenu();
		AdminMenu adminMenu=new AdminMenu();
		
		System.out.println("Welcome to Course Registration System");
		System.out.println("**************************************");
		System.out.println("\n"+"Select the below option to proceed further");
		System.out.println("1. Login"+"\n"+ "2. Signup"+"\n"+"3. Update Password"+"\n"+"4. Exit"+"\n");
		Scanner in1 = new Scanner(System.in);
		int selection = in1.nextInt(); 

		switch(selection)
		{ 
			case 1: int role=login();
			if(role!=0)
			{ 
				if(role==1)
				{
					studentMenu.studentChecklist();
				 }
			     else if(role==2)
				 {
			    	 professorMenu.professorChecklist();
				 }
				else if(role==3)
				{
					adminMenu.adminChecklist();
				}
				else
				{
					System.out.println("Invalid Credential!!!");
				}
			}
			else
			{
				System.out.println("Username or Password is invalid");
			}
			break;
	
			case 2: System.out.println("Signup"+"\n"); 
					singup();
					break;
	
			case 3: System.out.println("Update Password"+"\n"); 
					passwordUpdate();
					break;
	
			case 4: System.out.println("You are successfully logged out"); 
					break;
		}
	   }
	public static int login()
	{
		int checkLogin=0;
		Scanner in = new Scanner(System.in);
		System.out.println("Enter Username"); 
		String username = in.nextLine();

		System.out.println("Enter password"); 
		String password = in.nextLine();
		
		UserInterface userI= new UserImplService();
		if(userI.login(username, password)!=0)
		{
			checkLogin=userI.login(username, password);
			displayCurrentDate();
			
		}
		return checkLogin;
	}
	
	public static void singup()
	{
		StudentMenu studentMenu1=new StudentMenu();
		studentMenu1.studentSignup();		
	}
	
	public static void passwordUpdate()
	{
		UserInterface userImpl= new UserImplService();
		Scanner in = new Scanner(System.in);
		System.out.print("Enter username to be updated :"+"\n");    
	    String uname = in.nextLine(); 
	    System.out.print("Enter new password to be updated :"+"\n");    
	    String pwrd = in.nextLine();
	    userImpl.updatePassword(uname,pwrd);
	}
	public static void displayCurrentDate() {

		Date currentDate = new Date();
		LocalDateTime localDateTime = LocalDateTime.now();
		System.out.println("Current Date and Time From Java 8 : " + localDateTime);
	}
}

