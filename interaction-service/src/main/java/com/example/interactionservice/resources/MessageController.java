package com.example.interactionservice.resources;

import com.example.interactionservice.domain.entity.Message;
import com.example.interactionservice.domain.service.MessageService;

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
@RequestMapping(value="/message")
public class MessageController {
    @Autowired
    MessageService messageService;

    @RequestMapping(method=RequestMethod.GET, value="/getMessagesForUser/{userId}")
    public ResponseEntity getAllMessagesForUser(@PathVariable("userId") Integer userId) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(messageService.getMessagesForUser(userId));
        }
        catch(Exception ex) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, ex.getLocalizedMessage(),ex);
        }
    }

    @RequestMapping(method = RequestMethod.GET, value="/{id}")
    public ResponseEntity getMessage(@PathVariable("id")Integer id) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(messageService.getMessage(id));
        }
        catch(Exception ex) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, ex.getLocalizedMessage(),ex);
        }
    }

    @RequestMapping(method = RequestMethod.GET, value="/getSentMessages/{userId}")
    public ResponseEntity getSentMessages(@PathVariable("userId") Integer userId) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(messageService.getSentMessages(userId));
        }
        catch (Exception ex) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, ex.getLocalizedMessage(),ex);
        }
    }

    @RequestMapping(method = RequestMethod.POST, value="/new")
    public ResponseEntity newMessage(@RequestBody Message message) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(messageService.newMessage(message));
        }
        catch (Exception ex) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, ex.getLocalizedMessage(),ex);
        }
    }

    @RequestMapping(method =RequestMethod.DELETE, value="/delete/{id}")
    public ResponseEntity deleteMessage(@PathVariable("id") Integer id) {
        try {
            messageService.deleteMessage(id);
            return ResponseEntity.status(HttpStatus.OK).body("deleted");
        }
        catch(Exception ex) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, ex.getLocalizedMessage(),ex);
        }
    }
}