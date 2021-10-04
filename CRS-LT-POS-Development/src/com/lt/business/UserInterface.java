package com.lt.business;

import java.sql.SQLException;

import com.lt.exception.UserNotFoundException;
/**
 * 
 * @author G4-FullStackGroup
 * Interface for UserInterface Operations
 * 
 */
public interface UserInterface{
	/*
	 * Method to update password of a user
	 * @param userID
	 * @param newPassword
	 * @return
	 */
	public boolean updatePassword(String username, String password);

	/*
	 * Method to verify User credentials
	 * @param userId
	 * @param password
	 */
	public boolean verifyCredentials(String userID,String password) throws UserNotFoundException;

	/*
	 * Method to get role of a specific User
	 * @param userId
	 * @return Role of the User
	 */
	String signup(String username, String password, Object role);

	boolean signup(int id,String name,String role,String password,int contact,String email,String address);
	/*
	 * Method to get role of a specific User
	 * @return Role of the User
	 */		
	public String viewRole();
	
	
	String getRole(String userId) throws Exception;

	
	boolean login(String username, String password) throws SQLException;

}