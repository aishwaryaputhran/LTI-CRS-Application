package com.lt.exception;
/*
 * @author G4-FullStackGroup
 * Implementations of CourseFoundException extends Exception
 * 
 */
public class UserNotFoundException extends Exception {

		private String userId;
		
		public UserNotFoundException(String userId) {
			this.userId = userId;
		}

		public String getUserId() {
			return userId;
		}

	}

