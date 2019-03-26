package com.example.experienceservice.domain.repository;

import com.example.experienceservice.domain.entity.Comment;

import org.springframework.data.repository.CrudRepository;

public interface CommentRepository extends CrudRepository<Comment, Integer> {
    
}