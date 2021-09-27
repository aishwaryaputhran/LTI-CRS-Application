package com.lt.business;

import com.lt.bean.Course;
import com.lt.bean.SemesterRegistration;
import com.lt.dao.SemesterRegistrationDAOImpl;

public class RegisteredCourseImplService implements RegisteredCourseInterface
{
	  @Override 
	  public boolean getStudentDetails(int studentId, String name,int semester) 
	  {
		  SemesterRegistrationDAOImpl sd= new SemesterRegistrationDAOImpl();
	  
		  boolean isRegistered=false;
		  if(!sd.getRegisteredStudentById(studentId)) 
		  {
			  System.out.println("Student has registered already");
			  isRegistered=false; 
		  }
		  else
		  { 
			  sd.addRegisteredStudent(studentId,name,semester); 
			  isRegistered=true; 
		  }
		  return isRegistered;
	  }
	 

	@Override
	public String getCourseDetails() 
	{
		/*
		 * for(Course cs : sr.course1){
		 * 
		 * System.out.println("details of Course--> " +cs.getCourseId() + " "
		 * +cs.getCourseName()); }
		 */
		return "list course";
		
	}
}
