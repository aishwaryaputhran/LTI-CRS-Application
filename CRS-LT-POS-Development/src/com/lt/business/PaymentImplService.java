package com.lt.business;

import java.util.Date;
import java.util.Scanner;

import org.apache.log4j.Logger;

import com.lt.client.StudentMenu;
import com.lt.constants.CardDetails;
import com.lt.constants.PaymentMode;

/**
 * 
 * @author G4-FullStackGroup
 * Implementations of PaymentImplService from PaymentInterface
 * 
 */
public class PaymentImplService implements PaymentInterface {
	private static Logger logger = Logger.getLogger(PaymentImplService.class);
	NotificationInterface ni =NotificationImplService.getInstance();
	String paymentStatus;
	/*
	 * Method to make PaymentImplService Singleton
	 * @return instance
	 */
	private static volatile PaymentImplService instance = null;
	private PaymentImplService()
	{
	}
	public static PaymentImplService getInstance()
	{
		if(instance == null)
		{
			synchronized(PaymentImplService.class){
				instance = new PaymentImplService();
			}
		}
		return instance;
	}

	/*
	 * Method to getPayment
	 * 
	 */
	@Override
	public void getPayment(int studentId, double fee)
	{
		logger.info("<-----Choose Payment Mode-------->");
		logger.info("1.Online"+"\n"+"2.Offline");
		Scanner in = new Scanner(System.in);
		int PaymentMode= in.nextInt();

		switch(PaymentMode)
		{
		case 1: logger.info("Online:-");
		online(studentId, fee);                 
		break;

		case 2: logger.info("Offline:-");
		offline();
		break;
		}
	}
	/*
	 * Method to online payment
	 * 
	 */

	@Override
	public void online(int studentId, double fee) 
	{
		logger.info("<-----Choose online Mode-------->");
		logger.info("1.Debit card"+"\n"+"2.Credit card");
		Scanner in = new Scanner(System.in);
		int Mode= in.nextInt();
		PaymentMode mode = PaymentMode.getModeofPayment(Mode);
		switch(Mode)
		{
		case 1: logger.info("Debit Card:-");
				logger.info("Enter Debit cardNo.:");
				long CardNo= in.nextLong();
				logger.info("Enter Debit Card Name.:");
				String Name= in.next();
				logger.info("Enter Debit CVV.:");
				int CVV= in.nextInt();
				logger.info("Enter Amount:");
				Double Amount= in.nextDouble();
		if((CardNo!=0 && String.valueOf(CardNo).length()==16) && (Name!= null) && (CVV!= 0)) 
		{

			try 
			{
				if(ni.sendNotification(studentId, mode, fee)) {
					logger.info("payment Done Sucessfully......");
				}else {
					StudentMenu sm = new StudentMenu();
					sm.doPayment(studentId);
				}

			} 
			catch (Exception e) 
			{

				logger.info(e.getMessage());
			}
		}
		else
		{
			logger.info("Invalid Card Details, Please Retry");
		}
		break;

		case 2: logger.info("Credit Card:-");
				logger.info("Enter Credit cardNo.:");
				long CreditCardNo= in.nextLong();
				logger.info("Enter Credit Card Name.:");
				String CreditName= in.next();
				logger.info("Enter Credit CVV.:");
				int CreditCVV= in.nextInt();
				logger.info("Enter Amount:");
				Double CreditAmount= in.nextDouble();

		if((CreditCardNo!=0 && String.valueOf(CreditCardNo).length()==16) && (CreditName!= null) && (CreditCVV!= 0)) 
		{
			try 
			{
				if(ni.sendNotification(studentId, mode, fee)) {
					logger.info("payment Done Sucessfully......");
				}else {
					StudentMenu sm = new StudentMenu();
					sm.doPayment(studentId);
				}

			} 
			catch (Exception e) 
			{

				logger.info(e.getMessage());
			}
		}
		else 
		{
			logger.info("Invalid Card Details, Please Retry");

		}
		break;
		}
	}
	/*
	 * Method to pay fee in offline mode
	 * 
	 */
	@Override
	public void offline() {
	logger.info("please pay the fee in the administration office");
		
	}
	
}
