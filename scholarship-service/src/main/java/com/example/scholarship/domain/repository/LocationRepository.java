package com.example.scholarship.domain.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.scholarship.domain.entity.Location;

@Repository
public interface LocationRepository extends CrudRepository<Location, Integer>{

}
