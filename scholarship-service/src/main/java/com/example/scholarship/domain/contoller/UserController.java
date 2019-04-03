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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.scholarship.domain.entity.Location;
import com.example.scholarship.domain.entity.User;
import com.example.scholarship.domain.service.UserService;

@RestController
public class UserController {
	
	@Autowired
	UserService userService;
	
	@PostMapping("/userSave")
	public ResponseEntity saveUser(@RequestBody User user) throws Exception {
		try {
			userService.newUser(user);
			return ResponseEntity.status(HttpStatus.OK).body("Uspješno dodan korisnik");
		}catch(Exception e) {
			 return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getLocalizedMessage());
				}
		}
	
	@GetMapping("/allUsers")
	public ResponseEntity allUsers() {
		try {
			return ResponseEntity.status(HttpStatus.OK).body(userService.getAll());
		}catch(Exception e) {
			 return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getLocalizedMessage());
				}
		}
	
	@GetMapping("/user")
	public ResponseEntity getUser(@RequestParam(value="id") Integer id) {
		try {
			return ResponseEntity.status(HttpStatus.OK).body(userService.getById(id));
		}catch(Exception e) {
			 return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getLocalizedMessage());
				}
		}
	
	@DeleteMapping("/usersDelete")
	public ResponseEntity deleteUsers() {
		try {
			userService.deleteAll();
			return ResponseEntity.status(HttpStatus.OK).body("Uspjesno obrisani korisnici");
		}catch(Exception e) {
			 return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getLocalizedMessage());
				}
		}
	
	@DeleteMapping("/userDelete")
	public ResponseEntity deleteUser(@RequestParam(value="id") Integer id) {
		try {
			userService.deleteById(id);
			return ResponseEntity.status(HttpStatus.OK).body("Uspjesno obrisan korisnik");
		}catch(Exception e) {
			 return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getLocalizedMessage());
				}
		}
	
	@PutMapping("/userUpdate/{id}")
	public ResponseEntity replaceUser(@RequestBody User newUser, @PathVariable Integer id) {
		try {
			userService.update(newUser, id);
			return ResponseEntity.status(HttpStatus.OK).body("Uspjesno azuriran korisnik");
		}catch(Exception e) {
			 return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getStackTrace());
				}
		}
	
}
