package com.example.configuration;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableRabbit
public class PersonQueueConfig {

	@Bean
	public Queue candidateQueue() {
		return new Queue("persons.queue");
	}

/*
    @Bean
    public Queue userUpdatedQueue() {
        return new Queue("user_updated_queue");
    }
*/
}
