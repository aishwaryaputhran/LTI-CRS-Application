package com.lt.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.lt.bean.Catlog;
import com.lt.utils.DBUtil;

/*
 * @author G4-FullStackGroup
 * Dao Class for CoursecatalogDAO implementation
 * 
 */
public class CoursecatalogDAOImpl implements CoursecatalogDAOInterface
{
	private static volatile CoursecatalogDAOImpl instance = null;
	
	private static Logger logger = Logger.getLogger(CoursecatalogDAOImpl.class);
	
	private CoursecatalogDAOImpl()
	{
	}
	/*
	 * Method to make CoursecatalogDAOImpl Singleton
	 * @return
	 */
	public static CoursecatalogDAOImpl getInstance()
	{
		if(instance == null)
		{
			synchronized(CoursecatalogDAOImpl.class){
				instance = new CoursecatalogDAOImpl();
			}
		}
		return instance;
	}

	/*
	 * Method to view list of Course catalog 
	 * @returns list of catalog
	 */
	static List<Catlog> catalogList= new ArrayList<>();
	@Override
	public List<Catlog> viewCourses()
	{
		Connection conn = DBUtil.getConnection();
		try 
		{
			String str = "select course_code, course_name, course_fee from course_catalog";
			PreparedStatement myStmt = conn.prepareStatement(str);
			ResultSet myRs = myStmt.executeQuery();

			while(myRs.next())
			{
				String courseCode = myRs.getString(1); 
				String courseName = myRs.getString(2);
				double courseFee = myRs.getDouble(3); 
				catalogList.add(new Catlog(courseCode,courseName,courseFee));	
			}
		} 
		catch (SQLException ex) 
		{
			logger.error("Exception occurred....");
		} 

		return catalogList; 

	}


}