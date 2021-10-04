package com.lt.dao;

import com.lt.constants.PaymentMode;

/*
 * @author G4-FullStackGroup
 * Interface for PaymentDAO
 *
 */
public interface PaymentDAOInterface {
	/*
	 * Method to calculate Fee
	 * @param studentId
	 * 
	 */
	double calculateFee(int studentId);
	/*
	 * Method to make the payment
	 * @param studentId,PaymentMode,fee
	 * 
	 */
	boolean payment(int studentId, PaymentMode mode, double fee);
	/*
	 * Method to get the status of the payment
	 * @param studentId
	 * 
	 */
	String paymentStatus(int studentId);

}