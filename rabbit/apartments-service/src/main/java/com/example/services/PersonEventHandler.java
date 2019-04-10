/*package com.example.services;


import com.example.models.Person;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.core.annotation.HandleAfterCreate;
import org.springframework.data.rest.core.annotation.RepositoryEventHandler;
import org.springframework.stereotype.Component;

@Component

@RepositoryEventHandler
public class PersonEventHandler {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	    private RabbitTemplate rabbitTemplate;

	    private Queue candidateCreatedQueue;



	    @Autowired

	    public PersonEventHandler(RabbitTemplate rabbitTemplate, Queue userQueue) {

	        this.rabbitTemplate = rabbitTemplate;

	        this.candidateCreatedQueue = userQueue;

	    }


	    @HandleAfterCreate

	    public void handleUserSave(Person user) {

	        sendMessage(user);

	    }



	    private void sendMessage(Person user) {

	        rabbitTemplate.convertAndSend(

	                candidateCreatedQueue.getName(), "je li moze?");//serializeToJson(user));

	    }



	    private String serializeToJson(Person user) {

	        ObjectMapper mapper = new ObjectMapper();

	        String jsonInString = "";



	        try {

	            jsonInString = mapper.writeValueAsString(user);

	        } catch (JsonProcessingException e) {

	            logger.info(String.valueOf(e));

	        }


	        logger.debug("Serialized message payload: {}", jsonInString);



	        return jsonInString;

	    }
}*/
