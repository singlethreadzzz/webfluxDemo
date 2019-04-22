package com.singlethreadzzz.webfluxDemo.router;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import com.singlethreadzzz.webfluxDemo.handler.DemoHandler;

@Configuration
public class DemoRouter {
	
    @Bean
    public RouterFunction<ServerResponse> routeDemo(DemoHandler demoHandler) {
        return RouterFunctions
        		.route(RequestPredicates.GET("/hello")
        				.and(RequestPredicates.accept(MediaType.TEXT_PLAIN)), demoHandler::hello)
        		.andRoute(RequestPredicates.GET("/demo")
        				.and(RequestPredicates.accept(MediaType.APPLICATION_JSON_UTF8)), demoHandler::listDemo)
        		.andRoute(RequestPredicates.POST("/demo")
        				.and(RequestPredicates.accept(MediaType.APPLICATION_JSON_UTF8)), demoHandler::createDemo)
        		.andRoute(RequestPredicates.PUT("/demo")
        				.and(RequestPredicates.accept(MediaType.APPLICATION_JSON_UTF8)), demoHandler::updateDemo)
        		.andRoute(RequestPredicates.DELETE("/demo/{id}")
        				.and(RequestPredicates.accept(MediaType.APPLICATION_JSON_UTF8)), demoHandler::deleteDemo)
        		.andRoute(RequestPredicates.GET("/demo/{id}")
        				.and(RequestPredicates.accept(MediaType.APPLICATION_JSON_UTF8)), demoHandler::findDemoById)
        		.filter((request, next) -> {
						if (request.path() != null) {
							return next.handle(request);
						}
						else {
							return ServerResponse.status(HttpStatus.UNAUTHORIZED).build();
						}
        		});
    }

}
