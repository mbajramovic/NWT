package com.example.scholarship.domain.contoller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
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
import com.example.scholarship.domain.exception.EntityNotFoundException;
import com.example.scholarship.domain.exception.RestExceptionHandler;
import com.example.scholarship.domain.exception.ScholarshipNotFoundException;
import com.example.scholarship.domain.service.ScholarshipService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = "/scholarship") 
public class ScholarshipController {
	
	@Autowired
	ScholarshipService scholarshipService;

	@CrossOrigin(origins = "*")
	@PostMapping("")
	public Scholarship saveScholarship(@RequestBody Scholarship scholarship) {
		try {
				return scholarshipService.newScholarship(scholarship);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		return null;
	}

	@CrossOrigin(origins = "*")
	@GetMapping("")
	public Iterable<Scholarship> allScholarships() {
		try {
			return scholarshipService.getAll();
		} catch (EntityNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
		}

	@CrossOrigin(origins = "*")
	@GetMapping("/")
	public Optional<Scholarship> getScholarship(@RequestParam(value="id") Integer id) {
		try {
			return scholarshipService.getById(id);
		} catch (EntityNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
				
	}
	

	@CrossOrigin(origins = "*")
	@GetMapping("/user/{userId}")
	public Iterable<Scholarship> scholarshipsByUser(@PathVariable("userId") Integer userId) {
		try {
			return scholarshipService.scholarshipsByUser(userId);
		} catch (EntityNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
		}

	@CrossOrigin(origins = "*")
	@DeleteMapping("")
	public void deleteScholarships() {
		try {
			 scholarshipService.deleteAll();
			 //return ResponseEntity.status(HttpStatus.OK).body("Uspješno obrisane stipendije");
		}catch(EntityNotFoundException e) {
			 //return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getLocalizedMessage());
		e.printStackTrace();		
		}
		
		}

	@CrossOrigin(origins = "*")
	@DeleteMapping("/")
	public void deleteScholarship(@RequestParam(value="id") Integer id) {
		try {
			scholarshipService.deleteById(id);
			//return ResponseEntity.status(HttpStatus.OK).body("Uspješno obrisana stipendija");
		}catch(EntityNotFoundException e) {
			 //return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getLocalizedMessage());
				}
		}

	@CrossOrigin(origins = "*")
	@PutMapping("/{id}")
	public void replaceScholarship(@RequestBody Scholarship scholarship, @PathVariable Integer id) {
		try {
			scholarshipService.update(scholarship, id);
		} catch (EntityNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
		
		}
	
}
