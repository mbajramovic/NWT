package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.rest.RepositoryRestMvcAutoConfiguration;

@SpringBootApplication
//@ComponentScan("com.example.services")
@EnableAutoConfiguration(exclude = RepositoryRestMvcAutoConfiguration.class)
public class AppDemo  {

	public static void main(String[] args) {
		SpringApplication.run(AppDemo.class, args);
	}


}
