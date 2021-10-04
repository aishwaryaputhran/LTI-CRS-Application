package com.lt.dao;
import java.sql.SQLException;
import java.util.List;

import com.lt.bean.GradeCard;

/**
 * @author G4-FullStackGroup
 * Interface for GradeCardDAO
 *
 */
public interface GradeCardDAOInterface 
{
	
	/**
	 * Method to view GradeCard
	 * @param studentId
	 * @throws SQLException
	 */
	public List<GradeCard> viewGradeCard(int studentId) throws SQLException;

}