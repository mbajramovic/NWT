package com.example.experienceservice.resources;

import com.example.experienceservice.domain.entity.Experience;
import com.example.experienceservice.domain.service.ExperienceService;

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
public class ExperienceController {
    @Autowired
    ExperienceService experienceService;

    @RequestMapping(method = RequestMethod.GET, value = "/experiences")
    public ResponseEntity getAllExperiences() {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(experienceService.getAll());
        }
        catch(Exception ex) {
            System.out.println(ex.getLocalizedMessage());
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, ex.getLocalizedMessage(),ex);
        }
    }

    @RequestMapping(method = RequestMethod.GET, value = "/experience/{id}")
    public ResponseEntity getExperienceById(@PathVariable("id") Integer id) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(experienceService.getById(id));
        }
        catch(Exception ex) {
            System.out.println(ex.getLocalizedMessage());
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, ex.getLocalizedMessage(),ex);
        }
    }

    @RequestMapping(method= RequestMethod.GET, value="/user/{userId}/experience")
    public ResponseEntity getExperiencesForUser(@PathVariable("userId") Integer userId) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(experienceService.getExperiencesForUser(userId));
        }
        catch(Exception ex) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, ex.getLocalizedMessage(),ex);
        }
    }

    @RequestMapping(method = RequestMethod.POST, value = "/experience", consumes = "application/json")
    public ResponseEntity postExperience(@RequestBody Experience experience) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(experienceService.newExperience(experience));
        }
        catch(Exception ex) {
            System.out.println(ex.getLocalizedMessage());
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Bad request", ex);
        }
    }

    @RequestMapping(method = RequestMethod.DELETE, value="/experiences")
    public ResponseEntity deleteExperiences() {
        try {
            experienceService.deleteAll();
            return ResponseEntity.status(HttpStatus.OK).body("deleted");
        }
        catch (Exception ex) {
            System.out.println(ex.getLocalizedMessage());
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, ex.getLocalizedMessage(),ex);
        }
    }

    @RequestMapping(method = RequestMethod.DELETE, value="/experience/{id}")
    public ResponseEntity deleteExperienceById(@PathVariable("id") Integer id) {
        try {
            experienceService.deleteById(id);
            return ResponseEntity.status(HttpStatus.OK).body("deleted");
        }
        catch(Exception ex) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, ex.getLocalizedMessage(),ex);
        }
    }

    @RequestMapping(method = RequestMethod.DELETE, value="/user/{userId}/experience")
    public ResponseEntity deleteExperiencesForUser(@PathVariable("userId") Integer userId) {
        try {
            experienceService.getExperiencesForUser(userId);
            return ResponseEntity.status(HttpStatus.OK).body("deleted");
        }
        catch(Exception ex) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, ex.getLocalizedMessage(),ex);
        }
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/experience")
    public ResponseEntity updateExperience(@RequestBody Experience experience) {
        try {
            experienceService.updateExperience(experience);
            return ResponseEntity.status(HttpStatus.OK).body("updated");
        }
        catch(Exception ex) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, ex.getLocalizedMessage(),ex);
        }
    }
}