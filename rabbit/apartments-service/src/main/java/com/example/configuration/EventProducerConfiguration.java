/*package com.example.configuration;

import org.springframework.amqp.core.Exchange;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.services.PersonService;

@Configuration
public class EventProducerConfiguration {

	@Bean
	public Exchange eventExchange() {
		return new TopicExchange("eventExchange");
	}

	@Bean
	public PersonService customerService(RabbitTemplate rabbitTemplate, Exchange eventExchange) {
		return new PersonService(rabbitTemplate, eventExchange);
	}

}*/
