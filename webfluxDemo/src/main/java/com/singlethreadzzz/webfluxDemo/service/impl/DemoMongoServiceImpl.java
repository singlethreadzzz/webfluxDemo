package com.singlethreadzzz.webfluxDemo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.singlethreadzzz.webfluxDemo.dao.DemoMongoRepository;
import com.singlethreadzzz.webfluxDemo.domain.Demo;
import com.singlethreadzzz.webfluxDemo.service.DemoMongoService;
import com.singlethreadzzz.webfluxDemo.util.AtomicLongIdUtil;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class DemoMongoServiceImpl implements DemoMongoService{
	
	private final DemoMongoRepository demoMongoRepository;
	
	@Autowired
	public DemoMongoServiceImpl(DemoMongoRepository demoMongoRepository) {
		this.demoMongoRepository = demoMongoRepository;
	}

	@Override
	public Mono<Demo> createDemo(Mono<Demo> demoMono) {
		return demoMono.flatMap(demo -> {
			Long id = AtomicLongIdUtil.generateAtomicLongId();
			demo.setId(id);
			System.out.println(demo.toString());
			return this.demoMongoRepository.insert(demo);
		});
	}

	@Override
	public Flux<Demo> listDemo() {
		return this.demoMongoRepository.findAll();
	}

	@Override
	public Mono<Demo> findDemoById(Long id) {
		return this.demoMongoRepository.findById(id);
	}

	@Override
	public Mono<Demo> updateDemo(Mono<Demo> demoMono) {
		return demoMono.flatMap(demo -> this.demoMongoRepository.save(demo));
	}

	@Override
	public Mono<Void> deleteDemo(Long id) {
		return this.demoMongoRepository.deleteById(id);
	}

}
