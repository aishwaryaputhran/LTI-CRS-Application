package com.lt.client;

import java.util.Scanner;

public class ProfessorMenu {

	public void professorSignup()
	{
	Scanner in = new Scanner(System.in);
	System.out.println("Enter Username");
	String username = in.next();


	Scanner in1 = new Scanner (System.in);
	System.out.println("Enter Password");
	String password = in1.next();


	Scanner in2 = new Scanner (System.in);
	System.out.println("Enter Contact");
	long contact = in2.nextLong();   //check this datatype


	Scanner in3 = new Scanner (System.in);
	System.out.println("Enter emailID");
	String email = in3.next();
	
	
	Scanner in4 = new Scanner (System.in);
	System.out.println("Enter Address");
	String address = in4.next();
	}
	
	public void professorChecklist()
	{
		System.out.println("Welcome Professor");
		System.out.println("**************************************");
		System.out.println("Select the option");
		System.out.println("1. View Enrolled Students"+"\n"+ "2. Add Grades"+"\n"+"3. View Course"+"\n");
		Scanner in4 = new Scanner(System.in);
		int option = in4.nextInt(); 
		switch(option)
		{
			case 1: System.out.println("View Enrolled Students"+"\n");
			//sI.courseSelection();
			break;

			case 2: System.out.println("Add Grades"+ "\n");
			/*SemesterRegistrationInterface sreg= new SemesterRegistrationImplService();
				sreg.semesterMenu(); */
			break;

			case 3: System.out.println("View Course"+"\n");
			//gI.viewGradeCard();
			break;
		}
	}
}
