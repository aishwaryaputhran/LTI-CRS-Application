package com.lt.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.lt.bean.Admin;
import com.lt.exception.CourseFoundException;
import com.lt.exception.CourseNotFoundException;
import com.lt.utils.DBUtil;

/*
 * @author G4-FullStackGroup
 * Dao Class Operations for AdminDAOImpl
 * 
 */
public class AdminDAOImpl implements AdminDAOInterface
{
	private static volatile AdminDAOImpl instance = null;

	private static Logger logger = Logger.getLogger(AdminDAOImpl.class);

	static List<Admin> adminList= new ArrayList<Admin>();

	public AdminDAOImpl(){

	}
	/**
	 * Method to make AdminDAOImpl Singleton
	 * @return
	 */
	public static AdminDAOImpl getInstance()
	{
		if(instance==null)
		{
			synchronized(AdminDAOImpl.class) {
				instance=new AdminDAOImpl();
			}
		}
		return instance;
	}



	/**
	 * Approve Student from AdminDAOImpl  using SQL commands
	 * @param studentId
	 * @throws StudentNotFoundException
	 */
	@Override
	public boolean adminApproval(int studentId) 
	{

		Connection conn = DBUtil.getConnection();
		try 
		{
			String str = "update student set isapproved = 1 where student_id = ?";
			PreparedStatement myStmt = conn.prepareStatement(str);
			myStmt.setInt(1, studentId);
			int row = myStmt.executeUpdate();	
			if(row==1)
				return true;
			else
				return false;
		} 
		catch (SQLException ex) 
		{
			logger.error("Exception occurred....");
		} 
		return false;
	}


	/**
	 * Method for Add Course using SQL commands
	 * @param courseCode,courseName,courseFee
	 * @throws CourseFoundException
	 */
	@Override
	public boolean addCourse(String courseCode, String courseName, double courseFee) throws CourseFoundException
	{

		Connection conn = DBUtil.getConnection();
		try 
		{
			String str = "insert into course (course_code, course_name, course_fee) values (?,?,?)";
			PreparedStatement myStmt = conn.prepareStatement(str);
			myStmt.setString(1, courseCode);
			myStmt.setString(2,courseName);
			myStmt.setDouble(3, courseFee);
			int row = myStmt.executeUpdate();
		    logger.info("Course"+" "+courseName+" "+"added sucessfully");
			if(row==1)
				return true;
			else
				return false;
		} 
		catch (SQLException ex) 
		{
			logger.info("Exception occurred....");
		} 

		return false;
	}

	/**
	 * Method for Delete Course using SQL commands
	 * @param courseId, courseName
	 * @throws CourseNotFoundException
	 */
	@Override
	public boolean deleteCourse(String courseId, String courseName) throws CourseNotFoundException
	{

		Connection conn = DBUtil.getConnection();
		try
		{
			String str = "delete from course where course_code=?";
			PreparedStatement myStmt = conn.prepareStatement(str);
			myStmt.setString(1, courseId);

			int check=myStmt.executeUpdate();
			if(check == 1)
			{
				return true;
			}
			else
			{
				return false;
			}
		}
		catch (SQLException ex)
		{
			logger.error("Exception occurred....");
		}
		catch(Exception e)
		{
			logger.error("Something went wrong!!!");
		}

		return false;

	}
}