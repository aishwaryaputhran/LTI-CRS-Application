package com.lt.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.lt.bean.Student;
import com.lt.bean.User;
import com.lt.util.DBUtils;

public class StudentDAOImpl implements StudentDAOInterface
{	
	static int counter=100;
	//Student student= new Student();
	public static List<Student> studentList= new ArrayList<Student>();
	
	public List<Student> getStudentList()
	{
		counter++;
		Connection conn = DBUtils.getConnection();
		try 
		{
				String username =""; 
	            Long contact = 0l;
	            String address="";
	            String email="";
	            int approved=0;
				String str = "select * from student";
				PreparedStatement myStmt = conn.prepareStatement(str);
				ResultSet myRs = myStmt.executeQuery();
				
				while(myRs.next())
				{
					counter = myRs.getInt(1);
					username = myRs.getString(2);
	                contact = myRs.getLong(3);
	                email = myRs.getString(4);
	                address = myRs.getString(5);
	                approved=myRs.getInt(6);
	                studentList.add(new Student(counter,username,contact,email,address,approved));
				}
			
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
		return studentList; 
	}
	
	public boolean signup(String username,String password, long contact, String email, String address)
	{
		int approval=0;
		Connection conn = DBUtils.getConnection();
		try 
		{
				String str = "insert into student (studentID,name,contactNo,emalID,address,isApproved) values (?,?,?,?,?,?)";
				PreparedStatement myStmt = conn.prepareStatement(str);
				myStmt.setInt(1, counter);
				myStmt.setString(2, username);
				myStmt.setLong(3, contact);
				myStmt.setString(4, email);
				myStmt.setString(5, address);
				myStmt.setInt(6, approval);
				
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
	/*
	 * @Override public boolean isApproved(int studentId) { Connection
	 * connection=DBUtils.getConnection(); try { PreparedStatement statement =
	 * connection.prepareStatement(SQLQueriesConstants.IS_APPROVED);
	 * statement.setInt(1, studentId); ResultSet rs = statement.executeQuery(); //
	 * to be debugged later if(rs.next()) { return rs.getBoolean("isApproved"); }
	 * 
	 * } catch(SQLException e) { logger.error(e.getMessage()); }
	 * 
	 * return false; }
	 */

}
