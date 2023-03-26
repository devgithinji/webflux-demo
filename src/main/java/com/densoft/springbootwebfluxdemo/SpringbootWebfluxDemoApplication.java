package com.densoft.springbootwebfluxdemo;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(
        info = @Info(
                title = "Spring web flux crud example",
                version = "1.0",
                description = "sample documentation"
        )
)
public class SpringbootWebfluxDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootWebfluxDemoApplication.class, args);
    }

}
