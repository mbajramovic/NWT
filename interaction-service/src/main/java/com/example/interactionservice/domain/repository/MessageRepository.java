package com.example.interactionservice.domain.repository;

import com.example.interactionservice.domain.entity.Message;

import org.springframework.data.repository.CrudRepository;

public interface MessageRepository extends CrudRepository<Message, Integer> {
    
}