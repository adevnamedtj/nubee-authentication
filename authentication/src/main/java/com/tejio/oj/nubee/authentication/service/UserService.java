package com.tejio.oj.nubee.authentication.service;

import com.tejio.oj.nubee.authentication.model.User;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface UserService {

	Mono<Boolean> authenticate(String userId, String password);

	Mono<User> getUser(String userId);

	Flux<User> getAllUsers();

	Mono<User> createOrUpdateUser(User user);

	Mono<Void> removeUser(String userId);

	Flux<User> loadDummyData();

}
