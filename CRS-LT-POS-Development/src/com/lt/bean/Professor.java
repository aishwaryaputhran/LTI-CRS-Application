package com.lt.bean;

public class Professor {

	private String ProfessorName;
	private String ProfessorPassword;
	private Long ProfessorContactNo;
	private String ProfessorEmailId;
	private String ProfessorAddress;
	
	
	public Professor(String name,String password, Long contact, String email, String address)
	{
		this.ProfessorName=name;
		this.ProfessorPassword=password;
		this.ProfessorContactNo=contact;
		this.ProfessorEmailId=email;
		this.ProfessorAddress=address;		
	}
	
	public String getProfessorName() {
		return ProfessorName;
	}
	public void setProfessorName(String professorName) {
		ProfessorName = professorName;
	}
	public Long getProfessorContactNo() {
		return ProfessorContactNo;
	}
	public void setProfessorContactNo(Long professorContactNo) {
		ProfessorContactNo = professorContactNo;
	}
	public String getProfessorEmailId() {
		return ProfessorEmailId;
	}
	public void setProfessorEmailId(String professorEmailId) {
		ProfessorEmailId = professorEmailId;
	}
	public String getProfessorAddress() {
		return ProfessorAddress;
	}
	public void setProfessorAddress(String professorAddress) {
		ProfessorAddress = professorAddress;
	}
	public String getProfessorPassword() {
		return ProfessorPassword;
	}
	public void setProfessorPassword(String professorPassword) {
		ProfessorPassword = professorPassword;
	}	
}
