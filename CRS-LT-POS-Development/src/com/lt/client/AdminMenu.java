package com.lt.client;
import java.util.Scanner;

import org.apache.log4j.Logger;

import com.lt.business.AdminImplService;
import com.lt.business.AdminInterface;
import com.lt.dao.AdminDAOImpl;
import com.lt.dao.AdminDAOInterface;
import com.lt.dao.StudentDAOImpl;
import com.lt.dao.StudentDAOInterface;
import com.lt.exception.CourseFoundException;
import com.lt.exception.CourseNotFoundException;
/**
 * @author G4-FullStackGroup
 * Class that display AdminMenu
 */
public class AdminMenu 
{ 
	StudentDAOInterface daoStudent = StudentDAOImpl.getInstance();
	StudentMenu sm = new StudentMenu();
	Scanner in = new Scanner(System.in);
	/**
	 * Method to Create AdminMenu
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

		case 4: System.out.println("Thank you, visit again");
		break;

		default:System.out.println("***** Wrong Choice *****");
		}
	}
	/**
	 * Method to approve a Student
	 */
	public void approveStudent()
	{
		sm.viewnotApprovedStudent();
		AdminInterface admin=AdminImplService.getInstance();
		if(daoStudent.getNotApprovedStudentList().size() == 0) {
			System.out.println("all students are approved!!");
		}else {
			System.out.println("Enter StudentId");
			int studentId = in.nextInt();
			if(admin.approveStudent(studentId))
				System.out.println("Student Approved Successfully...");
		}

	}
	/**
	 * Method to add Professor to DB
	 */
	public void addProfessors()
	{
		AdminInterface admin= AdminImplService.getInstance();
		System.out.println("Enter Professor UserName to be added");
		String userName = in.next();
		System.out.println("Enter Professor Password");
		String profPassword = in.next();

		if(admin.addProfessor(userName, profPassword))
		{
			System.out.println("Professor Added Successfully..");
		}
		else
		{
			System.out.println("Professor "+userName+" is already present");
		}
	}
	/**
	 * Method to add or delete Course from course DB
	 * @throws CourseNotFoundException 
	 */
	public void editCourses()
	{
		AdminInterface admin=AdminImplService.getInstance();
		System.out.println("Select the option");
		System.out.println("1. Add Course"+"\n"+ "2. Drop Course"+"\n");
		Scanner in = new Scanner(System.in);
		int option = in.nextInt();

		if(option==1)
		{
			try {
				admin.addCourses();
			}
			catch(CourseFoundException e){
				System.out.println(e.getMessage());
			}

		}
		else if(option==2)
		{
			try {
				admin.deleteCourses();
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
