package com.cis440;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@OpenAPIDefinition(info =
@Info(
		title = "CIS 440 API",
		version = "0.0.1-SNAPSHOT",
		description = "CIS 440 Group 1 API"
)
)
@SpringBootApplication
public class SpringApplication {

	public static void main(String[] args) {
		org.springframework.boot.SpringApplication.run(SpringApplication.class, args);
	}
}
