package com.densoft.springbootwebfluxdemo.router;

import com.densoft.springbootwebfluxdemo.handler.CustomerHandler;
import com.densoft.springbootwebfluxdemo.handler.CustomerStreamHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

@Configuration
@RequiredArgsConstructor
public class RouterConfig {

    private final CustomerHandler customerHandler;
    private final CustomerStreamHandler customerStreamHandler;

    @Bean
    public RouterFunction<ServerResponse> routerFunction() {
        return RouterFunctions.route()
                .GET("/router/customers", customerHandler::loadCustomers)
                .GET("/router/customers/stream", customerStreamHandler::getCustomers)
                .GET("/router/customers/{input}", customerHandler::findCustomer)
                .POST("/router/customers/save", customerHandler::saveCustomer)
                .build();
    }


}