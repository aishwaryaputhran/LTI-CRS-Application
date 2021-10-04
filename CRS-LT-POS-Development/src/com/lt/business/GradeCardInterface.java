package com.lt.business;

/**
 * 
 * @author G4-FullStackGroup
 * Interface for CatalogInterface Operations
 * 
 */
import java.sql.SQLException;
import java.util.List;

import com.lt.bean.GradeCard;

public interface GradeCardInterface {
	/**
	 * Method to viewGradeCard from DB
	 * @param StudentId
	 */
	public List<GradeCard> viewGradeCard(int StudentId) throws SQLException;
	/**
	 * Method to printGradeCard
	 * 
	 */
	public String printGradeCard();
	/**
	 * Method to payFee
	 * 
	 */
	public void payFee();
}
