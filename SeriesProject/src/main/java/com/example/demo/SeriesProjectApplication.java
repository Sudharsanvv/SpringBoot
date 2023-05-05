package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;

@SpringBootApplication
@OpenAPIDefinition(info=@Info(
		title="Series",
		version="1.1.2",
		description="Series",
		contact=@Contact(name="Sudharsan",email="727821tuec235@skct.edu.in")))
public class SeriesProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(SeriesProjectApplication.class, args);
	}

}
