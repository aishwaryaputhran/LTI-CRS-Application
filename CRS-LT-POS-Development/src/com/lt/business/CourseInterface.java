package com.lt.business;

import com.lt.bean.Course;

public interface CourseInterface {

	public String createCourse();
	public String listCourse();
	public String updateCourse(Course course);
	public String deleteCourse(String CourseId);
	
	
}
