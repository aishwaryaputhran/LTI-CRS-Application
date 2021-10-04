package com.lt.dao;
import java.util.List;

import com.lt.bean.Catlog;

/**
 * @author G4-FullStackGroup
 * Interface for CoursecatalogDAO
 */
public interface CoursecatalogDAOInterface
{
	/**
	 * Method to view Courses
	 */
  public List<Catlog> viewCourses();
}
