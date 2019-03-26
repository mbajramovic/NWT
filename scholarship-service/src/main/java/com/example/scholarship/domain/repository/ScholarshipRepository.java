package com.example.scholarship.domain.repository;



import com.example.scholarship.domain.entity.Scholarship;

import org.springframework.data.repository.CrudRepository;


public interface ScholarshipRepository extends CrudRepository <Scholarship, Integer> {

}

