package com.lt.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.lt.bean.Admin;
import com.lt.bean.Catlog;
import com.lt.bean.Student;
import com.lt.bean.User;
import com.lt.business.CourseInterface;
import com.lt.exception.CourseFoundException;
import com.lt.exception.CourseNotFoundException;
import com.lt.util.DBUtils;

/**
 * @author G4-FullStackGroup
 * Dao Class Operations for Admin
 * 
 */
public class AdminDAOImpl implements AdminDAOInterface
{
	private static Logger logger = Logger.getLogger(AdminDAOImpl.class);
	
	static List<Admin> adminList= new ArrayList<Admin>();
	/*
	 * @Override public List<Admin> getAdminCredential() { Connection conn =
	 * DBUtils.getConnection(); try { String adminname =""; String password="";
	 * String str = "select * from admin"; PreparedStatement myStmt =
	 * conn.prepareStatement(str); ResultSet myRs = myStmt.executeQuery();
	 * 
	 * myRs.next();
	 * 
	 * adminname = myRs.getString(1); password = myRs.getString(2);
	 * adminList.add(new Admin(adminname,password)); } catch (SQLException ex) {
	 * logger.info("Exception occurred...."); } finally { try { conn.close();
	 * } catch (SQLException e) { e.printStackTrace(); }
	 * 
	 * } return adminList; }
	 */
	
	/**
	 * Approve Student using SQL commands
	 * @param studentName
	 * @throws StudentNotFoundException
	 */
	@Override
	public boolean adminApproval(String studentName) 
	{
		boolean check=false;
		Connection conn = DBUtils.getConnection();
		try 
		{
				String str = "update student set isApproved = 1 where name = ?";
				PreparedStatement myStmt = conn.prepareStatement(str);
				myStmt.setString(1, studentName);
				myStmt.executeUpdate();	
				check=true;
		} 
		catch (SQLException ex) 
		{
			logger.info("Exception occurred....");
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
		return check;
	}

	/*
	 * @Override public void addprofessor(int profId, String name, Long contact,
	 * String emailId, String address) { Connection conn = DBUtils.getConnection();
	 * try { String str =
	 * "insert into professor (professorID,Name,Contact,emailID,address) values (?,?,?,?,?)"
	 * ; PreparedStatement myStmt = conn.prepareStatement(str); myStmt.setInt(1,
	 * profId); myStmt.setString(2,name); myStmt.setLong(3, contact);
	 * myStmt.setString(4,emailId); myStmt.setString(5,address);
	 * myStmt.executeUpdate(); } catch (SQLException ex) {
	 * logger.info("Exception occurred...."); } finally { try { conn.close();
	 * } catch (SQLException e) { e.printStackTrace(); } } }
	 */
	
	/**
	 * Add Course using SQL commands
	 * @param courseId,courseName
	 * @throws CourseFoundException
	 */
	@Override
	public boolean addCourse(int courseId, String courseName) throws CourseFoundException
	{
		boolean checkCourse=false;
		Connection conn = DBUtils.getConnection();
		try 
		{
			String str = "insert into course (courseId, courseName) values (?,?)";
			PreparedStatement myStmt = conn.prepareStatement(str);
			myStmt.setInt(1, courseId);
			myStmt.setString(2,courseName);
			myStmt.executeUpdate();
		    System.out.println("Course"+" "+courseName+" "+"added sucessfully");
		    checkCourse=true;
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
		return checkCourse;
	}
	
	/**
	 * Delete Course using SQL commands
	 * @param courseId, courseName
	 * @throws CourseNotFoundException
	 */
	@Override
	public boolean deleteCourse(int courseId, String courseName) throws CourseNotFoundException
	{
		boolean courseDelete=false;
		Connection conn = DBUtils.getConnection();
		try 
		{
			String str = "delete from course where courseId=?";
			PreparedStatement myStmt = conn.prepareStatement(str);
			myStmt.setInt(1, courseId);
			int check=myStmt.executeUpdate();
			if(check == 0)
			{
				return courseDelete;
			}
			else
			{
			courseDelete=true;
			}
			return courseDelete;
		} 
		catch (SQLException ex) 
		{
			logger.info("Exception occurred....");
		} 
		catch(Exception e)
		{
			logger.info("Something went wrong!!!");
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
		return courseDelete;
	}	 
}

