package com.example.interactionservice.domain.repository;

import java.util.List;

import com.example.interactionservice.domain.entity.Message;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface MessageRepository extends CrudRepository<Message, Integer> {
    
    @Query
        ("select m from Message m where m.recipient.id = :userId")
    public List<Message> getMessagesForUser(@Param("userId") Integer userId);

    @Query
        ("select m from Message m where m.sender.id = :userId")
    public List<Message> getSentMessages(@Param("userId") Integer userId);
}