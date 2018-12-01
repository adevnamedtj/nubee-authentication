package com.tejio.oj.nubee.authentication.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tejio.oj.nubee.authentication.model.User;
import com.tejio.oj.nubee.authentication.model.Address;
import com.tejio.oj.nubee.authentication.model.Package;
import com.tejio.oj.nubee.authentication.repository.UserRespository;

import reactor.core.CoreSubscriber;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRespository userRepository;

	@Override
	public Mono<Boolean> authenticate(String userId, String passwordHash) {
		return userRepository.existsByUserIdAndPasswordHash(userId, passwordHash).doOnSuccess(x -> {
			if (!x) {
				throw new RuntimeException("Unauthorized");
			}
		});
	}

	@Override
	public Mono<User> getUser(String userId) {
		return userRepository.findById(userId);
	}

	@Override
	public Flux<User> getAllUsers() {
		return userRepository.findAll();
	}

	@Override
	public Mono<User> createOrUpdateUser(User user) {
		return userRepository.save(user);
	}

	@Override
	public Mono<Void> removeUser(String userId) {
		return userRepository.deleteById(userId);
	}

	@Override
	public Flux<User> loadDummyData() {
		String userId = "userId";
		String firstName = "firstName";
		String lastName = "lastName";
		String passwordHash = "passwordHash";

		String addressLine1 = "20 Spencer St";
		String addressLine2 = null;
		String city = "Torrance";
		String state = "CA";
		String country = "USA";
		String zipcode = "90503";
		Boolean isAllowedToReachout = true;

		List<Package> packages = new ArrayList<>();
		List<String> policyIds = new ArrayList<>(Arrays.asList("policy1", "policy2"));
		packages.add(new Package("nubee-vip", "nubee-vip", policyIds, LocalDateTime.now()));
		List<Package> packages2 = new ArrayList<>();
		List<String> policyIds2 = new ArrayList<>(Arrays.asList("policy3", "policy4"));
		packages2.add(new Package("nubee-sport", "nubee-sport", policyIds2, LocalDateTime.now()));

		List<User> users = new ArrayList<User>();

		for (int i = 11; i <= 20; i++) {
			User user;
			Address address = new Address("Home", "Shipping", i + addressLine1, addressLine2, city, state, country,
					zipcode, isAllowedToReachout);
			Address billingAddress = new Address("Home", "Billing", i + addressLine1, addressLine2, city, state,
					country, zipcode, isAllowedToReachout);

			if (i % 2 == 0) {
				user = new User(userId + i, firstName + i, lastName + i, passwordHash + i,
						firstName + i + lastName + "@xyz.com",
						new ArrayList<>(Arrays.asList(i + "3418446191", i + "2273750237")), LocalDateTime.now(),
						packages, address, billingAddress);
			} else {
				user = new User(userId + i, firstName + i, lastName + i, passwordHash + i,
						firstName + i + lastName + "@xyz.com",
						new ArrayList<>(Arrays.asList(i + "3418446191", i + "2273750237")), LocalDateTime.now(),
						packages2, address, billingAddress);
			}
			users.add(user);
		}

		return userRepository.saveAll(users);

	}

}
