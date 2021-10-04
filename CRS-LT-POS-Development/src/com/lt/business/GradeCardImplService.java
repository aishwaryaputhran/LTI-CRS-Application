package com.lt.business;

import java.util.ArrayList;
import java.util.List;
import com.lt.bean.GradeCard;
import com.lt.dao.GradeCardDAOImpl;

public class GradeCardImplService implements GradeCardInterface 
{

	List<GradeCard> gradeCard = new ArrayList<GradeCard>();
	GradeCardDAOImpl gradeCardDao = new GradeCardDAOImpl();
	
	@Override
	public void viewGradeCard() 
	{
		List<GradeCard> gc= gradeCardDao.getGradeCard();
		for(GradeCard  cs : gc){

			System.out.println("Detail of GradeCards--> "+cs.getStudentId() + " " +cs.getCourseId() +" " +cs.getGrade());
		}
	}

	
}