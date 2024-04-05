package com.personal.testApp;

import com.personal.testApp.controller.exceptions.RestExceptionHandler;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import(RestExceptionHandler.class)
@OpenAPIDefinition
public class TestAppplication {

    public static void main(String[] args) {
        SpringApplication.run(TestAppplication.class, args);
    }
}
