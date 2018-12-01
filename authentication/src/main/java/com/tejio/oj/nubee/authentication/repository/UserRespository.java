package com.tejio.oj.nubee.authentication.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import com.tejio.oj.nubee.authentication.model.User;

import reactor.core.publisher.Mono;

public interface UserRespository extends ReactiveMongoRepository<User, String> {

	Mono<Boolean> existsByUserIdAndPasswordHash(String userId, String passwordHash);

}
