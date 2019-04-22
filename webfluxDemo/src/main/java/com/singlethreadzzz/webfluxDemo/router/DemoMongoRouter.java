package com.singlethreadzzz.webfluxDemo.router;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import com.singlethreadzzz.webfluxDemo.handler.DemoMongoHandler;

@Configuration
public class DemoMongoRouter {
	
    @Bean
    public RouterFunction<ServerResponse> routeDemoMongo(DemoMongoHandler demoMongoHandler) {
        return RouterFunctions
        		.route(RequestPredicates.GET("/helloMongo")
        				.and(RequestPredicates.accept(MediaType.TEXT_PLAIN)), demoMongoHandler::hello)
        		.andRoute(RequestPredicates.GET("/demoMongo")
        				.and(RequestPredicates.accept(MediaType.APPLICATION_JSON_UTF8)), demoMongoHandler::listDemo)
        		.andRoute(RequestPredicates.POST("/demoMongo")
        				.and(RequestPredicates.accept(MediaType.APPLICATION_JSON_UTF8)), demoMongoHandler::createDemo)
        		.andRoute(RequestPredicates.PUT("/demoMongo")
        				.and(RequestPredicates.accept(MediaType.APPLICATION_JSON_UTF8)), demoMongoHandler::updateDemo)
        		.andRoute(RequestPredicates.DELETE("/demoMongo/{id}")
        				.and(RequestPredicates.accept(MediaType.APPLICATION_JSON_UTF8)), demoMongoHandler::deleteDemo)
        		.andRoute(RequestPredicates.GET("/demoMongo/{id}")
        				.and(RequestPredicates.accept(MediaType.APPLICATION_JSON_UTF8)), demoMongoHandler::findDemoById)
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
