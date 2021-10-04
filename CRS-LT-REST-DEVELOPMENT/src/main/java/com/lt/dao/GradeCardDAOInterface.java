package com.lt.dao;

import java.sql.SQLException;
import java.util.List;

import com.lt.bean.GradeCard;
import com.lt.constants.Grade;

public interface GradeCardDAOInterface 
{
	public List<GradeCard> viewGradeCard(int studentId);

	public List<GradeCard> getGrade();

}
