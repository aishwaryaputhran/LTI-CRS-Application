package com.lt.business;

import java.sql.SQLException;
import java.util.List;

import com.lt.bean.Course;
import com.lt.bean.RegisteredCourse;

/**
 * 
 * @author G4-FullStackGroup
 * Interface for RegisteredCourseInterface 
 * 
 */
public interface RegisteredCourseInterface 
{
	/**
	  * Method to get StudentDetails
	  * 
	  */
	public boolean getStudentDetails(int studentId, String name,int semester);
	  /**
	    * Method to getCourseDetails
	    * 
	    */
	public String getCourseDetails();
	
	/**
	 * Method to viewRegCourses
	 * @param studentId
	 */
	List<RegisteredCourse> viewRegCourses(int studentId) throws SQLException;
	/**
	 * Method to dropCourse
	 * @param courseCode,studentId,registeredCourseList
	 */
	public boolean dropCourse(String courseCode, int studentId, List<RegisteredCourse> registeredCourseList);
	/**
	 * Method to addCourse
	 * @param courseCode,studentId,registeredCourseList
	 */
	boolean addCourse(String courseCode, int studentId, List<Course> courseList,
			List<RegisteredCourse> registeredCourseList);
	
	
	
	
}
