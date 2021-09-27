package com.lt.bean;

public class Catlog {

	
	public int CourseId;
	public String CourseName;
	
	public Catlog(int courseId, String courseName) {
		super();
		CourseId = courseId;
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
		return "Catlog [CourseId=" + CourseId + ", CourseName=" + CourseName + "]";
	}
	
	
}
