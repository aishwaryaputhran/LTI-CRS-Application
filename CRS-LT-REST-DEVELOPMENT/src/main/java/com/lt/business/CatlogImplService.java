package com.lt.business;

import java.util.List;

import org.springframework.stereotype.Service;

import com.lt.bean.Catlog;
import com.lt.dao.CoursecatalogDAOImpl;
import com.lt.dao.CoursecatalogDAOInterface;

@Service
public class CatlogImplService implements CatlogInterface {

	private static volatile CatlogImplService instance = null;
	CoursecatalogDAOInterface catalogDAOInterface=CoursecatalogDAOImpl.getInstance();
	/**
	 * Default Constructor
	 * @return values
	 */
	private CatlogImplService()
    {
    }
    /**
    * Method to make CatlogImplService Singleton
    * @return
    */
    public static CatlogImplService getInstance()
    {
    if(instance == null)
    {
    synchronized(CatlogImplService.class){
    instance = new CatlogImplService();
    }
    }
    return instance;
    }
    
	@Override
	public String getCourseId() 
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getCourseName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String setCourseId() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String setCourseName() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public List<Catlog> getCatalogCourse()
	{
		return catalogDAOInterface.viewCourses();
	}
}
