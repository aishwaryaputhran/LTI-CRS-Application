package com.lt.exception;

/*
 * @author G4-FullStackGroup
 * NullPointerException is custom exception which is catched when userName is null
 */
public class NullPointerException extends Exception{

	private String UserName;

	public NullPointerException(String UserName)
	{
		this.UserName=UserName;
	}

	public String getStudentId()
	{
		return UserName;
	}
}