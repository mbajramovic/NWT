package com.example;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.example.models.Apartment;
import com.example.models.Location;
import com.example.models.Person;
import com.example.services.ApartmentService;
import com.example.services.LocationService;
import com.example.services.PersonService;

@Component
public class Seed implements ApplicationRunner {
    @Autowired
    LocationService locationService;
    @Autowired
    PersonService personService;
    @Autowired
    ApartmentService apartmentService;
    
    
    public void run(ApplicationArguments args) throws Exception {
        try {

            List<Location> locations = new ArrayList<Location>();
            locations.add(new Location("Husein kapetana Gradascevica", "Zenica", "BiH"));
            locations.add(new Location("Rechbauerstrasse", "Graz", "Austria"));
            
            locations = (List<Location>) locationService.saveAll(locations);
        	
        	List<Person> persons = new ArrayList<Person>();
            persons.add(new Person("abecic1", 1));
            persons.add(new Person("amera", 1));
            
            persons = (List<Person>) personService.saveAll(persons);
            
        	Integer i = 0;
        	for(Location location : locations){
        		apartmentService.save(new Apartment("Ovo su detalji stana i opis oglasa.", "Oglas za stan " + i.toString(), persons.get(i), location, null)).getId();
        		apartmentService.save(new Apartment("Ovo su detalji stana i opis oglasa.", "Oglas za stan " + i.toString(), persons.get(i), location, "https://media.equityapartments.com/images/c_crop,x_0,y_0,w_1920,h_1080/c_fill,w_1920,h_1080/q_80/4105-6/2201-wilson-apartments-building.jpg")).getId();
        		i += 1;
        	}

         
        }
        catch(Exception ex) {
            System.out.println(ex.getMessage());
        }
     }
}
