package com.lt.business;

public class NotificationImplService implements NotificationInterface
{

	@Override
	public String getNotify() 
	{
		return  "Payment Successful";
	}

}
