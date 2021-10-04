package com.lt.dao;

import java.util.List;

import com.lt.bean.Course;

/*
 * @author G4-FullStackGroup
 * Interface for CourseDAO
 *
 */
public interface CourseDAOInterface {	

	/*
	 * Method to list Course
	 * @return list of Courses
	 */
	public List<Course> getCourse();
	/*
	 * Method to get CourseById
	 * @param courseId
	 * @return course by Id.
	 */
	public String getCourseById(String courseId);
	/*
	 * Method to getFee from database
	 * @param courseCode
	 * @return true if student is paid, else false
	 */
	public double getFeeById(String courseCode);

}