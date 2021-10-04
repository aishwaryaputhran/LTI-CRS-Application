package com.lt.business;
import org.apache.log4j.Logger;

import com.lt.constants.PaymentMode;
import com.lt.dao.PaymentDAOImpl;
import com.lt.dao.PaymentDAOInterface;
/**
 * 
 * @author G4-FullStackGroup
 * Implementations of NotificationImplService
 * 
 */
public class NotificationImplService implements NotificationInterface
{	
	private static Logger logger = Logger.getLogger(CourseImplService.class);
	PaymentDAOInterface daoPayment = PaymentDAOImpl.getInstance();
	
	private static volatile NotificationImplService instance = null;
	
	private NotificationImplService()
    {
    }
    /**
    * Method to make AdminOperation Singleton
    * @return
    */
    public static NotificationImplService getInstance()
    {
    if(instance == null)
    {
    synchronized(NotificationImplService.class){
    instance = new NotificationImplService();
    }
    }
    return instance;
    }
	
    /**
     * Method to make get Notify
     * @return message
     */
	@Override
	public boolean getNotify() 
	{
		return  false;
	}
	
	/**
     * Method to sendNotification
     * @return boolean value
     */
	@Override
	public boolean sendNotification(int studentId, PaymentMode mode, double fee) {
		if(daoPayment.payment(studentId, mode, fee)) {
			return true;
		}
		return false;
		
	}

}