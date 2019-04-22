package com.singlethreadzzz.webfluxDemo.service;

import com.singlethreadzzz.webfluxDemo.domain.Demo;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface DemoService {
	
    public Mono<Long> createDemo(Mono<Demo> demo);

    public Flux<Demo> listDemo();

    public Mono<Demo> findDemoById(Long id);

    public Mono<Long> updateDemo(Mono<Demo> demo);

    public Mono<Long> deleteDemo(Long id);

}
