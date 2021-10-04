package com.lt.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

import org.apache.log4j.Logger;

import com.lt.business.StudentImplService;
import com.lt.constants.NotificationType;
import com.lt.constants.PaymentMode;
import com.lt.constants.SQLQueries;
import com.lt.utils.DBUtil;

/*
 * 
 * @author G4-FullStackGroup
 * Class to implement Notification Dao 
 * Used for adding the notification to the database
 *
 */
public class NotificationDAOImpl implements NotificationDAOInterface{

	private static Logger logger = Logger.getLogger(NotificationDAOImpl.class);
	private static volatile NotificationDAOImpl instance = null;

	private NotificationDAOImpl()
	{
	}
	/*
	 * Method to make AdminOperation Singleton
	 * @return
	 */
	public static NotificationDAOImpl getInstance()
	{
		if(instance == null)
		{
			synchronized(NotificationDAOImpl.class){
				instance = new NotificationDAOImpl();
			}
		}
		return instance;
	}
	/*
	 * Send Notification using SQL commands
	 * @param type: type of the notification to be sent
	 * @param studentId: student to be notified
	 * @return notification id for the record added in the database
	 * @throws SQLException
	 */
	public int sendNotification(NotificationType type, int studentId,PaymentMode modeOfPayment) throws SQLException{
		int notificationId=0;
		Connection connection=DBUtil.getConnection();
		try
		{
			//INSERT_NOTIFICATION = "insert into notification(studentId,type,referenceId) values(?,?,?);";
			PreparedStatement statement = connection.prepareStatement(SQLQueries.INSERT_NOTIFICATION);
			statement.setInt(1, studentId);
			statement.setString(2,type.toString());
			if(type==NotificationType.PAYMENT)
			{
				//insert into payment, get reference id and add here
				UUID referenceId=addPayment(studentId, modeOfPayment);
				statement.setString(3, referenceId.toString());	
			}
			else
				statement.setString(3,"");

			statement.executeUpdate();
			ResultSet results=statement.getGeneratedKeys();
			if(results.next())
				notificationId=results.getInt(1);
		}
		catch(SQLException ex)
		{
			throw ex;
		}
		return notificationId;
	}

	/**
	 * Perform Payment actions using SQL commands
	 * @param studentId: Id of the student for which the payment is done
	 * @param modeOfPayment: mode of payment used, defined in enum
	 * @return: reference id of the transaction
	 * @throws SQLException
	 */
	public UUID addPayment(int studentId, PaymentMode modeOfPayment) throws SQLException
	{
		UUID referenceId;
		Connection connection=DBUtil.getConnection();
		try
		{
			referenceId=UUID.randomUUID();
			//INSERT_NOTIFICATION = "insert into notification(studentId,type,referenceId) values(?,?,?);";
			PreparedStatement statement = connection.prepareStatement(SQLQueries.INSERT_PAYMENT);
			statement.setInt(1, studentId);
			statement.setString(2, modeOfPayment.toString());
			statement.setString(3,referenceId.toString());
			statement.executeUpdate();
			//check if record is added
		}
		catch(SQLException ex)
		{
			throw ex;
		}
		return referenceId;
	}
}
