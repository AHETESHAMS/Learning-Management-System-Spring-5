package com.bridgelabz.response;

public class ResponseToken {
	
	private String message;
	private int code;
	private String token;
	private String name;
	private String emailId;
	
	public ResponseToken(String message, int code, String token, String name, String emailId) {
		super();
		this.message = message;
		this.code = code;
		this.token = token;
		this.name = name;
		this.emailId = emailId;
	}
	public ResponseToken() {
		// TODO Auto-generated constructor stub
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	@Override
	public String toString() {
		return "ResponseToken [message=" + message + ", code=" + code + ", token=" + token + ", name=" + name
				+ ", emailId=" + emailId + "]";
	}

}
