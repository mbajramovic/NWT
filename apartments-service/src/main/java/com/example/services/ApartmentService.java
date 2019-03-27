package com.example.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.models.Apartment;
import com.example.repositories.ApartmentRepository;

@Service
public class ApartmentService {
	
	@Autowired
	ApartmentRepository apartmentRepository;
	
	public Apartment save(Apartment apartment) {
		return apartmentRepository.save(apartment);
	}
	
	public Iterable<Apartment> saveAll(List<Apartment> apartments) {
		return apartmentRepository.saveAll(apartments);
	}

	public void deleteAll() {
		apartmentRepository.deleteAll();
		
	}
}
