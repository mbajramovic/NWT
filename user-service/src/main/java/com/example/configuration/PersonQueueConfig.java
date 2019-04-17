package com.example.configuration;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.listener.RabbitListenerEndpointRegistrar;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.converter.MappingJackson2MessageConverter;
import org.springframework.messaging.handler.annotation.support.DefaultMessageHandlerMethodFactory;

@Configuration
@EnableRabbit
public class PersonQueueConfig {

	@Bean
	public Queue candidateQueue() {
		return new Queue("persons.queue");
    }
    
    @Bean 
    public Queue personsDeleteQueue() {
        return new Queue("personsdelete.queue");
    }
   

    
/*
    @Bean
    public Queue userUpdatedQueue() {
        return new Queue("user_updated_queue");
    }
*/
}
