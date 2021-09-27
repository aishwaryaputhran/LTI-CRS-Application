package com.lt.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.lt.bean.Catlog;
import com.lt.bean.Course;
import com.lt.util.DBUtils;

public class CourseDAOImpl implements CourseDAOInterface
{
	List<Course> course = new ArrayList<Course>();
	public List<Course> getCourse() 
	{
		Connection conn = DBUtils.getConnection();
		try 
		{
				int courseId=0;
				String coursename="";
				String str = "select * from course";
				PreparedStatement myStmt = conn.prepareStatement(str);
				ResultSet myRs = myStmt.executeQuery();
				
				while(myRs.next())
				{
					courseId = myRs.getInt(1); 
	                coursename = myRs.getString(2);
	                course.add(new Course(courseId,coursename));	
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
		return course; 
		
	}

	/*
	 * public String addCourse() { Scanner in = new Scanner(System.in);
	 * System.out.println("Enter course Id: "); String courseId = in.next();
	 * System.out.println("Enter course Name: "); String courseName = in.next();
	 * //course.add(new Course(courseId, courseName));
	 * 
	 * return "updated successfully"; }
	 */

}
