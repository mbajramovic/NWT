package com.example.scholarship.domain.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.management.Query;
import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.scholarship.domain.entity.Location;
import com.example.scholarship.domain.entity.Scholarship;
import com.example.scholarship.domain.entity.User;
import com.example.scholarship.domain.exception.EntityNotFoundException;
import com.example.scholarship.domain.repository.LocationRepository;
import com.example.scholarship.domain.repository.ScholarshipRepository;
import com.example.scholarship.domain.repository.UserRepository;


@Service
public class ScholarshipService {
	@Autowired
	private EntityManager entityManager;

	@Autowired
	ScholarshipRepository scholarshipRepository;
	@Autowired
	LocationRepository locationRepository;
	@Autowired
	UserRepository userRepository;
		
	public Scholarship newScholarship(Scholarship scholarship) throws EntityNotFoundException {
		 return scholarshipRepository.save(scholarship);
	}
	
	public void newScholarship() throws EntityNotFoundException{
		Scholarship scholarship=new Scholarship();
		scholarship.setDate("29/3/2019");
		scholarship.setLink("www.stipendija4.at");
		
		Location location=new Location();
		location.setCity("Sarajevo");
		location.setCountry("BiH");
		location.setUniversity("Masinski fakultet");
		locationRepository.save(location);
		
		scholarship.setLocation(location);
		scholarship.setText("Tekst vezan za stipendiju 4");
		User user=new User();
		user.setUsername("username33");
		userRepository.save(user);
		
		scholarship.setUser(user);
		scholarshipRepository.save(scholarship);
	}
	
	public void update(Scholarship newscholarship, Integer id) throws EntityNotFoundException {
		scholarshipRepository.findById(id)
		.map(scholarship -> {
			scholarship.setDate(newscholarship.getDate());
			scholarship.setLink(newscholarship.getLink());
			scholarship.setLocation(newscholarship.getLocation());
			scholarship.setText(newscholarship.getText());
			scholarship.setUser(newscholarship.getUser());
			return scholarshipRepository.save(scholarship);
		}).orElseGet(() -> {
			newscholarship.setId(id);
			return scholarshipRepository.save(newscholarship);
		});
	}
	
	public void deleteAll() throws EntityNotFoundException {
		scholarshipRepository.deleteAll();
	}
	
	public Iterable<Scholarship> getAll() throws EntityNotFoundException {
		return scholarshipRepository.findAll();
	}
	public Optional<Scholarship> getById(Integer id) throws EntityNotFoundException {
		return scholarshipRepository.findById(id);
		
		 
    }
	
    public Iterable<Scholarship> scholarshipsByUser(Integer id) throws EntityNotFoundException{
    	return scholarshipRepository.getScholarshipsByUser(id);
    }
     
	public void deleteById (Integer id) throws EntityNotFoundException {
		scholarshipRepository.deleteById(id);
	}
	
}
