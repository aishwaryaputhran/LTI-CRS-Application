package com.lt.bean;

/**
 * 
 * @author G4-FullStackGroup
 * Professor Class
 * 
 */

public class Professor {

	private int ProfessorId;
	private String ProfessorName;
	private Long ProfessorContactNo;
	private String ProfessorEmailId;
	private String ProfessorAddress;

	/**
	 * Method to get ProfessorId
	 * @param getProfessorId
	 */
	public int getProfessorId() {
		return ProfessorId;
	}
	/**
	 * Method to set ProfessorId
	 * @param setProfessorId
	 */
	public void setProfessorId(int professorId) {
		ProfessorId = professorId;
	}
	/**
	 * Method to get ProfessorName
	 * @param getProfessorName
	 */
	public String getProfessorName() {
		return ProfessorName;
	}
	/**
	 * Method to set ProfessorName
	 * @param setProfessorName
	 */
	public void setProfessorName(String professorName) {
		ProfessorName = professorName;
	}
	/**
	 * Method to get ProfessorContactNo
	 * @param getProfessorContactNo
	 */
	public Long getProfessorContactNo() {
		return ProfessorContactNo;
	}
	/**
	 * Method to set ProfessorContactNo
	 * @param setProfessorContactNo
	 */
	public void setProfessorContactNo(Long professorContactNo) {
		ProfessorContactNo = professorContactNo;
	}
	/**
	 * Method to get ProfessorEmailId
	 * @param getProfessorEmailId
	 */
	public String getProfessorEmailId() {
		return ProfessorEmailId;
	}
	/**
	 * Method to set ProfessorEmailId
	 * @param setProfessorEmailId
	 */
	public void setProfessorEmailId(String professorEmailId) {
		ProfessorEmailId = professorEmailId;
	}
	/**
	 * Method to get ProfessorAddress
	 * @param getProfessorAddress
	 */
	public String getProfessorAddress() {
		return ProfessorAddress;
	}
	/**
	 * Method to set ProfessorAddress
	 * @param setProfessorAddress
	 */
	public void setProfessorAddress(String professorAddress) {
		ProfessorAddress = professorAddress;
	}
	@Override
	public String toString() {
		return "Professor [ProfessorId=" + ProfessorId + ", ProfessorName=" + ProfessorName + ", ProfessorContactNo="
				+ ProfessorContactNo + ", ProfessorEmailId=" + ProfessorEmailId + ", ProfessorAddress="
				+ ProfessorAddress + "]";
	}


}		