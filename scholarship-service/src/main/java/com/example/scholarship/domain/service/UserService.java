package com.example.scholarship.domain.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.scholarship.domain.entity.User;
import com.example.scholarship.domain.exception.EntityNotFoundException;
import com.example.scholarship.domain.repository.UserRepository;

@Service
public class UserService {
	@Autowired
    UserRepository userRepository;

    public void newUser(User user) throws EntityNotFoundException {
      userRepository.save(user);
      String routingKey = "customer.created";
      String message = "customer created";
        
   }

    public void deleteAll() throws EntityNotFoundException {
        userRepository.deleteAll();
    }
    
    public void deleteById (Integer id) throws EntityNotFoundException {
    	userRepository.deleteById(id);
    }
    
    public Iterable<User> getAll() throws EntityNotFoundException {
        return userRepository.findAll();
    }
    
    public Optional<User> getById (Integer id) throws EntityNotFoundException {
    	return userRepository.findById(id);
    }
    
    public void update(User newUser, Integer id) throws EntityNotFoundException {
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
