package com.example.configuration;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.BindingBuilder.GenericArgumentsConfigurer;
import org.springframework.amqp.core.Exchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConsumerConfig {

	@Bean
    public Queue candidateQueue() {
		  System.out.println("ajla consumerconfig");
        return new Queue("candidates.queue");
    }
	
	/*@Bean
	public GenericArgumentsConfigurer binding(Queue queue, Exchange eventExchange) {
		return BindingBuilder.bind(queue).to(eventExchange).with("peroson.*");
	}*/
}
