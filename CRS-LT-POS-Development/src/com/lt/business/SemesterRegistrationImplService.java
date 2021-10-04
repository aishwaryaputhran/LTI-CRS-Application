package com.lt.business;
import java.util.Scanner;

import org.apache.log4j.Logger;

import com.lt.dao.SemesterRegistrationDAOImpl;

/*
 * 
 * @author G4-FullStackGroup
 * Interface for SemesterRegistrationImplService 
 * 
 */
public class SemesterRegistrationImplService implements SemesterRegistrationInterface 
{
	private static Logger logger = Logger.getLogger(SemesterRegistrationImplService.class);
	static int counter=100;

	/**
	 * Method to semesterMenu
	 * 
	 */
	public void semesterMenu() 
	{
		PaymentInterface pi = PaymentImplService.getInstance();
		SemesterRegistrationDAOImpl sm = SemesterRegistrationDAOImpl.getInstance();
		RegisteredCourseInterface rm= RegisteredCourseImplService.getInstance();

		if(sm.getRegisteredStudentById(counter))
		{
			counter++;
		}
		logger.info("Your studentID is:"+" "+ counter);
		Scanner in = new Scanner(System.in);
		logger.info("Enter student Name: ");
		String stdName = in.next();
		logger.info("Choose the Semester:-");
		logger.info("1. Semester-1"+"\n"+"2. Semester-2"+"\n"+"3. Semester-3"+"\n"+"4. Semester-4"+"\n"+"5. Exit");
		int selection = in.nextInt();


		switch(selection)
		{
		case 1: logger.info("Semester-1:-");
		if(rm.getStudentDetails(counter, stdName, selection))
		{
			sm.getSemFee(selection);

		}
		break;

		case 2: logger.info("Semester-2:-");
		if(rm.getStudentDetails(counter, stdName, selection))
		{
			sm.getSemFee(selection);

		}
		break;


		case 3: logger.info("Semester-3:-");
		if(rm.getStudentDetails(counter, stdName, selection))
		{
			sm.getSemFee(selection);

		}
		break;


		case 4: logger.info("Semester-4:-");
		if(rm.getStudentDetails(counter, stdName, selection))
		{
			sm.getSemFee(selection);

		}
		break;


		case 5: logger.info("Exit");
		break;

		}
	}
}