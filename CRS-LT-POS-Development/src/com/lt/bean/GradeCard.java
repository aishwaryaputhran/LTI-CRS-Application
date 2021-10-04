package com.lt.bean;

public class GradeCard {
	
	private String CourseId;
	private int StudentId;
	private Enum Grade;
	
	public GradeCard(int studentId, String courseId, Enum grade)
	{
		super();
		StudentId = studentId;
		CourseId = courseId;
		Grade = grade;
	}
	
	public int getStudentId() {
		return StudentId;
	}
	public void setStudentId(int studentId) {
		StudentId = studentId;
	}
	public String getCourseId() {
		return CourseId;
	}
	public void setCourseId(String courseId) {
		CourseId = courseId;
	}
	public Enum getGrade() {
		return Grade;
	}
	public void setGrade(Enum grade) {
		Grade = grade;
	}
	@Override
	public String toString() {
		return "GradeCard [StudentId=" + StudentId + ", CourseId=" + CourseId + ", Grade=" + Grade + "]";
	}
	
	
}
