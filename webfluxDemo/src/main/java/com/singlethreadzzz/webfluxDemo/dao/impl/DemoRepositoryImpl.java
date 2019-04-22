package com.singlethreadzzz.webfluxDemo.dao.impl;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

import org.springframework.stereotype.Repository;

import com.singlethreadzzz.webfluxDemo.dao.DemoRepository;
import com.singlethreadzzz.webfluxDemo.domain.Demo;
import com.singlethreadzzz.webfluxDemo.util.AtomicLongIdUtil;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public class DemoRepositoryImpl implements DemoRepository{
	
	private ConcurrentMap<Long, Demo> repository = new ConcurrentHashMap<Long, Demo>();

    @Override
    public Mono<Long> insertDemo(Mono<Demo> demoMono) {
        return demoMono.flatMap(demo -> insertDemo(demo));
    }
    
    @Override
    public Flux<Demo> selectDemo() {
        return Flux.fromIterable(repository.values());
    }

    @Override
    public Mono<Demo> selectDemoById(Long id) {
        return Mono.justOrEmpty(repository.get(id));
    }
    
    @Override
    public Mono<Long> updateDemo(Mono<Demo> demoMono) {
        return demoMono.flatMap(demo -> updateDemo(demo));
    }

    @Override
    public Mono<Long> deleteDemo(Long id) {
        repository.remove(id);
        return Mono.justOrEmpty(id);
    }
    
    private Mono<Long> insertDemo(Demo demo) {
    	Long id = AtomicLongIdUtil.generateAtomicLongId();
        demo.setId(id);
        repository.put(id, demo);
        return Mono.justOrEmpty(id);
    }
    
    private Mono<Long> updateDemo(Demo demo) {
        repository.put(demo.getId(), demo);
        return Mono.justOrEmpty(demo.getId());
    }

}