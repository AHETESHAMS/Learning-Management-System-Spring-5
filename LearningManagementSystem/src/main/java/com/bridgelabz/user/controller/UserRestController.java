package com.bridgelabz.user.controller;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.server.ServerResponse;

import com.bridgelabz.exceptions.RegistrationException;
import com.bridgelabz.response.Response;
import com.bridgelabz.response.ResponseToken;
import com.bridgelabz.user.dto.LoginDto;
import com.bridgelabz.user.dto.UserDto;
import com.bridgelabz.user.model.User;
import com.bridgelabz.user.service.UserServiceImpl;
import com.bridgelabz.util.StatusHelper;

import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/user")
public class UserRestController {
	
	@Autowired
	UserServiceImpl userServiceImpl;
	
	@PostMapping("/register")
    public Mono<ResponseEntity<Response>> registerUser(@RequestBody UserDto userDto) {
        return userServiceImpl.save(userDto)
                .flatMap(savedUser -> Mono.just(ResponseEntity.ok().body(StatusHelper.statusInfo("User registered successfully", HttpStatus.OK.value()))))
                .onErrorResume(RegistrationException.class, ex -> {
                    return Mono.just(ResponseEntity.badRequest().body(StatusHelper.statusInfo(ex.getMessage(), HttpStatus.BAD_REQUEST.value())));
                });
    
	}
	
	@PostMapping("/login")
	public Mono<ResponseEntity<ResponseToken>> login(@RequestBody LoginDto loginDto) {
	    return userServiceImpl.loginService(loginDto)
	            .onErrorResume(Exception.class, e -> {
	                // Handle exceptions without LOGGER
	                return Mono.just(ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
	                        .body(new ResponseToken("", 500, "", "", ""))); // Create a ResponseToken with minimal details
	            });
	}

}
