package com.lt.dao;

import java.util.List;

import com.lt.bean.Student;

public interface StudentDAOInterface 
{
	public List<Student> getStudentList();
	public boolean signup(String username,String password, long contact, String email, String address);
}
