package com.lt.business;

import java.util.List;

import com.lt.bean.Course;
import com.lt.bean.Student;
import com.lt.client.StudentMenu;

public interface StudentInterface {

	public boolean login(String studentName, String studentPassword);
	public boolean signup(String username,String password, long contact, String email, String address);
	public String viewGradeCard();
	public String courseSelection();
	public String payFee();
	public boolean addCourse();
	public boolean dropCourse();

}
