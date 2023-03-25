package com.densoft.springbootwebfluxdemo.handler;

import com.densoft.springbootwebfluxdemo.dao.CustomerDao;
import com.densoft.springbootwebfluxdemo.dto.Customer;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class CustomerStreamHandler {
    private final CustomerDao customerDao;

    public Mono<ServerResponse> getCustomers(ServerRequest serverRequest) {
        Flux<Customer> customersStream = customerDao.getCustomersStream();
        return ServerResponse.ok()
                .contentType(MediaType.TEXT_EVENT_STREAM)
                .body(customersStream, Customer.class);
    }
}
