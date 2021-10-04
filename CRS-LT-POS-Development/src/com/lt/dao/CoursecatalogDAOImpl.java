package com.lt.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.lt.bean.Admin;
import com.lt.bean.Catlog;
import com.lt.bean.Course;
import com.lt.util.DBUtils;

public class CoursecatalogDAOImpl implements CoursecatalogDAOInterface
{
	static List<Catlog> catalogList= new ArrayList<>();
	@Override
	public List<Catlog> viewCourses()
	{
		Connection conn = DBUtils.getConnection();
		try 
		{
				String str = "select * from courseCatalog";
				PreparedStatement myStmt = conn.prepareStatement(str);
				ResultSet myRs = myStmt.executeQuery();
				
				while(myRs.next())
				{
					int courseId = myRs.getInt(1); 
	                String courseName = myRs.getString(2);
	                catalogList.add(new Catlog(courseId,courseName));	
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
		return catalogList; 
		
	}
	

}
