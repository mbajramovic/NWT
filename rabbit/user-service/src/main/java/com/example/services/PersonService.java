package com.example.services;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.amqp.rabbit.annotation.RabbitListener;

import com.example.models.Person;
import com.example.repositories.PersonRepository;

@Service
public class PersonService {

	@Autowired
	PersonRepository personRepository;
	
	private Logger logger = LoggerFactory.getLogger(PersonService.class);
	
	public Person save(Person person) {
		return personRepository.save(person);
	}
	
	public Iterable<Person> saveAll(List<Person> persons) {
		return personRepository.saveAll(persons);
	}

	public void deleteAll() {
		personRepository.deleteAll();
		
	}

	  @RabbitListener(queues="orderServiceQueue")
	  public void receive(String message) {
	    logger.info("Received message '{}'", message);
	  }
}
