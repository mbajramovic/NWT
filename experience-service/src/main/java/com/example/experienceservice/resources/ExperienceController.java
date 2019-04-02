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

@RestController
@RequestMapping(path="/experience")
public class ExperienceController {
    @Autowired
    ExperienceService experienceService;

    @RequestMapping(method = RequestMethod.GET, value = "/allExperiences")
    public ResponseEntity getAllExperiences() {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(experienceService.getAll());
        }
        catch(Exception ex) {
            System.out.println(ex.getLocalizedMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getLocalizedMessage());
        }
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    public ResponseEntity getExperienceById(@PathVariable("id") Integer id) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(experienceService.getById(id));
        }
        catch(Exception ex) {
            System.out.println(ex.getLocalizedMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getLocalizedMessage()); 
        }
    }

    @RequestMapping(method= RequestMethod.GET, value="/getAllForUser/{userId}")
    public ResponseEntity getExperiencesForUser(@PathVariable("userId") Integer userId) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(experienceService.getExperiencesForUser(userId));
        }
        catch(Exception ex) {
            return ResponseEntity.status(HttpStatus.OK).body(ex.getLocalizedMessage());
        }
    }

    @RequestMapping(method = RequestMethod.POST, value = "/new", consumes = "application/json")
    public ResponseEntity postExperience(@RequestBody Experience experience) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(experienceService.newExperience(experience));
        }
        catch(Exception ex) {
            System.out.println(ex.getLocalizedMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getLocalizedMessage());
        }
    }

    @RequestMapping(method = RequestMethod.DELETE, value="/deleteAll")
    public ResponseEntity deleteExperiences() {
        try {
            experienceService.deleteAll();
            return ResponseEntity.status(HttpStatus.OK).body("deleted");
        }
        catch (Exception ex) {
            System.out.println(ex.getLocalizedMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getLocalizedMessage());
        }
    }

    @RequestMapping(method = RequestMethod.DELETE, value="/delete/{id}")
    public ResponseEntity deleteExperienceById(@PathVariable("id") Integer id) {
        try {
            experienceService.deleteById(id);
            return ResponseEntity.status(HttpStatus.OK).body("deleted");
        }
        catch(Exception ex) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getLocalizedMessage());
        }
    }

    @RequestMapping(method = RequestMethod.DELETE, value="/deleteExperiencesForUser/{userId}")
    public ResponseEntity deleteExperiencesForUser(@PathVariable("userId") Integer userId) {
        try {
            experienceService.getExperiencesForUser(userId);
            return ResponseEntity.status(HttpStatus.OK).body("deleted");
        }
        catch(Exception ex) {
            return ResponseEntity.status(HttpStatus.OK).body(ex.getLocalizedMessage());
        }
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/update")
    public ResponseEntity updateExperience(@RequestBody Experience experience) {
        try {
            experienceService.updateExperience(experience);
            return ResponseEntity.status(HttpStatus.OK).body("updated");
        }
        catch(Exception ex) {
            return ResponseEntity.status(HttpStatus.OK).body(ex.getLocalizedMessage());
        }
    }
}