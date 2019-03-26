package com.example.experienceservice.domain.service;

import com.example.experienceservice.domain.entity.Comment;
import com.example.experienceservice.domain.repository.CommentRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentService {
    @Autowired
    CommentRepository commentRepository;

    public void newComment(Comment comment) {
        commentRepository.save(comment);
    }

    public void deleteAll() {
        commentRepository.deleteAll();
    }

    public Iterable<Comment> getAll() {
        return commentRepository.findAll();
    }
}