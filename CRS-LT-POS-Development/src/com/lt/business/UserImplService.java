package com.lt.business;
import java.sql.SQLException;

import org.apache.log4j.Logger;

import com.lt.dao.UserDAOImpl;
import com.lt.exception.UserNotFoundException;

/**
 * 
 * @author G4-FullStackGroup
 * Implementations of UserImplService from UserInterface
 * 
 */
public class UserImplService implements UserInterface
{
	private static volatile UserImplService instance = null;
	private static Logger logger = Logger.getLogger(UserImplService.class);
	private UserImplService()
    {
    }
    /**
    * Method to make UserImplService Singleton
    * @return
    */
    public static UserImplService getInstance()
    {
    if(instance == null)
    {
    synchronized(UserImplService.class){
    instance = new UserImplService();
    }
    }
    return instance;
    }

	UserDAOImpl userDAOImpl=UserDAOImpl.getInstance();
	
	 /**
	    * Method to make login
	    * @return
	    */
	@Override
	public boolean login(String username, String password) throws SQLException
	{
		
		return userDAOImpl.verifyCredential(username, password);
	}

	@Override
	public String viewRole() {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public boolean updatePassword(String username, String newPassword) 
	{
		return userDAOImpl.updateUserPassword(username, newPassword);
	}

	@Override
	public boolean verifyCredentials(String userID, String password) throws UserNotFoundException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String signup(String username, String password, Object role) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean signup(int id, String name, String role, String password, int contact, String email,
			String address) {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public String getRole(String userId) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}



}