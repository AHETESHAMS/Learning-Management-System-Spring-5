package com.bridgelabz.user.service;

import java.time.LocalDate;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.bridgelabz.exceptions.RegistrationException;
import com.bridgelabz.response.ResponseToken;
import com.bridgelabz.user.dto.LoginDto;
import com.bridgelabz.user.dto.UserDto;
import com.bridgelabz.user.model.User;
import com.bridgelabz.user.repository.UserRepository;
import com.bridgelabz.util.StatusHelper;
import com.bridgelabz.util.UserToken;

import reactor.core.publisher.Mono;

@Service
public class UserServiceImpl implements IUserService {
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	EmailService emailService;
	
	@Autowired
	PasswordEncoder passwordEncoder;

	  
	public Mono<Object> save(UserDto userDto) {
		
		userDto.setPassword(passwordEncoder.encode(userDto.getPassword()));  
	    User user = modelMapper.map(userDto, User.class);
	    System.out.println("Before Mapping DTO: " + userDto); 
	    user.setRegisterdate(LocalDate.now());
	       
	    return userRepository.findByEmail(user.getEmail())
	    		.flatMap(userExist -> Mono.error(new RegistrationException(HttpStatus.BAD_REQUEST.value(), "User Exist")))
	    		.switchIfEmpty(userRepository.save(user)
	    				.then(Mono.just(ResponseEntity.ok().body(StatusHelper.statusInfo("User Saved", HttpStatus.OK.value())))));
	    		    	   
	    	   
	}
	
	public Mono<ResponseEntity<ResponseToken>> loginService(LoginDto loginDto) {
		
			return userRepository.findByEmail(loginDto.getEmail())
	        .switchIfEmpty(Mono.error(new IllegalStateException("User not found")))
	        .flatMap(user -> {
	            if (passwordEncoder.matches(loginDto.getPassword(), user.getPassword())) {
	                try {
	                    String token = UserToken.generateToken(user.getId()); // Assuming secure token generation
	                    return Mono.just(ResponseEntity.ok()
	                        .body(new ResponseToken(token, 200, user.getName(), user.getEmail(), token)));
	                } catch (Exception e) {
	                    return Mono.error(new RuntimeException("Error generating token: " + e.getMessage()));
	                }
	            } else {
	                return Mono.error(new IllegalArgumentException("Incorrect password"));
	            }
	        })
	        .onErrorResume(Exception.class, e -> Mono.just(ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
	                .body(new ResponseToken("", 500, "", "", "")))); // Create a ResponseToken with minimal details

	}
	
	}

