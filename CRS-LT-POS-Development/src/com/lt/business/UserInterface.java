package com.lt.business;

public interface UserInterface {

	public int login(String username, String password);
	public void updatePassword(String username, String password);
	public String viewRole();

}