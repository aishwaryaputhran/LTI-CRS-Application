package com.lt.bean;

import java.util.Date;

public class RegisteredCourse {

	private String CourseId;
	private String CourseName;
	private Date DateOfRegistration;
	private double CourseFee;
	private Enum Grade;
	
	public String getCourseId() {
		return CourseId;
	}
	public void setCourseId(String courseId) {
		CourseId = courseId;
	}
	public String getCourseName() {
		return CourseName;
	}
	public void setCourseName(String courseName) {
		CourseName = courseName;
	}
	public Date getDateOfRegistration() {
		return DateOfRegistration;
	}
	public void setDateOfRegistration(Date dateOfRegistration) {
		DateOfRegistration = dateOfRegistration;
	}
	public double getCourseFee() {
		return CourseFee;
	}
	public void setCourseFee(double courseFee) {
		CourseFee = courseFee;
	}
	public Enum getGrade() {
		return Grade;
	}
	public void setGrade(Enum grade) {
		Grade = grade;
	}
	@Override
	public String toString() {
		return "RegisteredCourse [CourseId=" + CourseId + ", CourseName=" + CourseName + ", DateOfRegistration="
				+ DateOfRegistration + ", CourseFee=" + CourseFee + ", Grade=" + Grade + "]";
	}
	
	
	
}
