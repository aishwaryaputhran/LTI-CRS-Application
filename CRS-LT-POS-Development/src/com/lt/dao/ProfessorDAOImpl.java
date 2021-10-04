package com.lt.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.lt.utils.DBUtil;
import com.lt.bean.Course;
import com.lt.constants.SQLQueries;

/*
 * @author G4-FullStackGroup
 * Dao Class Operations for ProfessorDAO
 * 
 */
public class ProfessorDAOImpl implements ProfessorDAOInterface {
	private static Logger logger = Logger.getLogger(ProfessorDAOImpl.class);
	private static volatile ProfessorDAOImpl instance = null;
	/*
	 * Default Constructor
	 */
	private ProfessorDAOImpl()
	{
	}
	/*
	 * Method to make ProfessorDAOImpl Singleton
	 * @return
	 */
	public static ProfessorDAOImpl getInstance()
	{
		if(instance == null)
		{
			synchronized(ProfessorDAOImpl.class){
				instance = new ProfessorDAOImpl();
			}
		}
		return instance;
	}
	/*
	 * Method to get Courses by Professor Id using SQL Commands
	 * @param userId, prof id of the professor
	 * @return get the courses offered by the professor.
	 */
	@Override
	public List<Course> getCoursesByProfessor(String profId) {
		Connection connection=DBUtil.getConnection();
		List<Course> courseList=new ArrayList<Course>();
		try {
			PreparedStatement statement = connection.prepareStatement(SQLQueries.GET_COURSES);

			statement.setString(1, profId);

			ResultSet results=statement.executeQuery();
			while(results.next())
			{
				courseList.add(new Course(results.getString("courseId"),results.getString("courseName"),results.getString("professorId")));
			}
		}
		catch(SQLException e)
		{
			logger.error(e.getMessage());
		}

		return courseList;
	}
	/*
	 * Method to view list of enrolled Students using SQL Commands
	 * @param: profId: professor id 
	 * @param: courseCode: course code of the professor
	 * @return: return the enrolled students for the corresponding professor and course code.
	 */
	@Override
	public boolean getRegisteredCourses(String profId) {

		//List<RegisteredCourse> enrolledStudents=new ArrayList<RegisteredCourse>();

		Connection connection=null; 
		PreparedStatement preparedStatement= null;
		ResultSet resultSet = null;
		boolean countCheck = false;

		try {
			connection=DBUtil.getConnection();
			//String query = "select course_code, course_name, student_id from registered_course where course_code IN (select course_code from course where prof_id = ? )";     
			String query = "select course_name as department, count(*) as studentCount from registered_course group by course_name;";
			preparedStatement = connection.prepareStatement(query);
			//preparedStatement.setString(1, profId);

			resultSet = preparedStatement.executeQuery();
			ResultSetMetaData rsmd = resultSet.getMetaData();
			int columnsNumber = rsmd.getColumnCount();
			if(columnsNumber!=0) {
				countCheck = true;
			}

			logger.info("Course Name"+ " | "+ "Student Count");
			logger.info("-----------"+ "   "+ "-------------");
			while(resultSet.next()) {

				String coursename= resultSet.getString(1); //or rs.getString("column name");
				int studentCount= resultSet.getInt(2);
				logger.info(coursename  + "     | " +studentCount);
			}

		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}

		return countCheck;
	}
	/**
	 * Method to Grade a student using SQL Commands
	 * @param: profId: professor id 
	 * @param: courseCode: course code for the corresponding 
	 * @return: returns the status after adding the grade
	 */
	public Boolean addGrade(int studentId,String courseId,String grade) {
		Connection connection=DBUtil.getConnection();
		try {
			PreparedStatement statement = connection.prepareStatement(SQLQueries.ADD_GRADE);

			statement.setString(1, grade);
			statement.setString(2, courseId);
			statement.setInt(3, studentId);

			int row = statement.executeUpdate();

			if(row==1)
				return true;
			else
				return false;
		}
		catch(SQLException e)
		{
			logger.error(e.getMessage());
		}

		return false;
	}
	/*
	 * Method to Get professor name by id
	 * @param profId
	 * @return
	 */
	@Override
	public String getProfessorById(String profId)
	{
		String prof_Name = null;
		Connection connection=DBUtil.getConnection();
		try 
		{
			PreparedStatement statement = connection.prepareStatement(SQLQueries.GET_PROF_NAME);

			statement.setString(1, profId);
			ResultSet rs = statement.executeQuery();
			rs.next();

			prof_Name = rs.getString(1);

		}
		catch(SQLException e)
		{
			logger.error(e.getMessage());
		}

		return prof_Name;
	}
	@Override
	public boolean signupProfessor(String username, String department, String address) {

		Connection connection = null;
		PreparedStatement preparedStatement= null;
		ResultSet resultSet = null;

		try {
			connection = DBUtil.getConnection();
			String query = "insert into professor(prof_name, department, address) values (?, ?, ?)";
			PreparedStatement statement = connection.prepareStatement(query);

			statement.setString(1, username);
			statement.setString(2, department);
			statement.setString(3, address);
			int row = statement.executeUpdate();

			if(row==1)
				return true;
			else
				return false;
		}
		catch(SQLException e)
		{
			logger.info(e.getMessage());
		}
		return true;
	}
	/**
	 * Method to Grade a student using SQL Commands
	 * @param: profId: professor id 
	 * @param: courseCode: course code for the corresponding 
	 * @return: returns the status after adding the grade
	 */	
	@Override
	public boolean addGrade(String courseName, String courseCode, String grade, int studentId) {

		Connection connection=DBUtil.getConnection();
		try {
			PreparedStatement statement = connection.prepareStatement(SQLQueries.ADD_GRADE);


			statement.setString(1, courseCode);
			statement.setString(2, courseName);
			statement.setString(3, grade);
			statement.setInt(4, studentId);

			int row = statement.executeUpdate();

			if(row==1)
				return true;
			else
				return false;
		}
		catch(SQLException e)
		{
			logger.info(e.getMessage());
		}
		return false;
	}
}