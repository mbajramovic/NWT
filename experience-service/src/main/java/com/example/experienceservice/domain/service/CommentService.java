package com.example.experienceservice.domain.service;

import java.util.List;
import java.util.Optional;

import com.example.experienceservice.domain.entity.Comment;
import com.example.experienceservice.domain.repository.CommentRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

@Service
public class CommentService {
    @Autowired
    CommentRepository commentRepository;
    
    @Autowired
    SyncRequestSender syncRequestSender;

    public Comment newComment(Comment comment) throws Exception {
        try {
           /* if (syncRequestSender.friendshipExists(comment.getExperience().getUser().getUserId(), comment.getUser().getUserId()))
                return commentRepository.save(comment);
            else {
                return commentRepository.save(comment);

               // throw new Exception("You must follow the user to comment his experiences.");
            }*/
           return  commentRepository.save(comment);
        }
        catch(Exception ex) {
            throw ex;
        }
    }

    public void deleteAllForExperience(Integer experienceId) {
        commentRepository.deleteCommentsForExperience(experienceId);
    }

    public void deleteById(Integer id) {
        try {   
            commentRepository.deleteById(id);
        }
        catch(Exception ex) {
            throw ex;
        }
    }

    public Iterable<Comment> getAll() {
        return commentRepository.findAll();
    }

    public Optional<Comment> getById(Integer id) {
        return commentRepository.findById(id);
    }

    public Iterable<Comment> gettAllForExperience(Integer experienceId) {
        return commentRepository.getAllForExperience(experienceId);
    }

    public List<String> getCommentsNumberForExperience(Integer experienceId) {
        return commentRepository.getCommentsNumberForExperience(experienceId);
    }
}