package com.example.configration;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PersonQueueConfig {
	
	@Bean
	public Queue personsQueue() {
		return new Queue("persons.queue");
	}
	
}
