package com.bridgelabz.response;

import org.springframework.http.HttpStatus;

public class Response {

	private String message;
	private int code;
	
	public Response(String message, int code) {
		super();
		this.message = message;
		this.code = code;
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
	@Override
	public String toString() {
		return "Response [message=" + message + ", code=" + code + "]";
	}

}
