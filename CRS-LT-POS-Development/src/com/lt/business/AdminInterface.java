package com.lt.business;

import com.lt.exception.CourseFoundException;
import com.lt.exception.CourseNotFoundException;

/**
 * 
 * @author G4-FullStackGroup
 * Interface for Admin Operations
 * 
 */
public interface AdminInterface 
{
	
	/**
	 * Method to add Professor to DB
	 * @param professor : Professor Object storing details of a professor
	 */
	public boolean addProfessor(String name,String password, Long contact, String emailId, String address);
	
	/**
	 * Method to approve a Student 
	 * @param studentId
	 * @throws StudentNotFoundException 
	 */
	public void approveStudent(String studentName);
	
	/**
	 * Method to add Course from Course Catalog
	 * @param course : Course object storing details of a course
	 * @throws CourseFoundException 
	 */
	public void addCourses() throws CourseFoundException;
	
	/**
	 * Method to Delete Course from Course 
	 * @param courseCode
	 * @throws CourseNotFoundException 
	 */
	public boolean deleteCourses() throws CourseNotFoundException;
}
