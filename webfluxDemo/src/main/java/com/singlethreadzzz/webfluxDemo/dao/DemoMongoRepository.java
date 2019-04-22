package com.singlethreadzzz.webfluxDemo.dao;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import com.singlethreadzzz.webfluxDemo.domain.Demo;

public interface DemoMongoRepository extends ReactiveMongoRepository<Demo, Long>{

}
