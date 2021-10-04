package com.lt.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.apache.log4j.Logger;

import com.lt.bean.SemesterRegistration;
import com.lt.business.StudentImplService;
/**
 * @author G4-FullStackGroup
 * class for implementation of SemesterRegistrationDAO
 * 
 */
public class SemesterRegistrationDAOImpl implements SemesterRegistrationDAOInterface
{
	private static volatile SemesterRegistrationDAOImpl instance = null;
	private static Logger logger = Logger.getLogger(SemesterRegistrationDAOImpl.class);
	private SemesterRegistrationDAOImpl()
    {
    }
    /**
    * Method to make SemesterRegistrationDAOImpl Singleton
    * @return
    */
    public static SemesterRegistrationDAOImpl getInstance()
    {
    if(instance == null)
    {
    synchronized(SemesterRegistrationDAOImpl.class){
    instance = new SemesterRegistrationDAOImpl();
    }
    }
    return instance;
    }
 
	
	
	List<SemesterRegistration> studentreg=new ArrayList<SemesterRegistration>(); 
	
	public void getSemFee(int key) 
	{
		Map<Integer,Double> semFee =new TreeMap<>();    
	    semFee.put(1,40000.00);    
	    semFee.put(2,40000.00);    
	    semFee.put(3,42000.00);    
	    semFee.put(4,45000.00);    
	      
	    for(Map.Entry m:semFee.entrySet())
	    {  
	    	if(m.getKey()==Integer.valueOf(key)) 
	    	{
	    		logger.info("Amount is: "+m.getValue());    
	    	}
	    }  
	}
	
	
	public List<SemesterRegistration> getRegisteredStudent()
	{
		  
		studentreg.add(new SemesterRegistration(100, "Anil", 3));
		studentreg.add(new SemesterRegistration(101, "John", 4));
		studentreg.add(new SemesterRegistration(102, "Dew", 2));
		
		return studentreg;
	}
	
	/**
 	 * Method to get Registered Student By Id
 	 * @param: studentId
 	 * @return: return the boolean values
 	 */
	public boolean getRegisteredStudentById(int studentId)
	{
		boolean check=false;
		List<SemesterRegistration> sreg= getRegisteredStudent();
		for(SemesterRegistration s: sreg)	
		{
			if(s.getStudentId()==studentId)
			{
				check=true;
				break;
			}
			
		}
		return check;
	}
	/**
 	 * Method to add Registered Student
 	 * @param: studentId,studentName,semester
 	 * @return: return the boolean values
 	 */
	public boolean addRegisteredStudent(int studentId, String studentName, int semester)
	{
		studentreg.add(new SemesterRegistration(studentId,studentName,semester));
		
		return true;
		
	}

}