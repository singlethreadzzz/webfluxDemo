package com.webfluxDemo.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoTest {
	
	private Flux<Integer> generateFluxFrom1To6() {
	    return Flux.just(1, 2, 3, 4, 5, 6);
	}
	
	private Mono<Integer> generateMonoWithError() {
	    return Mono.error(new Exception("some error"));
	}
	
	@Test
	public void testViaStepVerifier() {
	    StepVerifier.create(generateFluxFrom1To6())
	            .expectNext(1, 2, 3, 4, 5, 6)
	            .expectComplete()
	            .verify();
	    StepVerifier.create(generateMonoWithError())
	            .expectErrorMessage("some error")
	            .verify();
	}

}
