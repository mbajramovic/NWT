package com.example.scholarship.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.scholarship.domain.entity.User;
import com.example.scholarship.domain.repository.UserRepository;

@Service
public class UserService {
	@Autowired
    UserRepository userRepository;

    public void newUser(User user) throws Exception{
        try {
            userRepository.save(user);
        }
        catch(Exception ex) {
            throw ex;
        }
    }

    public void deleteAll(){
        userRepository.deleteAll();
    }

    public Iterable<User> getAll() {
        return userRepository.findAll();
    }
}
