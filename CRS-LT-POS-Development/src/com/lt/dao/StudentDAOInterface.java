package com.lt.dao;

import java.sql.SQLException;

import com.lt.bean.Student;
import com.lt.exception.StudentNotRegisteredException;



/**
 * 
 * @author JEDI-03
 * Interface for Student Operations
 *
 */
import java.util.List;

import com.lt.bean.Student;

/**
 * @author G4-FullStackGroup
 * Interface for StudentDAO
 *
 */
public interface StudentDAOInterface 
{
	/**
	 * Method to get Not Approved Student List
	 * 
	 */
	public List<Student> getNotApprovedStudentList();
	/**
	 * Method to get StudentId
	 * @param userName
	 */
	public int getStudentId(String userName);
	/**
	 * Method for sign up
	 * @param student
	 * @throws Exception
	 */
	public boolean signup(Student student) throws Exception;
}