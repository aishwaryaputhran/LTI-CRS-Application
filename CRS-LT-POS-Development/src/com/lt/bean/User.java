package com.lt.bean;

public class User {

	
	private String Username;
	private String Password;
	private int RoleId;
	
	public User() {
		// TODO Auto-generated constructor stub
	}
	public User(String username2, String password2, int roleID2) 
	{
		this.Username=username2;
		this.Password=password2;
		this.RoleId=roleID2;
	}
	
	public String getUsername() {
		return Username;
	}
	public void setUsername(String username) {
		Username = username;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}
	public int getRoleId() {
		return RoleId;
	}
	public void setRoleId(int roleId) {
		RoleId = roleId;
	}
	
}
	
