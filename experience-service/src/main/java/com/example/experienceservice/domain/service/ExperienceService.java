package com.example.experienceservice.domain.service;

import java.util.List;

import com.example.experienceservice.domain.entity.Experience;
import com.example.experienceservice.domain.repository.ExperienceRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExperienceService {
    @Autowired
    ExperienceRepository experienceRepository;

    public void newExperience(Experience experience) throws Exception{
        try {
            experienceRepository.save(experience);
        }
        catch(Exception ex) {
            throw ex;
        }
    }

    public void deleteAll(){
        experienceRepository.deleteAll();
    }

    public Iterable<Experience> getAll() {
        return experienceRepository.findAll();
    }

    

}