package com.singlethreadzzz.webfluxDemo.handler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;

import com.singlethreadzzz.webfluxDemo.domain.Demo;
import com.singlethreadzzz.webfluxDemo.service.DemoMongoService;

import reactor.core.publisher.Mono;

@Component
public class DemoMongoHandler {
	
	private final DemoMongoService demoMongoService;
	
	@Autowired
	public DemoMongoHandler(DemoMongoService demoMongoService) {
		this.demoMongoService = demoMongoService;
	}
	
    public Mono<ServerResponse> hello(ServerRequest serverRequest) {
        return ServerResponse.ok()
        		.contentType(MediaType.TEXT_PLAIN)
        		.body(BodyInserters.fromObject("Hello!"));
    }
    
    public Mono<ServerResponse> listDemo(ServerRequest serverRequest) {
    	return ServerResponse.ok()
    			.contentType(MediaType.APPLICATION_JSON_UTF8)
    			.body(demoMongoService.listDemo(), Demo.class);
    }
    
    public Mono<ServerResponse> createDemo(ServerRequest serverRequest) {
    	Mono<Demo> demoMono = serverRequest.bodyToMono(Demo.class);
        return ServerResponse.ok()
        		.contentType(MediaType.APPLICATION_JSON_UTF8)
        		.body(demoMongoService.createDemo(demoMono), Demo.class);
    }
    
    public Mono<ServerResponse> findDemoById(ServerRequest serverRequest) {
    	Long id = Long.valueOf(serverRequest.pathVariable("id"));
    	return ServerResponse.ok()
    			.contentType(MediaType.APPLICATION_JSON_UTF8)
    			.body(demoMongoService.findDemoById(id), Demo.class);
    }
    

    public Mono<ServerResponse> updateDemo(ServerRequest serverRequest) {
    	Mono<Demo> demoMono = serverRequest.bodyToMono(Demo.class);
    	return ServerResponse.ok()
    			.contentType(MediaType.APPLICATION_JSON_UTF8)
    			.body(demoMongoService.updateDemo(demoMono), Demo.class);
    }

    public Mono<ServerResponse> deleteDemo(ServerRequest serverRequest) {
    	Long id = Long.valueOf(serverRequest.pathVariable("id"));
    	return ServerResponse.ok()
    			.contentType(MediaType.APPLICATION_JSON_UTF8)
    			.build(demoMongoService.deleteDemo(id));
    }

}
