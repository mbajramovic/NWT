package com.example.experienceservice.domain.repository;

import java.util.List;

import com.example.experienceservice.domain.entity.Experience;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExperienceRepository extends CrudRepository<Experience, Integer> {
    
}