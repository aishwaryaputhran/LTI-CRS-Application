package com.lt.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.lt.bean.Student;
import com.lt.bean.User;
import com.lt.exception.UserNotFoundException;
import com.lt.util.DBUtils;
import com.mysql.jdbc.EscapeTokenizer;
import com.mysql.jdbc.Statement;

public class UserDAOImpl implements UserDAOInterface {
	
	//private static Logger logger = Logger.getLogger(UserDAOImpl.class);

	public static List<User> userList = new ArrayList<User>();

	public List<User> getUserCredential() 
	{	
		Connection conn = DBUtils.getConnection();
		try 
		{
				String str = "select * from user";
				PreparedStatement myStmt = conn.prepareStatement(str);
				ResultSet myRs = myStmt.executeQuery();
				
				while(myRs.next())
				{
					String username = myRs.getString(1);
					String  password= myRs.getString(2);
					int roleID= myRs.getInt(3);
					userList.add(new User(username,password,roleID));
				}	
				
				return userList;
		} 
		catch (SQLException ex) 
		{
			System.out.println("Exception occurred....");
		} 
		finally
		{
			try
			{
				conn.close();
			} 
			catch (SQLException e)
			{
				e.printStackTrace();
			}
			
		}
		return userList; 
	}

	public boolean signupUser(String username, String password, int role) 
	{
		User user = new User();
		/*
		 * getUserCredential(); user.setUsername(username); user.setPassword(password);
		 * // user.setRole(role); userList.add(user);
		 */
		Connection conn = DBUtils.getConnection();
		try 
		{
			String str = "insert into user (username,password,roleID) values (?,?,?)";
			PreparedStatement myStmt = conn.prepareStatement(str);
			myStmt.setString(1, username);
			myStmt.setString(2, password);
			myStmt.setInt(3, role);
			myStmt.executeUpdate();
			
			System.out.println(username+" "+"added sucessfully");
		} 
		catch (SQLException ex) 
		{
			ex.printStackTrace();
			System.out.println("Exception occurred....");
		} 
		finally
		{
			try
			{
				conn.close();
			} 
			catch (SQLException e)
			{
				e.printStackTrace();
			}
			
		}
		return true;
	}

	public int verifyCredential(String loginUsername, String loginpassword)
	{
		int value = 0;
		Connection conn = DBUtils.getConnection();
		try 
		{
			String str = "select password, roleID from user where username=?";
			PreparedStatement myStmt = conn.prepareStatement(str);
			myStmt.setString(1, loginUsername);
			ResultSet myRs = myStmt.executeQuery();
			
			myRs.next();
			if(loginpassword.equals(myRs.getString("password")))
			{ 	
				value = myRs.getInt("roleID");
			}
			else
			{
				return value;
			}	
		} 
		catch (SQLException ex) 
		{
			System.out.println("Exception occurred....");
		} 
		finally
		{
			try
			{
				conn.close();
			} 
			catch (SQLException e)
			{
				e.printStackTrace();
			}	
		}
		return value; 
	}

	public boolean updateUserPassword(String username, String newPassword) 
	{
		Connection conn = DBUtils.getConnection();
		try 
		{
			String str = "update user set password = ? where username=?";
			PreparedStatement myStmt = conn.prepareStatement(str);
			myStmt.setString(1, newPassword);
			myStmt.setString(2, username);	
			myStmt.executeUpdate();
		} 
		catch (SQLException ex) 
		{
			System.out.println("Exception occurred....");
		} 
		finally
		{
			try
			{
				conn.close();
			} 
			catch (SQLException e)
			{
				e.printStackTrace();
			}
			
		} 
		return true;
	}	
}
