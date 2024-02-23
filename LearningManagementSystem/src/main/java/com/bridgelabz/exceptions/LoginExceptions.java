package com.bridgelabz.exceptions;

public class LoginExceptions {

	private String message;
	private int errorCode;
	
	public LoginExceptions(String message, int errorCode) {
		super();
		this.message = message;
		this.errorCode = errorCode;
	}
	
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	public int getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(int errorCode) {
		this.errorCode = errorCode;
	}
	
}
