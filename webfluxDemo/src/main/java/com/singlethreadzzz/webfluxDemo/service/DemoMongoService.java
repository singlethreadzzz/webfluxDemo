package com.singlethreadzzz.webfluxDemo.service;

import com.singlethreadzzz.webfluxDemo.domain.Demo;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface DemoMongoService {
	
    public Mono<Demo> createDemo(Mono<Demo> demoMono);

    public Flux<Demo> listDemo();

    public Mono<Demo> findDemoById(Long id);

    public Mono<Demo> updateDemo(Mono<Demo> demoMono);

    public Mono<Void> deleteDemo(Long id);

}
