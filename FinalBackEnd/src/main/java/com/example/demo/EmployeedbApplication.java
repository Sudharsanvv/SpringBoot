package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;

@SpringBootApplication

@OpenAPIDefinition(info=@Info(

		title="STARIST",

		version="1.1.2",

		description="EMPLOYEE DATABASE",

		contact=@Contact(name="Sudharsan V V",email="727821tuec235@skct.edu.in")))
public class EmployeedbApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmployeedbApplication.class, args);
	}

}