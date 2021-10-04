package com.lt.business;
import java.util.List;
import com.lt.bean.Course;
import java.util.List;
import com.lt.bean.Course;

/**
 * 
 * @author G4-FullStackGroup
 * Interface for CourseInterface
 * 
 */

public interface CourseInterface {
	/**
	    * Method to createCourse
	    * @return
	    */
	public String createCourse();
	/**
	    * Method to listCourse
	    * @return
	    */
	public String listCourse();
	/**
	    * Method toupdateCourse
	    * @return
	    */
	public String updateCourse(Course course);
	/**
	    * Method to deleteCourse
	    * @return
	    */
	public String deleteCourse(String CourseId);
	/**
	    * Method to viewCourses
	    * @return
	    */
	public List<Course> viewCourses();
	
	
}