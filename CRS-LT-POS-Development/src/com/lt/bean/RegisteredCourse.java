package com.lt.bean;
import java.util.Date;

/**
 * 
 * @author G4-FullStackGroup
 * RegisteredCources Class
 * 
 */

public class RegisteredCourse {

	private String CourseId;
	private String CourseName;
	private Date DateOfRegistration;
	private String CourseFee;
	private String Grade;
	private int StudentId;

	/**
	 *Default Constructor
	 * @return values
	 */
	public RegisteredCourse() {
		super();
		// TODO Auto-generated constructor stub
	}


	/**
	 *Parameterized Constructor
	 * @return values
	 */
	public RegisteredCourse(String courseId, String courseName, int studentId) {
		super();
		CourseId = courseId;
		CourseName = courseName;
		StudentId = studentId;
	}


	/**
	 *Parameterized Constructor
	 * @return values
	 */
	public RegisteredCourse(String courseId, String courseName,  String courseFee) {
		super();
		CourseId = courseId;
		CourseName = courseName;
		CourseFee = courseFee;

	}

	/**
	 * Method to get CourseId
	 * @param getCourseId
	 */
	public String getCourseId() {
		return CourseId;
	}
	/**
	 * Method to  set CourseId
	 * @param  setCourseId
	 */
	public void setCourseId(String courseId) {
		CourseId = courseId;
	}
	/**
	 * Method to getCourseName
	 * @param getCourseCode
	 */
	public String getCourseName() {
		return CourseName;
	}
	/**
	 * Method to set CourseName
	 * @param setCourseName
	 */
	public void setCourseName(String courseName) {
		CourseName = courseName;
	}
	/**
	 * Method to getDateOfRegistration
	 * @param getDateOfRegistration
	 */
	public Date getDateOfRegistration() {
		return DateOfRegistration;
	}
	/**
	 * Method to set DateOfRegistration
	 * @param setDateOfRegistration
	 */
	public void setDateOfRegistration(Date dateOfRegistration) {
		DateOfRegistration = dateOfRegistration;
	}
	/**
	 * Method to get CourseFee
	 * @param getCourseFee
	 */
	public String getCourseFee() {
		return CourseFee;
	}
	/**
	 * Method to set CourseFee
	 * @param setCourseFee
	 */
	public void setCourseFee(String courseFee) {
		CourseFee = courseFee;
	}
	/**
	 * Method to get Grade
	 * @param getGrade
	 */
	public String getGrade() {
		return Grade;
	}
	/**
	 * Method to set Grade
	 * @param setGrade
	 */
	public void setGrade(String grade) {
		Grade = grade;
	}
	/**
	 * Method to get StudentId
	 * @param getStudentId
	 */
	public int getStudentId() {
		return StudentId;
	}
	/**
	 * Method to set StudentId
	 * @param setStudentId
	 */
	public void setStudentId(int studentId) {
		StudentId = studentId;
	}
	@Override
	public String toString() {
		return "RegisteredCourse [CourseId=" + CourseId + ", CourseName=" + CourseName + ", DateOfRegistration="
				+ DateOfRegistration + ", CourseFee=" + CourseFee + ", Grade=" + Grade + "]";
	}



}