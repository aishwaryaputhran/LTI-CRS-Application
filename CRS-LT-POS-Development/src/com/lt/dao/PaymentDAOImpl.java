package com.lt.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.log4j.Logger;

import com.lt.constants.PaymentMode;
import com.lt.utils.DBUtil;

/*
 * @author G4-FullStackGroup
 * Dao Class Implementation for PaymentDAOImpl
 * 
 */
public class PaymentDAOImpl implements PaymentDAOInterface
{
	private static Logger logger = Logger.getLogger(PaymentDAOImpl.class);
	private static volatile PaymentDAOImpl instance = null;

	private PaymentDAOImpl()
	{
	}
	/**
	 * Method to make PaymentDAOImpl Singleton
	 * @return
	 */
	public static PaymentDAOImpl getInstance()
	{
		if(instance == null)
		{
			synchronized(PaymentDAOImpl.class){
				instance = new PaymentDAOImpl();
			}
		}
		return instance;
	}

	/**
	 * Method to calculate Fee
	 * @param studentId
	 * @returns fee
	 */
	@Override
	public double calculateFee(int studentId) {

		Connection connection=null; 
		PreparedStatement preparedStatement= null;
		ResultSet resultSet = null;
		double fee = 0;
		try
		{
			connection=DBUtil.getConnection();
			String query = "select sum(course_fee) from registered_course where student_id = ?";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, studentId);
			resultSet = preparedStatement.executeQuery();
			resultSet.next();
			fee = resultSet.getDouble(1);
		}
		catch(SQLException e)
		{
			logger.error(e.getErrorCode());
			logger.error(e.getMessage());
		}
		catch(Exception e)
		{
			logger.info(e.getMessage());
		}

		return fee;
	}
	/**
	 * Method to payment
	 * @param studentId,mode,fee
	 * @returns boolean value 
	 */
	@Override
	public boolean payment(int studentId, PaymentMode mode, double fee) {

		Connection connection=null; 
		PreparedStatement preparedStatement= null;
		ResultSet resultSet = null;

		try
		{
			connection=DBUtil.getConnection();
			String query = "insert into payment(student_id, mode, amount, status) values(?,?,?,?);";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, studentId);
			preparedStatement.setString(2, mode.toString());
			preparedStatement.setDouble(3, fee);
			preparedStatement.setString(4, "paid");
			int row = preparedStatement.executeUpdate();

			if(row==1)
				return true;
			else
				return false;

		}
		catch(SQLException e)
		{
			logger.error(e.getErrorCode());
			logger.info(e.getMessage());
		}
		catch(Exception e)
		{
			logger.info(e.getMessage());
		}
		return false;


	}
	/**
	 * Method to get status of payment
	 * @param studentId
	 * @returns payment status
	 */
	@Override
	public String paymentStatus(int studentId) {

		Connection connection=null; 
		PreparedStatement preparedStatement= null;
		ResultSet resultSet = null;
		String status = null;
		try
		{
			connection=DBUtil.getConnection();
			String query = "select status from payment where student_id = ?";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, studentId);
			resultSet = preparedStatement.executeQuery();
			resultSet.next();
			status = resultSet.getString("status");
		}
		catch(SQLException e)
		{
			logger.info(e.getMessage());
		}
		catch(Exception e)
		{
			logger.info(e.getMessage());
		}

		return status;
	}

}