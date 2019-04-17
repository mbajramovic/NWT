package com.example.interactionservice.domain.service;

import java.io.IOException;

import com.example.interactionservice.domain.configurations.PersonQueueConfig;
import com.example.interactionservice.domain.entity.Person;
import com.example.interactionservice.domain.repository.PersonRepository;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AsyncMessageListener {
    @Autowired
    private PersonRepository personRepository;

    
    @RabbitListener(queues = "#{personsQueue.name}")
	public void getPersonsMessage(String personMessage) {
		System.out.println(personMessage);
		
		ObjectMapper objectMapper = new ObjectMapper();
        Person person = new Person();

        try {
            objectMapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
            person = objectMapper.readValue(personMessage, Person.class);

        } catch (IOException e) {
    		System.out.println(e.getMessage());
        }
        person.setUserId(person.getId());
        person.setId(null);
		personRepository.save(person);
    }
    
     @RabbitListener(queues = PersonQueueConfig.PERSON_DELETE_QUEUE)
	public void deletePerson(Integer id) {
		try {
            personRepository.deletePersonByUserId(id);
        }
        catch(Exception ex) {
            System.out.println(ex.getLocalizedMessage());
        }
		
	
	}
}
