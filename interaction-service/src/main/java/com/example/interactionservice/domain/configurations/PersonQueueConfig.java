package com.example.interactionservice.domain.configurations;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PersonQueueConfig {

    public static final String PERSON_DELETE_QUEUE = "personsdelete.queue";
    @Bean
    public Queue personsQueue() {
        return new Queue("persons.queue");
    }

      @Bean 
    public Queue personsDeleteQueue() {
        return new Queue(PERSON_DELETE_QUEUE);
    }
}