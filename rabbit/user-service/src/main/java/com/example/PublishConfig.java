package com.example;


import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PublishConfig {
	@Bean
    public Queue candidateQueue() {
        return new Queue("candidates.queue");
    }

}
