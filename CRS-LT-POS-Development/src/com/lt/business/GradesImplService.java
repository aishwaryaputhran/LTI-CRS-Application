package com.lt.business;

/**
 * 
 * @author G4-FullStackGroup
 * Implementations of GradesImplService Services 
 * 
 */
public class GradesImplService implements GradesInterface {
	
	private static volatile GradesImplService instance = null;
	
	private GradesImplService()
    {
    }
    /**
    * Method to make GradesImplService Singleton
    * @return
    */
    public static GradesImplService getInstance()
    {
    if(instance == null)
    {
    synchronized(GradesImplService.class){
    instance = new GradesImplService();
    }
    }
    return instance;
    }

	@Override
	public String submitGrades() {
		// TODO Auto-generated method stub
		return null;
	}

}
