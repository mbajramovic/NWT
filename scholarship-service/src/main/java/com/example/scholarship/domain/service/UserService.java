package com.example.scholarship.domain.service;

import java.util.Optional;

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
    
    public void deleteById (Integer id) {
    	userRepository.deleteById(id);
    }
    
    public Iterable<User> getAll() {
        return userRepository.findAll();
    }
    
    public Optional<User> getById (Integer id) {
    	return userRepository.findById(id);
    }
    
    public void update(User newUser, Integer id) {
    	userRepository.findById(id)
		.map(user -> {
			user.setUsername(newUser.getUsername());
			return userRepository.save(user);
		}).orElseGet(() -> {
			newUser.setId(id);
			return userRepository.save(newUser);
		});
    }
}
