package com.example.interactionservice.domain.repository;

import com.example.interactionservice.domain.entity.Follow;

import org.springframework.data.repository.CrudRepository;

public interface FollowRepository extends CrudRepository<Follow, Integer> {
    
}