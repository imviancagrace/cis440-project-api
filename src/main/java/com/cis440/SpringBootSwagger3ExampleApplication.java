package com.cis440;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@OpenAPIDefinition(info =
@Info(
		title = "CIS 440 API",
		version = "0.0.1-SNAPSHOT",
		description = "CIS 440 Group 1 API"
)
)
@SpringBootApplication
public class SpringBootSwagger3ExampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootSwagger3ExampleApplication.class, args);
	}
}
