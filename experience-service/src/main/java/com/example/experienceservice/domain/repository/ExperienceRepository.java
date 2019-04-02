package com.example.experienceservice.domain.repository;

import java.util.Date;
import java.util.List;

import com.example.experienceservice.domain.entity.Experience;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface ExperienceRepository extends CrudRepository<Experience, Integer> {
    
    @Query
        ("select e from Experience e where e.user.id = :userId")
    public List<Experience> getExperiencesForUser(@Param("userId") Integer userId);

    @Transactional
    @Modifying
    @Query
        ("delete from Experience e where e.user.id = :userId")
    public void deleteExperiencesForUser(@Param("userId") Integer userId);

    @Transactional
    @Modifying
    @Query
        ("update Experience e set e.text = :text, e.postDate = :postDate where e.id = :id")
    public void updateExperience(@Param("text") String text, @Param("postDate") Date postDate, @Param("id") Integer id);
    
    
}