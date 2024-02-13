package com.bridgelabz.user.service;

import java.time.LocalDate;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.server.ServerResponse;

import com.bridgelabz.exceptions.RegistrationException;
import com.bridgelabz.response.Response;
import com.bridgelabz.user.dto.UserDto;
import com.bridgelabz.user.model.User;
import com.bridgelabz.user.repository.UserRepository;
import com.bridgelabz.util.StatusHelper;

import reactor.core.publisher.Mono;

@Service
public class UserServiceImpl implements IUserService {
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	private ModelMapper modelMapper;
	
	
	public Mono<Object> save(UserDto userDto) {
	    User user = modelMapper.map(userDto, User.class);
	    System.out.println("Before Mapping DTO: " + userDto);
	  
	   
	     return userRepository.findByEmail(user.getEmail())
	            .flatMap(existingUser -> Mono.error(new RegistrationException(HttpStatus.BAD_REQUEST.value(), "User with the provided email already exists")))
	            .switchIfEmpty(userRepository.save(user)
	                    .then(Mono.just(ResponseEntity.ok().body(StatusHelper.statusInfo("User registered successfully", HttpStatus.OK.value()))))
	                    .onErrorResume(error -> Mono.just(ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build())));
	}
	   





//	@Override
//	public Mono<ServerResponse> save(UserDto userDto) {
//		User user = modelMapper.map(userDto, User.class);
//		System.out.println("Before Mapping DTO"+userDto);
//		Mono<User> userExist = userRepository.findByEmail(user.getEmail());
//		System.out.println("User Exist: "+userExist.get());
//		System.out.println("After Mapping"+user.toString());
//		user.setRegisterdate(LocalDate.now());
//		System.out.println("After Setting Register Date");
//		boolean isUserPresent = userExist.isPresent();
//		System.out.println("Boolean Is User Present"+isUserPresent);
//		if (isUserPresent) {
//	        return Mono.error(new RegistrationException(HttpStatus.BAD_REQUEST.value(), "User with the provided email already exists"));
//	    } else {
//	    	System.out.println("Inside Else");
//	        return userRepository.save(user)
//	            .flatMap(savedUser -> ServerResponse.ok().bodyValue(StatusHelper.statusInfo("User registered successfully", HttpStatus.OK.value())))
//	            .switchIfEmpty(ServerResponse.status(HttpStatus.INTERNAL_SERVER_ERROR).build());
//	    }
//	}
//
}

