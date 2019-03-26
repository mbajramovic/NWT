package com.example.interactionservice.domain.service;

import com.example.interactionservice.domain.entity.Follow;
import com.example.interactionservice.domain.repository.FollowRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FollowService {
    @Autowired
    FollowRepository followRepository;
        
    public void newFollowAction(Follow follow) {
        followRepository.save(follow);
    }

    public Iterable<Follow> getAllFollowDetails() {
        return followRepository.findAll();
    }
}