package com.lt.business;

import java.util.List;

import com.lt.bean.Catlog;

/**
 * 
 * @author G4-FullStackGroup
 * Interface for CatalogInterface Operations
 * 
 */
public interface CatlogInterface {

	/**
	 * Method to get Course Id from DB
	 * 
	 */
	public String getCourseId();
	/**
	 * Method to getCourseNamer from DB
	 * 
	 */
	public String getCourseName();
	/**
	 * Method to setCourseId from DB
	 * 
	 */
	public String setCourseId();
	/**
	 * Method to from from DB
	 * 
	 */
	public String setCourseName();
	/**
	 * Method to get courses from catalog
	 */
	public List<Catlog> getCatalogCourse();
	
}
