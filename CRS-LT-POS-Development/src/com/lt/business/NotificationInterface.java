package com.lt.business;

/**
 * 
 * @author G4-FullStackGroup
 * Implementations of Admin Services 
 * 
 */
import com.lt.constants.PaymentMode;

public interface NotificationInterface {

	/**
	    * Method to getNotify
	    * 
	    */
	public boolean getNotify();
	/**
	    * Method to make AdminOperation Singleton
	    * @param studentId,PaymentMode,fee.
	    */
	public boolean sendNotification(int studentId, PaymentMode mode, double fee);
	
}