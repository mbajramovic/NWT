package com.example.interactionservice.domain.service;

import java.util.List;
import java.util.Optional;

import com.example.interactionservice.domain.entity.Message;
import com.example.interactionservice.domain.repository.MessageRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MessageService {
    @Autowired
    MessageRepository messageRepository;

    public Message newMessage(Message message) {
        return messageRepository.save(message);
    }

    public Iterable<Message> allMessages() {
        return messageRepository.findAll();
    }

    public Optional<Message> getMessage(Integer id) {
        return messageRepository.findById(id);
    } 

    public List<Message> getMessagesForUser(Integer userId) {
        return messageRepository.getMessagesForUser(userId);
    }

    public List<Message> getSentMessages(Integer userId) {
        return messageRepository.getSentMessages(userId);
    }

    public void deleteMessage(Integer id) {
        messageRepository.deleteById(id);
    }
}