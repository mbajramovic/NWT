package com.example.scholarship.domain.repository;



import com.example.scholarship.domain.entity.Scholarship;

import org.springframework.data.repository.query.Param;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;


public interface ScholarshipRepository extends CrudRepository <Scholarship, Integer> {
	
	@Query
    	("select s from Scholarship s where s.user.id = :userId")
	public Iterable<Scholarship> getScholarshipsByUser(@Param("userId") Integer userId);
	

}

