/*package com.example.configuration;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Exchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.services.PersonService;

@Configuration
public class EventConsumerConfiguration {

  @Bean
  public Exchange eventExchange() {
    return new TopicExchange("eventExchange");
  }

  @Bean
  public Queue queue() {
    return new Queue("orderServiceQueue");
  }

  /*@Bean
  public Binding binding(Queue queue, Exchange eventExchange) {
    return BindingBuilder
            .bind(queue)
            .to(eventExchange)
            .with("customer.*");
  }*/

 /* @Bean
  public PersonService eventReceiver() {
    return new PersonService();
  }

}*/
