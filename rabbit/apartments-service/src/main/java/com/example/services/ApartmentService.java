package com.example.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.models.Apartment;
import com.example.repositories.ApartmentRepository;


/** Klasa predstavlja Service. Za realizaciju potrebnih funkcionalnosti koristi ApartmentRepository.
 * @author Becic Ajla
*/

@Service
public class ApartmentService {
	
	@Autowired
	ApartmentRepository apartmentRepository;
	
	public Iterable<Apartment> getAll() {
		return apartmentRepository.findAll();
	}
	
	public Optional<Apartment> getById(Integer id) {
        return apartmentRepository.findById(id);
    }
	
	public Apartment save(Apartment apartment) {
		return apartmentRepository.save(apartment);
	}
	
	public Iterable<Apartment> saveAll(List<Apartment> apartments) {
		return apartmentRepository.saveAll(apartments);
	}

	public void deleteAll() {
		apartmentRepository.deleteAll();		
	}
	
	public void deleteById(Integer id) {
		apartmentRepository.deleteById(id);
	}
	
	public List<Apartment> getAllByLocation(Integer id) {
		return apartmentRepository.findByLocation(id);
	}
}
