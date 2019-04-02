package com.example.experienceservice.domain.repository;

import java.util.List;

import com.example.experienceservice.domain.entity.Comment;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface CommentRepository extends CrudRepository<Comment, Integer> {
    
    @Query
        ("select c from Comment c where c.experience.id = :experienceId")
    public Iterable<Comment> getAllForExperience(@Param("experienceId") Integer experienceId);

    @Query
        ("select count(c) from Comment c where c.experience.id = :experienceId")
    public List<String> getCommentsNumberForExperience(@Param("experienceId") Integer experienceId);
    
    @Transactional
    @Modifying
    @Query
        ("delete from Comment c where c.experience.id = :experienceId")
    public void deleteCommentsForExperience(@Param("experienceId") Integer experienceId);

}