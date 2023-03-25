package com.densoft.springbootwebfluxdemo;

import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class MonoFluxTest {
    @Test
    public void testMono() {
        Mono<?> monoString = Mono.just("dennis")
                .then(Mono.error(new RuntimeException("Exception occurred")))
                .log();
        monoString.subscribe(System.out::println, (e) -> System.out.println(e.getMessage()));
    }

    @Test
    public void testFlux() {
        Flux<String> justString = Flux.just("Spring", "Spring Boot", "Hibernate", "microservice")
                .concatWithValues("AWS")
                .concatWith(Flux.error(new RuntimeException("Exception occurred in Flux")))
                .log();
        justString.subscribe(System.out::println,throwable -> System.out.println(throwable.getMessage()));
    }
}
