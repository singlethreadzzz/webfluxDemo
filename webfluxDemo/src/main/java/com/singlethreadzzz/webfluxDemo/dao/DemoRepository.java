package com.singlethreadzzz.webfluxDemo.dao;

import com.singlethreadzzz.webfluxDemo.domain.Demo;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface DemoRepository {
	
    public Mono<Long> insertDemo(Mono<Demo> demoMono);

    public Flux<Demo> selectDemo();

    public Mono<Demo> selectDemoById(Long id);

    public Mono<Long> updateDemo(Mono<Demo> demoMono);

    public Mono<Long> deleteDemo(Long id);

}
