package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.example.services")
public class AppDemo  {

	public static void main(String[] args) {
		SpringApplication.run(AppDemo.class, args);
	}


}
