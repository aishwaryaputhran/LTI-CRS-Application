package com.lt.business;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.apache.log4j.Logger;

import com.lt.bean.Course;
import com.lt.bean.Student;
import com.lt.client.CRSApplication;
import com.lt.dao.CourseDAOImpl;
import com.lt.dao.StudentDAOImpl;
import com.lt.dao.UserDAOImpl;

/**
 * 
 * @author G4-FullStackGroup
 * Implementations of StudentImplService
 * 
 */
public class StudentImplService implements StudentInterface
{
	private static Logger logger = Logger.getLogger(StudentImplService.class);
	CRSApplication crs = new CRSApplication();
	StudentDAOImpl sDao=StudentDAOImpl.getInstance();
	UserDAOImpl uDao= UserDAOImpl.getInstance();
	GradeCardInterface gradeCard = GradeCardImplService.getInstance();
	CourseDAOImpl courseDAOImpl= CourseDAOImpl.getInstance();
	List<String> course = new ArrayList<String>();
	Course cc=new Course();
	List<Course> course1 = new ArrayList<Course>();

	private static volatile StudentImplService instance = null;

	private StudentImplService()
	{
	}
	/**
	 * Method to make StudentImplService Singleton
	 * @return
	 */
	public static StudentImplService getInstance()
	{
		if(instance == null)
		{
			synchronized(StudentImplService.class){
				instance = new StudentImplService();
			}
		}
		return instance;
	}

	/**
	 * Method to get StudentIId
	 * @return
	 */
	@Override
	public int getStudentId(String userName) {

		return sDao.getStudentId(userName);

	}
	/**
	 * Method to get login
	 * @return
	 */
	@Override
	public boolean login(String studentName, String studentPassword) 
	{
		boolean isLogin=false;
		//		for(User u: uDao.getUserCredential())
		//		{
		//
		//			if((u.getUsername().equals(studentName)) && (u.getPassword().equals(studentPassword)))
		//			{
		//				logger.info("Login Successfull"+"\n"); 
		//				isLogin=true;
		//				break;
		//			}				
		//		}

		return isLogin;

	}

	/**
	 * Method to courseSelection
	 * @return
	 */
	@Override
	public String courseSelection() 
	{
		Scanner in = new Scanner(System.in);
		logger.info("Select the below options to complete course registeration "); 
		logger.info("1. Add course"+" \n"+ "2. Drop course"+"\n"+"3. Exit");
		int option = in.nextInt();

		switch(option)
		{
		case 1:	logger.info("Add course");
				if(addCourse()==true)
				{
					logger.info("Course added and registered sucessfully");
					}
				break;

		case 2: logger.info("Drop course");
				if(dropCourse()==true)
				{
					logger.info("Course has been deleted from your list");
				}
				break;

		case 3:  logger.info("Exit");
				break;

		}
		return null;
	}
	/**
	 * Method to payFee
	 * @return
	 */
	@Override
	public String payFee() 
	{
		// TODO Auto-generated method stub
		return null;
	}
	/**
	 * Method to signup
	 * @param username,password,contact,email,address,branch.
	 * @throws StudentNotFoundException 
	 */
	@Override
	public boolean signup(String username,String password, long contact, String email, String address, String branch) throws Exception
	{	
		boolean isSignup1=true;
		//		for(User uc: uDao.getUserCredential())
		//		{
		//			if(uc.getUsername().equals(username))
		//			{
		//				logger.info("Username already exist"+"\n"); 
		//				isSignup1=false;
		//				break;
		//			}
		//		} 
		if(isSignup1==true)
		{	
			int studentId = generateStudentId();
			Student student = new Student(studentId, username, email, address, branch, contact);
			sDao.signup(student);
			uDao.signupUser(username, password,1);
			//	uDao.getUserCredential();
			logger.info("UserProfile is created SucessFully!!! Please login...."+ "\n");
			crs.login();

		} 
		return isSignup1;

	}
	/**
	 * Method to addCourse
	 * @throws CourseNotFoundException 
	 */
	@Override
	public boolean addCourse() 
	{
		logger.info("Please select the courseID fromt the below list");

		for (Course c : courseDAOImpl.getCourse()) 
		{
			logger.info(c.getCourseCode()+" " + c.getCourseName()); 
		}
		for(int i=0; i<6; i++)
		{
			Scanner in = new Scanner(System.in);
			logger.info("Enter course Id: "); 
			String courseId = in.next();
			logger.info("Enter course Name: "); 
			String courseName = in.next();
			course1.add(new Course(courseId,courseName));
		}

		return true;

	}

	/*
	 * Method to dropCourse
	 * @throws CourseNotFoundException 
	 */
	@Override
	public boolean dropCourse() 
	{
		logger.info("Please select the courseID fromt the below list");

		for (Course c : course1) 
		{
			logger.info(c.getCourseCode()+" " + c.getCourseName());  
		}

		Scanner in = new Scanner(System.in);
		logger.info("Select the courseID to be deleted "); 
		String courseId = in.next();
		logger.info("Enter course Name: "); 
		String courseName = in.next();

		for (Course c : course1) 
		{
			if(c.getCourseCode()==courseId || c.getCourseName()==courseName)
			{
				course1.remove(c);
				logger.info("Course has been removed");
				logger.info(course1);
			}
			else
				continue;	  

		}

		return true;

	}

	@Override
	public String viewGradeCard() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int generateStudentId() {
		return sDao.getStudentCount()+1;

	}

	@Override
	public boolean isApproved(int StudentId){
		return sDao.isApproved(StudentId);
	}


}