package com.example.configuration;

import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConsumerConfig {

	@Bean
    public Queue candidateQueue() {
        return new Queue("candidates.queue");
    }
}
