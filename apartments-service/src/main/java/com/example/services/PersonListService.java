package com.example.services;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.models.Person;
import com.example.repositories.PersonRepository;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class PersonListService {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private PersonRepository _personRepository;

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

            logger.info(String.valueOf(e.getMessage()));

        }

		_personRepository.save(person);
		logger.debug("Candidate {} saved to MongoDB", person.toString());
	}

}
