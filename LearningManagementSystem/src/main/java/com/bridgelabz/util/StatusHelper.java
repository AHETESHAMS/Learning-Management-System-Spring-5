package com.bridgelabz.util;

import com.bridgelabz.response.Response;
import com.bridgelabz.response.ResponseToken;

public class StatusHelper {
	
	public static Response statusInfo(String message, int code) {
		
		Response response = new Response();
		response.setMessage(message);
		response.setCode(code);
		return response;
	}
	
	public static ResponseToken loginStatus(String message, int code, String token, String name, String email)
	{
		ResponseToken loginResponseToken = new ResponseToken();
		loginResponseToken.setMessage(message);
		loginResponseToken.setCode(code);
		loginResponseToken.setToken(token);
		loginResponseToken.setName(name);
		loginResponseToken.setEmailId(email);
		return loginResponseToken;
	}

	public static Object errorStatus(String string) {
		return null;
	}

}
