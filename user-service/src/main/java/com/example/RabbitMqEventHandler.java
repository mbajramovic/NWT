package com.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.core.annotation.HandleAfterCreate;
import org.springframework.data.rest.core.annotation.HandleAfterDelete;
import org.springframework.data.rest.core.annotation.HandleAfterSave;
import org.springframework.data.rest.core.annotation.RepositoryEventHandler;
import org.springframework.stereotype.Component;

import com.example.configuration.PersonQueueConfig;
import com.example.models.Person;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
@RepositoryEventHandler
public class RabbitMqEventHandler {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	private RabbitTemplate rabbitTemplate;
	private String personQueue = "persons.queue";
	
	//private Queue userUpdatedQueue;


	@Autowired
	    public RabbitMqEventHandler(RabbitTemplate rabbitTemplate) {
	    		//, Queue userUpdatedQueue) {
	        this.rabbitTemplate = rabbitTemplate;
	        //this.userUpdatedQueue = userUpdatedQueue;
	    }

	@HandleAfterCreate
	public void handleCandidateSave(Person person) {
		sendMessage(person);
	}

	@HandleAfterDelete
	public void handleUserDelete(Integer id) {
		rabbitTemplate.convertAndSend("personsdelete.queue", id);
	}

	private void sendMessage(Person person) {
		
		rabbitTemplate.convertAndSend(personQueue, serializeToJson(person));
		logger.info("Person created", person);
	}
	/*
	@HandleAfterSave
    public void handleAfterSaved(Person person) {
        rabbitTemplate.convertAndSend(
                userUpdatedQueue.getName(), serializeToJson(person));
        logger.info("Person updated", person);
}
	*/
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
