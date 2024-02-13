package com.bridgelabz.util;

import com.bridgelabz.response.Response;

public class StatusHelper {
	
	public static Response statusInfo(String message, int code) {
		
		Response response = new Response();
		response.setMessage(message);
		response.setCode(code);
		return response;
	}

}
