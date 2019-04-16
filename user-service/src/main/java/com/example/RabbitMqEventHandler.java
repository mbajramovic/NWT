package com.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.core.annotation.HandleAfterCreate;
import org.springframework.data.rest.core.annotation.RepositoryEventHandler;
import org.springframework.stereotype.Component;

import com.example.models.Person;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
@RepositoryEventHandler
public class RabbitMqEventHandler {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	private RabbitTemplate rabbitTemplate;
	private Queue personQueue;

	@Autowired
	    public RabbitMqEventHandler(RabbitTemplate rabbitTemplate, Queue personQueue) {
	        this.rabbitTemplate = rabbitTemplate;
	        this.personQueue = personQueue;
	    }

	@HandleAfterCreate
	public void handleCandidateSave(Person person) {
		sendMessage(person);
	}

	private void sendMessage(Person person) {
		rabbitTemplate.convertAndSend(personQueue.getName(), serializeToJson(person));

		logger.info("Person created", person);
	}

	private String serializeToJson(Person person) {
		ObjectMapper mapper = new ObjectMapper();
		String jsonInString = "";

		try {
			jsonInString = mapper.writeValueAsString(person);
		} catch (JsonProcessingException e) {
			logger.info(String.valueOf(e));
		}

		logger.debug("Serialized message payload: {}", jsonInString);

		return jsonInString;
	}

}
