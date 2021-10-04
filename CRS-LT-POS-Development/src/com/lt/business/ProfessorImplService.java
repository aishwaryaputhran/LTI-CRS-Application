package com.lt.business;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.lt.bean.Course;
import com.lt.bean.RegisteredCourse;
import com.lt.dao.ProfessorDAOImpl;
import com.lt.exception.GradeNotAddedException;
/*
 * @author G4-FullStackGroup
 * Dao Class Operations for ProfessorImplService
 * 
 */
public class ProfessorImplService implements ProfessorInterface {

	ProfessorDAOImpl professorDAOInterface=ProfessorDAOImpl.getInstance();
	private static Logger logger = Logger.getLogger(ProfessorImplService.class);
	private static volatile ProfessorImplService instance = null;

	private ProfessorImplService()
	{
	}
	/*
	 * Method to make ProfessorImplService Singleton
	 * @return
	 */
	public static ProfessorImplService getInstance()
	{
		if(instance == null)
		{
			synchronized(ProfessorImplService.class){
				instance = new ProfessorImplService();
			}
		}
		return instance;
	}

	/*
	 * Method to grade a Student
	 * @param studentId,courseId,grade
	 * @return boolean value indicating if grade is added or not
	 * @throws GradeNotAddedException
	 */
	public boolean addGrade(int studentId,String courseId,String grade) throws GradeNotAddedException {
		try
		{
			professorDAOInterface.addGrade(studentId, courseId, grade);
		}
		catch(Exception ex)
		{
			throw new GradeNotAddedException(studentId);
		}
		return true;
	}
	/*
	 * Method to get list of all course a professor is teaching
	 * @param profId: professor id 
	 * @return List of courses the professor is teaching
	 */
	@Override
	public List<Course> getCourses(String profId) {
		//call the DAO class
		//get the courses for the professor
		List<Course> coursesOffered=new ArrayList<Course>();
		try
		{
			coursesOffered=professorDAOInterface.getCoursesByProfessor(profId);
		}
		catch(Exception ex)
		{
			throw ex;
		}
		return coursesOffered;
	}

	/**
	 * Method to get the professor name with ID
	 * @param profId
	 * @return Professor name 
	 */
	@Override
	public String getProfessorById(String profId)
	{
		return professorDAOInterface.getProfessorById(profId);
	}
	/**
	 * Method to grade a Student
	 * @param are studentId,courseCode,grade
	 * @return boolean indicating if grade is added or not
	 * @throws GradeNotAddedException
	 */
	@Override
	public boolean addGrade(String courseName, String courseCode, String grade, int studentId)
			throws GradeNotAddedException {
		try
		{
			professorDAOInterface.addGrade(courseCode, courseName, grade,studentId);
		}
		catch(Exception ex)
		{
			throw new GradeNotAddedException(studentId);
		}
		return true;
	}
	/**
	 * Method to get RegisteredCourses
	 * @param profId: professor id 
	 * @return List of enrolled students
	 */
	@Override
	public boolean getRegisteredCourses(String profId) throws SQLException {
		boolean studentsCount = false;
		try
		{
			if(professorDAOInterface.getRegisteredCourses(profId)) {
				studentsCount = true;
			}

		}
		catch(Exception ex)
		{
			throw ex;
		}
		return studentsCount;
	}
}