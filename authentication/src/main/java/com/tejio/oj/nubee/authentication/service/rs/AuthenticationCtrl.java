package com.tejio.oj.nubee.authentication.service.rs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tejio.oj.nubee.authentication.model.User;
import com.tejio.oj.nubee.authentication.service.UserService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/service")
public class AuthenticationCtrl {

	@Autowired
	private UserService userService;

	@PostMapping("/authenticate")
	private Mono<Boolean> authenticate(@RequestParam("username") String userId,
			@RequestParam("password") String passwordHash) {

		return userService.authenticate(userId, passwordHash);
	}

	@GetMapping("/user/{userid}")
	private Mono<User> getUser(@PathVariable("userid") String userId) {
		return userService.getUser(userId);
	}

	@GetMapping("/users")
	private Flux<User> getUsers() {
		return userService.getAllUsers();
	}

	@PostMapping("/user")
	private Mono<User> createUser(@RequestBody User user) {
		return userService.createOrUpdateUser(user);
	}

	@PutMapping("/user")
	private Mono<User> updateUser(@RequestBody User user) {
		return userService.createOrUpdateUser(user);
	}

	@DeleteMapping("/user/{userid}")
	private Mono<Void> deleteUser(@PathVariable("userid") String userId) {
		return userService.removeUser(userId);
	}

	@GetMapping("/user/load/{datatype}")
	private Flux<User> loadData(@PathVariable("datatype") String dataType) {
		if ("dummy".equals(dataType)) {
			return userService.loadDummyData();
		} else {
			return null;
		}

	}
}
