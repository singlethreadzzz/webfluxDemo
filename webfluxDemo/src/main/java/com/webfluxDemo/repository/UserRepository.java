package com.webfluxDemo.repository;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.stereotype.Repository;

import com.webfluxDemo.domain.User;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public class UserRepository {

	private static Map<Long, User> userMap = new ConcurrentHashMap<>();

	public Mono<User> getUserById(Long id) {
		if(userMap.containsKey(id)) {
			return Mono.just(userMap.get(id));
		}
		return Mono.empty();
	}

	public Mono<User> saveUser(User user) {
		userMap.put(user.getId(), user);
		return Mono.just(user);
	}

	public Flux<User> getAllUsers() {
		if(userMap.isEmpty()) {
			User user = new User();
			user.setId(Long.valueOf(1));
			user.setName("1");
			user.setPeople(true);
			user.setDatetime(Timestamp.valueOf(LocalDateTime.now()));
			userMap.put(user.getId(), user);
		}
		return Flux.fromIterable(userMap.values());
	}

}
