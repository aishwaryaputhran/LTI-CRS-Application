package com.lt.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.lt.bean.Course;
import com.lt.utils.DBUtil;

/*
 * @author G4-FullStackGroup
 * Dao Class CourseDAOImpl for course implementation
 * 
 */
public class CourseDAOImpl implements CourseDAOInterface
{
	private static volatile CourseDAOImpl instance = null;
	private static Logger logger = Logger.getLogger(CourseDAOImpl.class);
	private CourseDAOImpl()
	{
	}
	/*
	 * Method to make CourseDAOImpl Singleton
	 * @return instance
	 */
	public static CourseDAOImpl getInstance()
	{
		if(instance == null)
		{
			synchronized(CourseDAOImpl.class){
				instance = new CourseDAOImpl();
			}
		}
		return instance;
	}

	/*
	 * Method to get Course
	 * @returns list of courses
	 */
	public List<Course> getCourse() 
	{
		Connection connection = null;
		PreparedStatement preparedStatement= null;
		ResultSet resultSet = null;

		List<Course> courseList = new ArrayList<Course>();
		try 
		{
			connection = DBUtil.getConnection();

			String str = "select course_code, course_name from course";

			preparedStatement = connection.prepareStatement(str);
			resultSet = preparedStatement.executeQuery();

			while(resultSet.next())
			{
				String courseCode = resultSet.getString("course_code");
				String courseName = resultSet.getString("course_name");

				Course obj = new Course(courseCode, courseName);
				courseList.add(obj);
			}

		}
		catch (SQLException e) 
		{
			logger.info(e.getMessage());
		} 
		catch (Exception e)
		{
			logger.info(e.getMessage());
		}

		return courseList;

	}
	/*
	 * Method to get Course By Id
	 * @param courseId
	 * @returns list of courses
	 */
	@Override
	public String getCourseById(String courseId) {

		Connection connection = null;
		PreparedStatement preparedStatement= null;
		ResultSet resultSet = null;

		try 
		{
			connection = DBUtil.getConnection();

			String str = "select course_name from course where course_code = ?";

			preparedStatement=connection.prepareStatement(str);
			preparedStatement.setString(1,courseId);
			resultSet = preparedStatement.executeQuery();

			while(resultSet.next())
			{
				return resultSet.getString("course_name");

			}
		}
		catch (SQLException e) 
		{
			logger.info(e.getMessage());
		} 
		catch (Exception e)
		{
			logger.info(e.getMessage());
		}

		return null;
	}
	/*
	 * Method to get Fee By Id
	 * @param courseCode
	 * 
	 */
	@Override
	public double getFeeById(String courseCode) {

		Connection connection = null;
		PreparedStatement preparedStatement= null;
		ResultSet resultSet = null;

		try 
		{
			connection = DBUtil.getConnection();

			String str = "select course_fee from course where course_code = ?";

			preparedStatement=connection.prepareStatement(str);
			preparedStatement.setString(1,courseCode);
			resultSet = preparedStatement.executeQuery();

			while(resultSet.next())
			{
				return resultSet.getDouble("course_fee");

			}
		}
		catch (SQLException e) 
		{
			logger.info(e.getMessage());
		} 
		catch (Exception e)
		{
			logger.info(e.getMessage());
		}
		return 0;
	}

	}