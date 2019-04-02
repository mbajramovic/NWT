package com.example.experienceservice.domain.service;

import java.util.List;
import java.util.Optional;

import com.example.experienceservice.domain.entity.Experience;
import com.example.experienceservice.domain.repository.ExperienceRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExperienceService {
    @Autowired
    ExperienceRepository experienceRepository;

    public Experience newExperience(Experience experience) throws Exception{
        try {
            return experienceRepository.save(experience);
            
        }
        catch(Exception ex) {
            throw ex;
        }
    }

    public void deleteAll(){
        try {
            experienceRepository.deleteAll();
        }
        catch(Exception ex) {
            throw ex;
        }
    }

    public Iterable<Experience> getAll() {
        return experienceRepository.findAll();
    }

    public List<Experience> getExperiencesForUser(Integer userId) {
        return experienceRepository.getExperiencesForUser(userId);
    }

    public Optional<Experience> getById(Integer id) {
        return experienceRepository.findById(id);
    }

    public void deleteById(Integer id) {
        try {
            experienceRepository.deleteById(id);
        }
        catch(Exception ex) {
            throw ex;
        }
    }

    public void deleteExperiencesForUser(Integer userId) {
        experienceRepository.deleteExperiencesForUser(userId);
    }


    public void updateExperience(Experience experience) {
        try {
            experienceRepository.updateExperience(experience.getText(), experience.getPostDate(), experience.getId());
        }
        catch(Exception ex) {
            throw ex;
        }
    }

    

    

}