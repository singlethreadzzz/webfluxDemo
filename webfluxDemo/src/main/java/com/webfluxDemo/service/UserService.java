package com.webfluxDemo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.webfluxDemo.domain.User;
import com.webfluxDemo.repository.UserRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * @author 高坂穗乃果
 *
 */
@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	public Mono<User> getUserById(Long id) {
		return this.getUserById(id);
	}

	public Mono<User> saveUser(User user) {
		return this.userRepository.saveUser(user);
	}

	public Flux<User> getAllUsers() {
		return this.userRepository.getAllUsers();
	}

}
