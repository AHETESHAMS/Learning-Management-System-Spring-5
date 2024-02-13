package com.bridgelabz.exceptionhandler;

import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.bridgelabz.exceptions.RegistrationException;
import com.bridgelabz.response.Response;
import com.bridgelabz.util.StatusHelper;

import reactor.core.publisher.Mono;

@RestControllerAdvice
public class ExceptionHandler {
	
	@org.springframework.web.bind.annotation.ExceptionHandler(value = RegistrationException.class)
	public Mono<Response> registrationExceptionHandler(RegistrationException registrationExceptions) {
		
		Response response = StatusHelper.statusInfo("User Exist", 201);
		return Mono.just(response);
	}
}
