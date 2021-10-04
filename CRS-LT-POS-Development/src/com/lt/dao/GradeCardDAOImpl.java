package com.lt.dao;

import java.util.ArrayList;
import java.util.List;

import com.lt.bean.GradeCard;
import com.lt.constants.Grade;

public class GradeCardDAOImpl implements GradeCardDAOInterface
{

	List<GradeCard> gradeCard = new ArrayList<GradeCard>();
	Grade grade;
	
	public List<GradeCard> getGradeCard() {
		gradeCard.add( new GradeCard(101, "Computer Science", grade.A ));
		gradeCard.add( new GradeCard(102, "Electricals", grade.B));
		gradeCard.add( new GradeCard(103, "Mechanical", grade.C));
		gradeCard.add( new GradeCard(104, "Civil", grade.D));
		gradeCard.add( new GradeCard(105, "Bio-Technology", grade.F));

		return gradeCard;
	}
}