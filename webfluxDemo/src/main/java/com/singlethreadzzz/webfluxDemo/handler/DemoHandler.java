package com.singlethreadzzz.webfluxDemo.handler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;

import com.singlethreadzzz.webfluxDemo.domain.Demo;
import com.singlethreadzzz.webfluxDemo.service.DemoService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
public class DemoHandler {
	
	private final DemoService demoService;
	
	@Autowired
	public DemoHandler(DemoService demoService) {
		this.demoService = demoService;
	}
	
    public Mono<ServerResponse> hello(ServerRequest serverRequest) {
        return ServerResponse.ok()
        		.contentType(MediaType.TEXT_PLAIN)
        		.body(BodyInserters.fromObject("Hello!"));
    }
    
    public Mono<ServerResponse> listDemo(ServerRequest serverRequest) {
    	Flux<Demo> demoFlux = demoService.listDemo();
    	return ServerResponse.ok()
    			.contentType(MediaType.APPLICATION_JSON_UTF8)
    			.body(demoFlux, Demo.class);
    }
    
    public Mono<ServerResponse> createDemo(ServerRequest serverRequest) {
    	Mono<Demo> demoMono = serverRequest.bodyToMono(Demo.class);
        return ServerResponse.ok()
        		.contentType(MediaType.APPLICATION_JSON_UTF8)
        		.body(demoService.createDemo(demoMono), Long.class);
    }
    
    public Mono<ServerResponse> findDemoById(ServerRequest serverRequest) {
    	Mono<Demo> demoMono = demoService.findDemoById(Long.valueOf(serverRequest.pathVariable("id")));
    	return ServerResponse.ok()
    			.contentType(MediaType.APPLICATION_JSON_UTF8)
    			.body(demoMono, Demo.class);
    }

    public Mono<ServerResponse> updateDemo(ServerRequest serverRequest) {
    	Mono<Demo> demoMono = serverRequest.bodyToMono(Demo.class);
    	return ServerResponse.ok()
    			.contentType(MediaType.APPLICATION_JSON_UTF8)
    			.body(demoService.updateDemo(demoMono), Long.class);
    }

    public Mono<ServerResponse> deleteDemo(ServerRequest serverRequest) {
    	Long id = Long.valueOf(serverRequest.pathVariable("id"));
    	return ServerResponse.ok()
    			.contentType(MediaType.APPLICATION_JSON_UTF8)
    			.body(demoService.deleteDemo(id), Long.class);
    }

}
