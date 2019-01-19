package com.webfluxDemo.route;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import com.webfluxDemo.handler.DemoHandler;

@Configuration
public class DemoRoute {

	@Autowired
	private DemoHandler demoHandler;

	@Bean
	public RouterFunction<ServerResponse> userRoute() {
		return RouterFunctions.route(RequestPredicates.GET("/getAllUsers"), demoHandler::getAllUsers).andRoute(
				RequestPredicates.POST("/saveUser").and(RequestPredicates.accept(MediaType.APPLICATION_JSON_UTF8)),
				demoHandler::saveUser);
	}

}
