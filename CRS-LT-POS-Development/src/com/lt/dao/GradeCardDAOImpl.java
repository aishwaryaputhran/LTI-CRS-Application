package com.lt.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.lt.bean.GradeCard;
import com.lt.constants.Grade;
import com.lt.utils.DBUtil;


/*
 * @author G4-FullStackGroup
 * Dao Class for GradeCardDAOImpl
 * 
 */
public class GradeCardDAOImpl implements GradeCardDAOInterface
{
	private static Logger logger = Logger.getLogger(GradeCardDAOImpl.class);
	private static volatile GradeCardDAOImpl instance = null;

	private GradeCardDAOImpl()
	{
	}
	/**
	 * Method to make GradeCardDAOImpl Singleton
	 * @return
	 */
	public static GradeCardDAOImpl getInstance()
	{
		if(instance == null)
		{
			synchronized(GradeCardDAOImpl.class){
				instance = new GradeCardDAOImpl();
			}
		}
		return instance;
	}


	Grade grade;
	/**
	 * Method to view GradeCard
	 * @return list of GradeCard
	 * @throws SQLException
	 */
	@Override
	public List<GradeCard> viewGradeCard(int studentId) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement= null;
		ResultSet resultSet = null;

		List<GradeCard> gradeList = new ArrayList<>();
		try
		{

			connection = DBUtil.getConnection();

			String str = "select course_code, course_name, grade from grade where student_id = ?";

			preparedStatement = connection.prepareStatement(str);
			preparedStatement.setInt(1, studentId);
			resultSet = preparedStatement.executeQuery();

			while(resultSet.next())
			{
				String courseCode = resultSet.getString("course_code");
				String courseName = resultSet.getString("course_name");
				String grade = resultSet.getString("grade");
				GradeCard obj = new GradeCard(courseCode, courseName,grade);
				gradeList.add(obj);
			}
		}
		catch(SQLException e)
		{
			logger.info(e.getMessage());
		}
		catch(Exception e)
		{
			logger.info(e.getMessage());
		}

		return gradeList;
	}
}