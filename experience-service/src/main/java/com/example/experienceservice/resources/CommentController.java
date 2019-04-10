package com.example.experienceservice.resources;

import com.example.experienceservice.domain.entity.Comment;
import com.example.experienceservice.domain.service.CommentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
public class CommentController {
    @Autowired
    CommentService commentService;

    @RequestMapping(method = RequestMethod.GET, value = "/comment/{id}") 
    public ResponseEntity getComment(@PathVariable("id") Integer id) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(commentService.getById(id));
        }
        catch(Exception ex) {
           throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Bad request", ex);
        }
    }

    @RequestMapping(method = RequestMethod.POST, value="/comment", consumes = "application/json")
    public ResponseEntity postComment(@RequestBody Comment comment) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(commentService.newComment(comment));
        }
        catch(Exception ex) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, ex.getLocalizedMessage(),ex);
        }
    }

    @RequestMapping(method = RequestMethod.GET, value="experience/{experienceId}/comment")
    public ResponseEntity getAllForExperience(@PathVariable("experienceId") Integer experienceId) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(commentService.gettAllForExperience(experienceId));
        }
        catch(Exception ex) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, ex.getLocalizedMessage(),ex);
        }
    }

    @RequestMapping(method = RequestMethod.GET, value="experience/{experienceId}/commentsNum") 
    public ResponseEntity getCommentsNumberForExperience(@PathVariable("experienceId") Integer experienceId) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(commentService.getCommentsNumberForExperience(experienceId));
        }
        catch(Exception ex) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, ex.getLocalizedMessage(),ex);
        }
    }

    @RequestMapping(method = RequestMethod.DELETE, value="/experience/{experienceId}/comment") 
    public ResponseEntity deleteAll(@PathVariable("experienceId") Integer experienceId) {
        try {
            commentService.deleteAllForExperience(experienceId);
            return ResponseEntity.status(HttpStatus.OK).body("deleted");
        }
        catch(Exception ex) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, ex.getLocalizedMessage(),ex);
        }
    }

    @RequestMapping(method = RequestMethod.DELETE, value="/comment/{id}")
    public ResponseEntity deleteById(@PathVariable("id") Integer id) {
        try {
            commentService.deleteById(id);
            return ResponseEntity.status(HttpStatus.OK).body("deleted");
        }
        catch(Exception ex) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, ex.getLocalizedMessage(),ex);
        }
    }

}