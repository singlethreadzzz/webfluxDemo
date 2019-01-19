package com.webfluxDemo.handler;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;

import com.webfluxDemo.domain.User;
import com.webfluxDemo.service.UserService;

import reactor.core.publisher.Mono;

@Component
public class DemoHandler {

	private UserService userService;

	public Mono<ServerResponse> getAllUsers(ServerRequest serverRequest) {
		return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON_UTF8).body(this.userService.getAllUsers(),
				User.class);
	}

	public Mono<ServerResponse> saveUser(ServerRequest serverRequest) {
		return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON_UTF8).body(this.userService.getAllUsers(),
				User.class);
	}

//	public Mono<ServerResponse> getUserById(ServerRequest serverRequest) {
//		return ServerResponse
//				.ok()
//				.body(serverRequest.queryParam("id"), User.class);
//	}

}
