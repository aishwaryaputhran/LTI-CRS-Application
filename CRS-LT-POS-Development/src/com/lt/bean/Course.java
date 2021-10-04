package com.lt.bean;

public class Course {

	private int CourseId;
	private String CourseName;
	
	public Course() {}
	
	public Course(int courseId2, String courseName) {
		super();
		CourseId = courseId2;
		CourseName = courseName;
	}
	
	public int getCourseId() {
		return CourseId;
	}
	public void setCourseId(int courseId) {
		CourseId = courseId;
	}
	public String getCourseName() {
		return CourseName;
	}
	public void setCourseName(String courseName) {
		CourseName = courseName;
	}

	@Override
	public String toString() {
		return "Course [CourseId=" + CourseId + ", CourseName=" + CourseName + "]";
	}
	
	
}
