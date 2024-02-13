package com.bridgelabz.user.service;

import org.springframework.http.ResponseEntity;
import org.springframework.web.reactive.function.server.ServerResponse;

import com.bridgelabz.response.Response;
import com.bridgelabz.user.dto.UserDto;
import com.bridgelabz.user.model.User;

import reactor.core.publisher.Mono;

public interface IUserService {

	Mono<Object> save(UserDto userDto);
}
