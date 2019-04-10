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
public class PublishEventHandler {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
    private RabbitTemplate rabbitTemplate;
    private Queue candidateQueue;

    @Autowired
    public PublishEventHandler(RabbitTemplate rabbitTemplate, Queue candidateQueue) {
        this.rabbitTemplate = rabbitTemplate;
        this.candidateQueue = candidateQueue;
    }

    @HandleAfterCreate
    public void handleCandidateSave(Person candidate) {
        sendMessage(candidate);
    }

    private void sendMessage(Person candidate) {
        rabbitTemplate.convertAndSend(
                candidateQueue.getName(), serializeToJson(candidate));
    }

    private String serializeToJson(Person candidate) {
        ObjectMapper mapper = new ObjectMapper();
        String jsonInString = "";

        try {
            jsonInString = mapper.writeValueAsString(candidate);
        } catch (JsonProcessingException e) {
            logger.info(String.valueOf(e));
        }

        logger.debug("Serialized message payload: {}", jsonInString);

        return jsonInString;
    }

}
