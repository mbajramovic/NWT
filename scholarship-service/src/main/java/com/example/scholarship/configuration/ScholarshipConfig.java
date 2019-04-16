package com.example.scholarship.configuration;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ScholarshipConfig {
	@Bean
    public Queue candidateQueue() {
		//System.out.println("ajla consumerconfig");
        return new Queue("persons.queue");
	}
	/*
	 @Bean
	 public Queue userUpdatedQueue() {
		 return new Queue("user_updated_queue");
	 }
	 */
}
