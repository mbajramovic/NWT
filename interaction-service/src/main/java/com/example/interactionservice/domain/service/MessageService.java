package com.example.interactionservice.domain.service;

import com.example.interactionservice.domain.entity.Message;
import com.example.interactionservice.domain.repository.MessageRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MessageService {
    @Autowired
    MessageRepository messageRepository;

    public void newMessage(Message message) {
        messageRepository.save(message);
    }

    public Iterable<Message> allMessages() {
        return messageRepository.findAll();
    }
}