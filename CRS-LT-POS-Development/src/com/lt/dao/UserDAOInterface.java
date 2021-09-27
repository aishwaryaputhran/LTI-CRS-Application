package com.lt.dao;

import java.util.List;

import com.lt.bean.User;

public interface UserDAOInterface 
{	
	public List<User> getUserCredential();
	public int verifyCredential(String username, String password);
	public boolean updateUserPassword(String username, String password);
	public boolean signupUser(String username, String password, int role);
}
