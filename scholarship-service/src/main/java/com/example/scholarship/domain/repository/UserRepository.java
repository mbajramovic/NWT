package com.example.scholarship.domain.repository;
import org.springframework.data.repository.CrudRepository;

import com.example.scholarship.domain.entity.User;

public interface UserRepository extends CrudRepository<User, Integer> {

}
