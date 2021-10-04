package com.lt.dao;

import java.util.List;

import com.lt.bean.RegisteredCourse;
/**
 * @author G4-FullStackGroup
 * Interface for RegisteredCourseDAO
 *
 */

public interface RegisteredCourseDAOInterface {

	/**
	 * Method to view Registered Courses
	 * @param studentId
	 */
	List<RegisteredCourse> viewRegisteredCourses(int studentId);
	
	/**
	 * Method to add Courses
	 * @param courseCode,courseName,courseFee,studentId
	 */
	public boolean addCourses(String courseCode, String courseName, double courseFee, int studentId);
	/**
	 * Method to drop Courses
	 * @param courseCode,studentId
	 */
	public boolean dropCourse(String courseCode, int studentId);

}
