package com.lt.client;

import java.util.Scanner;

import org.apache.log4j.Logger;

import com.lt.business.AdminImplService;
import com.lt.business.AdminInterface;
import com.lt.exception.CourseFoundException;
import com.lt.exception.CourseNotFoundException;

/**
 * 
 * @author G4-FullStackGroup
 * Class that display Admin Client Menu
 * 
 */
public class AdminMenu 
{ 
	private static Logger logger = Logger.getLogger(AdminMenu.class);
	
	Scanner in = new Scanner(System.in);
	
	
	/**
	 * Method to Create Admin Menu
	 */
    public void adminChecklist()
    {
    	System.out.println("\n"+"Welcome Admin");
    	System.out.println("**************************************");
    	System.out.println("Select the option");
    	System.out.println("1. Approve Student"+"\n"+ "2. Add Professor"+"\n"+"3. Edit course"+"\n"+"4.Exit"+"\n");
		int option = in.nextInt(); 
		
		switch(option)
		{
			case 1: approveStudent();
					break;

			case 2: addProfessors();
					break;

			case 3: editCourses();
					break;
			
			case 4: logger.warn("Thank you, visit again");
					break;
					
			default:logger.warn("***** Wrong Choice *****");
		}
    }
    
    /**
	 * Method to approve a Student
	 */
    public void approveStudent()
    {
    	AdminInterface admin1= new AdminImplService();
    	System.out.println("Enter StudentName");
		String studentName = in.next();
		admin1.approveStudent(studentName);
		
    }
    
    /**
	 * Method to add Professor to DB
	 */
    public void addProfessors()
    {
    	AdminInterface admin2= new AdminImplService();
    	System.out.println("Enter Professor Name to be added");
		String profName = in.next();
		System.out.println("Enter Professor Password");
		String profPassword = in.next();
		System.out.println("Enter Professor Contact");
		Long profContact = in.nextLong();
		System.out.println("Enter Professor EmailId");
		String profEmailId = in.next();
		System.out.println("Enter Professor Address	");
		String profAddress = in.next();
		
		
		if(admin2.addProfessor(profName, profPassword, profContact, profEmailId, profAddress))
		{
			System.out.println("Professor added");
		}
		else
		{
			System.out.println("Professor "+profName+"mail Id is already present");
		}
    }
    
    /**
	 * Method to add or delete Course from course DB
	 * @throws CourseNotFoundException 
	 */
    public void editCourses()
    {
    	AdminInterface admin3= new AdminImplService();
    	System.out.println("Select the option");
		System.out.println("1. Add Course"+"\n"+ "2. Drop Course"+"\n");
		Scanner in5 = new Scanner(System.in);
		int option = in5.nextInt();
		
		if(option==1)
		{
			try {
				admin3.addCourses();}
			catch(CourseFoundException e){
				System.out.println(e.getMessage());}
			
		}
		else if(option==2)
		{
			try {
				if(admin3.deleteCourses())
					{
						System.out.println("Course deleted");
					}
				
				else
				{
					System.out.println("course not deleted, please enter the correct course name");
				}
			}
			catch(CourseNotFoundException e){
				System.out.println(e.getMessage());
			}
		}
		else
		{
			System.out.println("You have entered the wrong choice");
		}
		
    }
}
    

