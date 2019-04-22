package com.singlethreadzzz.webfluxDemo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.singlethreadzzz.webfluxDemo.dao.DemoRepository;
import com.singlethreadzzz.webfluxDemo.domain.Demo;
import com.singlethreadzzz.webfluxDemo.service.DemoService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class DemoServiceImpl implements DemoService{
	
	private final DemoRepository demoRepository;
	
	@Autowired
	public DemoServiceImpl(DemoRepository demoRepository) {
		this.demoRepository = demoRepository;
	}

	@Override
	public Mono<Long> createDemo(Mono<Demo> demo) {
		return this.demoRepository.insertDemo(demo);
	}

	@Override
	public Flux<Demo> listDemo() {
		return this.demoRepository.selectDemo();
	}

	@Override
	public Mono<Demo> findDemoById(Long id) {
		return this.demoRepository.selectDemoById(id);
	}

	@Override
	public Mono<Long> updateDemo(Mono<Demo> demoMono) {
		return this.demoRepository.updateDemo(demoMono);
	}

	@Override
	public Mono<Long> deleteDemo(Long id) {
		return this.demoRepository.deleteDemo(id);
	}

}
