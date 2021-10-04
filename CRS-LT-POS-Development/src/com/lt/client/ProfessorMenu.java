package com.lt.client;

import java.util.List;
import java.util.Scanner;

import org.apache.log4j.Logger;

import com.lt.bean.Course;
import com.lt.business.ProfessorImplService;
import com.lt.business.ProfessorInterface;
import com.lt.exception.GradeNotAddedException;

/**
 * @author G4-FullStackGroup
 * Class that display Professor Menu
 */
public class ProfessorMenu {
	ProfessorInterface professorInterface=ProfessorImplService.getInstance();
	/**
	 * Method to create Professor Checklist
	 * @param profId: professor id obtained after logging into the system
	 * returns displays all the options for the professor, and provides navigation
	 */
	public void professorChecklist(String profId)
	{
		System.out.println("*************Welcome Professor************");
		System.out.println("******************************************");
		System.out.println("Select the option");
		System.out.println("1. View Registered Courses by Student"+"\n"+ "2. Add Grades"+"\n"+"3. View Course"+"\n"+"4. Logout"+"\n");

		//Display the options available for the Professor
		Scanner sc = new Scanner(System.in);

		//user input
		int option = sc.nextInt(); 
		switch(option)
		{
		case 1: System.out.println("View Registered Courses by Studens"+"\n");
		//view all the enrolled students for the course
		viewRegisteredCourses(profId);
		break;

		case 2: System.out.println("Add Grades"+ "\n");
		//add grade for a student
		addGrade();
		break;

		case 3: System.out.println("View Course"+"\n");
		//view all the courses approved by admin
		getCourses(profId);
		break;

		case 4: System.out.println("you are logged out");
		//logout from the system
		break;
		}
	}
	/**
	 * Method to view courses registered for Students
	 * @param profId
	 */
	public void viewRegisteredCourses(String profId)
	{
		try
		{
			if(professorInterface.getRegisteredCourses(profId)) {
				System.out.println("");
			}else {
				System.out.println("Something went wrong, try again later");
			}
		}
		catch(Exception ex)
		{
			System.out.println(ex.getMessage()+"Something went wrong, please try again later!");
		}
	}
	/**
	 * Method to get list of all Courses for Professor 
	 * @param profId
	 */
	public void getCourses(String profId)
	{
		try
		{
			List<Course> coursesEnrolled=professorInterface.getCourses(profId);
			System.out.println(String.format("%20s %20s","COURSE ID","COURSE NAME" ));
			System.out.println(String.format("%20s %20s","---------","-----------"));
			System.out.println(String.format("%20s %20s","COURSE ID","COURSE NAME"));
			System.out.println(String.format("%20s %20s","---------","-----------" ));
			for(Course obj: coursesEnrolled)
			{
				System.out.println(String.format("%20s %20s",obj.getCourseCode(), obj.getCourseName()));
				System.out.println(String.format("%20s %20s",obj.getCourseCode(), obj.getCourseName()));
			}		
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
			System.out.println("Something went wrong!");
		}
	}
	/**
	 * Method to add grade of student by professor
	 */
	public void addGrade()
	{
		Scanner sc=new Scanner(System.in);
		int studentId;
		String courseCode,grade,courseName;
		try
		{
			System.out.println("----------------Add Grade--------------");
			System.out.println("Enter course code");
			courseCode=sc.next();
			System.out.println("Enter course name");
			courseName=sc.next();
			System.out.println("Enter grade");
			grade=sc.next();
			System.out.println("Enter student id");
			studentId=sc.nextInt();

			professorInterface.addGrade(courseCode, courseName, grade,studentId);
			System.out.println("Grade added successfully for "+studentId);
		}
		catch(GradeNotAddedException ex)
		{
			System.out.println("Grade cannot be added for"+ex.getStudentId());

		}

	}
}
