package com.example;


import org.springframework.amqp.core.Exchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableRabbit
public class PublishConfig {
	
	/*@Bean
	public Exchange eventExhange() {
		System.out.println("ajla exchange");
		return new TopicExchange("candidates.direct");
	}*/
	
	
	@Bean
    public Queue candidateQueue() {
		System.out.println("ajla queue");
        return new Queue("candidates.queue");
    }

}