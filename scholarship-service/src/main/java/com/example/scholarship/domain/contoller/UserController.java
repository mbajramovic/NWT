package com.example.scholarship.domain.contoller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.scholarship.domain.entity.Location;
import com.example.scholarship.domain.entity.User;
import com.example.scholarship.domain.exception.EntityNotFoundException;
import com.example.scholarship.domain.service.UserService;

@RestController
@RequestMapping(value = "/user") 
public class UserController {
	
	@Autowired
	UserService userService;
	
	@PostMapping("")
	public void saveUser(@RequestBody User user) {
		try {
			userService.newUser(user);
			//publishEventHandler.handleCandidateSave(person);
		} catch (EntityNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
		}
	
	@GetMapping("/")
	public Iterable<User> allUsers() {
		try {
			return userService.getAll();
		} catch (EntityNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
		}
	
	@GetMapping("")
	public Optional<User> getUser(@RequestParam(value="id") Integer id) {
		try {
			return userService.getById(id);
		} catch (EntityNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
		}
	
	@DeleteMapping("/")
	public void deleteUsers() {
		try {
			userService.deleteAll();
		} catch (EntityNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
		}
	
	@DeleteMapping("")
	public void deleteUser(@RequestParam(value="id") Integer id) {
		try {
			userService.deleteById(id);
		} catch (EntityNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
		}
	
	@PutMapping("/{id}")
	public void replaceUser(@RequestBody User newUser, @PathVariable Integer id) {
		try {
			userService.update(newUser, id);
		} catch (EntityNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
		}
	
}
