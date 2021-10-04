package com.lt.dao;

import java.sql.SQLException;
import java.util.UUID;

import com.lt.constants.NotificationType;
import com.lt.constants.PaymentMode;

/*
 * @author G4-FullStackGroup
 * Interface for NotificationDAO
 *
 */
public interface NotificationDAOInterface {
	
	/*
	 * Method to send Notification
	 * @param type,studentId,modeOfPayment.
	 * 
	 */
	public int sendNotification(NotificationType type, int studentId,PaymentMode modeOfPayment) throws SQLException;
	/*
	 * Method to add Payment
	 * @param studentId,modeOfPayment
	 * 
	 */
	public UUID addPayment(int studentId, PaymentMode modeOfPayment) throws SQLException;
	
}
