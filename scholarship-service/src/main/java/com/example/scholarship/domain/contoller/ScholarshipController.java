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
import com.example.scholarship.domain.entity.Scholarship;
import com.example.scholarship.domain.exception.ScholarshipNotFoundException;
import com.example.scholarship.domain.service.ScholarshipService;

@RestController
public class ScholarshipController {
	
	@Autowired
	ScholarshipService scholarshipService;
	
	@PostMapping("/scholarshipSave")
	public ResponseEntity saveScholarship(@RequestBody Scholarship scholarship) {
		try {
			scholarshipService.newScholarship(scholarship);
			return ResponseEntity.status(HttpStatus.OK).body("Uspješno dodana stipendija");
		}catch(Exception e) {
			 return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getLocalizedMessage());
				}
		}
	
	@GetMapping("/allScholarships")
	public ResponseEntity allScholarships() {
		try {
			
			return ResponseEntity.status(HttpStatus.OK).body(scholarshipService.getAll());
		}catch(Exception e) {
			 return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getLocalizedMessage());
				}
		}
	
	@GetMapping("/scholarship")
	public Scholarship getScholarship(@RequestParam(value="id") Integer id) {
		return scholarshipService.getById(id)
				.orElseThrow(() -> new ScholarshipNotFoundException(id));
	}
	
	
	@GetMapping("/scholarshipsByUser/{userId}")
	public ResponseEntity scholarshipsByUser(@PathVariable("userId") Integer userId) {
		try {
			
			return ResponseEntity.status(HttpStatus.OK).body(scholarshipService.scholarshipsByUser(userId));
		}catch(Exception e) {
			 return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getLocalizedMessage());
				}
		}
	
	@DeleteMapping("/scholarshipsDelete")
	public ResponseEntity deleteScholarships() {
		try {
			scholarshipService.deleteAll();
			return ResponseEntity.status(HttpStatus.OK).body("Uspješno obrisane stipendije");
		}catch(Exception e) {
			 return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getLocalizedMessage());
				}
		}
	
	@DeleteMapping("/scholarshipDelete")
	public ResponseEntity deleteScholarship(@RequestParam(value="id") Integer id) {
		try {
			scholarshipService.deleteById(id);
			return ResponseEntity.status(HttpStatus.OK).body("Uspješno obrisana stipendija");
		}catch(Exception e) {
			 return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getLocalizedMessage());
				}
		}
	
	@PutMapping("/scholarshipUpdate/{id}")
	public ResponseEntity replaceScholarship(@RequestBody Scholarship scholarship, @PathVariable Integer id) {
		try {
			scholarshipService.update(scholarship, id);
			return ResponseEntity.status(HttpStatus.OK).body("Uspješno azurirana stipendija");
		}catch(Exception e) {
			 return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getLocalizedMessage());
				}
		}
	
}
