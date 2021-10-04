package com.lt.client;

import java.util.Scanner;

import com.lt.business.StudentImplService;
import com.lt.business.StudentInterface;

public class StudentMenu 
{
	public void studentSignup()
	{
		Scanner in = new Scanner(System.in);
		System.out.println("Enter Username");
		String username = in.next();
		
		System.out.println("Enter Password");
		String password = in.next();
	
		System.out.println("Enter Contact");
		long contact = in.nextLong();   
	
		System.out.println("Enter emailID");
		String email = in.next();
		
		System.out.println("Enter Address");
		String address = in.next();
		
		StudentInterface sI= new StudentImplService();
		sI.signup(username, password, contact, email, address);
	}
	
	public void studentChecklist()
	{
		System.out.println("\n"+"Welcome Student");
		System.out.println("**************************************");
		System.out.println("Select the option");
		System.out.println("1. Course Selection"+"\n"+ "2. Semester Registration"+"\n"+"3. View Grade"+"\n"+"4. Pay Fee"+"\n");
		Scanner in4 = new Scanner(System.in);
		int option = in4.nextInt(); 
		
		switch(option)
		{
			case 1: System.out.println("CourseSelection"+"\n");
			//sI.courseSelection();
			break;

			case 2: System.out.println("Semester Registration"+ "\n");
			/*SemesterRegistrationInterface sreg= new SemesterRegistrationImplService();
				sreg.semesterMenu(); */
			break;

			case 3: System.out.println("ViewGrade"+"\n");
			//gI.viewGradeCard();
			break;

			case 4: System.out.println("PayFee"+"\n");
			break;
		 }
	}
	
}
