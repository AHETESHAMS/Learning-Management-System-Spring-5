package com.bridgelabz.user.repository;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;

import org.springframework.stereotype.Repository;

import com.bridgelabz.user.model.User;

import reactor.core.publisher.Mono;

import java.util.*;

@Repository
public interface UserRepository extends ReactiveCrudRepository<User, Integer> {

	Mono<User> findByEmail(String email);

}
