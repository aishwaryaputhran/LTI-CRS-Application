package com.lt.business;

import java.util.Date;
import java.util.Scanner;

public class PaymentImplService implements PaymentInterface {

	NotificationInterface ni = new NotificationImplService();

	@Override
	public void getPayment()
	{
		System.out.println("<-----Choose Payment Mode-------->");
		System.out.println("1.Online"+"\n"+"2.Offline");
		Scanner in = new Scanner(System.in);
		int PaymentMode= in.nextInt();

		switch(PaymentMode)
		{
		case 1: System.out.println("Online:-");
		online();                 
		break;

		case 2: System.out.println("Offline:-");
		offline();
		break;
		}
	}

	//	@Override
	//	public String getNotification() {
	//	
	//		
	//		return "Payment Successful";
	//		
	//	}

	@Override
	public void online() 
	{
		System.out.println("<-----Choose online Mode-------->");
		System.out.println("1.Debit card"+"\n"+"2.Credit card");
		Scanner in = new Scanner(System.in);
		int Mode= in.nextInt();

		switch(Mode)
		{
		case 1: System.out.println("Debit Card:-");
				System.out.println("Enter Debit cardNo.:");
				long CardNo= in.nextLong();
				System.out.println("Enter Debit Card Name.:");
				String Name= in.next();
				System.out.println("Enter Debit CVV.:");
				int CVV= in.nextInt();
				System.out.println("Enter Amount:");
				Double Amount= in.nextDouble();
				if((CardNo!=0 && String.valueOf(CardNo).length()==16) && (Name!= null) && (CVV!= 0)) 
				{
					System.out.println(ni.getNotify());
					break;
				}
				else
				{
					System.out.println("Invalid Card Details, Please Retry");
				}
				break;

		case 2: System.out.println("Credit Card:-");
				System.out.println("Enter Credit cardNo.:");
				long CreditCardNo= in.nextLong();
				System.out.println("Enter Credit Card Name.:");
				String CreditName= in.next();
				System.out.println("Enter Credit CVV.:");
				int CreditCVV= in.nextInt();
				System.out.println("Enter Amount:");
				Double CreditAmount= in.nextDouble();
		
				if((CreditCardNo!=0 && String.valueOf(CreditCardNo).length()==16) && (CreditName!= null) && (CreditCVV!= 0)) 
				{
					System.out.println(ni.getNotify());
					break;
				}
				else 
				{
					System.out.println("Invalid Card Details, Please Retry");
					
				}
				break;
		}
	}

	@Override
	public void offline() {
		System.out.println("Please pay cash  to Admin Office");

	}

}
