
package com.lt.dao;
import java.util.List;

import com.lt.bean.SemesterRegistration;
/**
 * @author G4-FullStackGroup
 * Interface for SemesterRegistrationDAO
 *
 */
public interface SemesterRegistrationDAOInterface 
{ 	
	/**
	 * Method to get SemFee
	 * @param key
	 */
	public void getSemFee(int key);
	/**
	 * Method get list of RegisteredStudent
	 * 
	 */
	public List<SemesterRegistration> getRegisteredStudent();
	/**
	 * Method get get RegisteredStudent By Id
	 * @param studentId
	 */	
	public boolean getRegisteredStudentById(int studentId);
	/**
	 * Method add Registered Student
	 * @param studentId,studentName,semester
	 */
	public boolean addRegisteredStudent(int studentId, String studentName, int semester);

}