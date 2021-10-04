package com.lt.dao;

import java.sql.SQLException;
import java.util.List;

import com.lt.bean.User;
/*
 * @author G4-FullStackGroup
 * Interface for UserDAO 
 *
 */
public interface UserDAOInterface 
{	
	/*
	 * Method to sign up User
	 * @param username,password,role
	 *
	 */
	public boolean signupUser(String username,String password, int role);
	/*
	 * Method to verifyCredential
	 * @param username,password
	 * @throws Exception
	 */
	public boolean verifyCredential(String username, String password) throws Exception;
	/*
	 * Method to updateUserPassword
	 * @param username,password
	 * 
	 */
	public boolean updateUserPassword(String username, String password);
	/*
	 * Method to get Role
	 * @param userId
	 * @throws SQLException
	 */
	String getRole(String userId) throws SQLException;
	/*
	 * Method to get UserCredential
	 * 
	 */
	List<User> getUserCredential();
}