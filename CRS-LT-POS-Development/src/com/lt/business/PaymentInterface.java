package com.lt.business;

/*
 * 
 * @author G4-FullStackGroup
 * Implementations of Payment Services 
 * 
 */
public interface PaymentInterface {
	/*
	 * Method to get Payment
	 *  @param studentId,fee
	 */
	public void getPayment(int studentId, double fee);//mode,scanner
	/*
	 * Method to online
	 * @param studentId,fee
	 */
	public void online(int studentId, double fee);
	/*
	 * Method to offline
	 * 
	 */
	public void offline();
	
}