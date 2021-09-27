package com.lt.business;

import java.util.Scanner;


import com.lt.bean.User;
import com.lt.dao.UserDAOImpl;

public class UserImplService implements UserInterface
{
	
	
	@Override
	public int login(String username, String password)
	{
		UserDAOImpl userDAOImpl= new UserDAOImpl();
		 int roleID=0;
		 if(userDAOImpl.verifyCredential(username, password)!=0)
		 {
			 roleID=userDAOImpl.verifyCredential(username, password);
		 }
		 return roleID;
	}

	@Override
	public String viewRole() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updatePassword(String uname, String pwrd) 
	{
		
		UserDAOImpl ud= new UserDAOImpl();
	    
	    if(ud.updateUserPassword(uname,pwrd))
	    {
	    	System.out.println("Password updated successfully");
	    }
	    else
	 	    System.out.println("Username not found, please enter the correct username");	 		
	}

}
