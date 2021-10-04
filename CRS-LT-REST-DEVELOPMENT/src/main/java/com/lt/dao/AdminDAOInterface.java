package com.lt.dao;

import java.util.List;

import com.lt.bean.Professor;
import com.lt.exception.CourseFoundException;
import com.lt.exception.CourseNotFoundException;
import com.lt.exception.ProfessorNotAddedException;

/**
 * @author G4-FullStackGroup
 * Interface for Admin Dao Operations
 *
 */
public interface AdminDAOInterface 
{
	//public List<Admin> getAdminCredential();
	
	/**
	 * Approve Student using SQL commands
	 * @param studentName
	 * @throws StudentNotFoundException
	 */
	public boolean adminApproval(int studentId);
	//public void addprofessor(int ProfId, String name, Long contact, String emailId, String address);
	/**
	 * Add Course using SQL commands
	 * @param courseId,courseName
	 * @throws CourseFoundException
	 */
	public boolean addCourse(String courseCode, String courseName, double courseFee) throws CourseFoundException;
	
	/**
	 * Delete Course using SQL commands
	 * @param courseId,courseName
	 * @throws CourseNotFoundException
	 */
	public boolean deleteCourse(String courseId, String courseName) throws CourseNotFoundException;
	/**
	 * to get the list of professor added using SQL commands
	 */
	List<Professor> getProfessor();
}








