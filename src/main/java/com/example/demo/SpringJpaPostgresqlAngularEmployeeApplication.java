package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.example.demo.model.Customer;

@SpringBootApplication
@Configuration
//@ComponentScan(basePackageClasses=Customer.class)
public class SpringJpaPostgresqlAngularEmployeeApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringJpaPostgresqlAngularEmployeeApplication.class, args);
	}
}
