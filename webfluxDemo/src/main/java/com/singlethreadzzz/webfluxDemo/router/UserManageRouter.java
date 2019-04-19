package com.singlethreadzzz.webfluxDemo.router;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import com.singlethreadzzz.webfluxDemo.handler.UserManageHandler;

@Configuration
public class UserManageRouter {
	
    @Bean
    public RouterFunction<ServerResponse> routeUser(UserManageHandler userManageHandler) {
        return RouterFunctions.route(RequestPredicates.GET("/userManage")
        											  .and(RequestPredicates.accept(MediaType.TEXT_PLAIN)), userManageHandler::helloUser);
    }

}
