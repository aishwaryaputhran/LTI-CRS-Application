package com.lt.business;

import java.util.List;

import com.lt.constants.Gender;
import com.lt.exception.StudentNotRegisteredException;

public interface StudentInterface {
		/**
		 * Method to register a student, although student can't login until it's approved by admin
		 * @param username
		 * @param password
		 * @param contact
		 * @param email
		 * @param branch
		 * @param address
		 * @return boolean value 
		 * @throws StudentNotRegisteredException
		 */
	
	public boolean signup(String username,String password, long contact, String email, String address, String branch) throws Exception;
		public boolean login(String studentName, String studentPassword);
		
		/*
		 * Method to viewGradeCard
		 * 
		 */
		public String viewGradeCard();
		/*
		 * Method to get courseSelection 
		 */
		public String courseSelection();
		/*
		 * Method to get payFee
		 * 
		 */
		public String payFee();
		/*
		 * Method to addCourse
		 * 
		 */
		public boolean addCourse();
		/*
		 * Method to dropCourse
		 * @return boolean value if it is dropped or not
		 */
		public boolean dropCourse();
		/*
		 * Method to get StudentId
		 * @param userName
		 * @return studentId
		 */
		int getStudentId(String userName);
		/*
		 * Method to get generateStudentId
		 * 
		 */
		int generateStudentId();
		/*
		 * Method to get isApproved
		 * @param StudentId
		 */
		boolean isApproved(int StudentId);
}
	
