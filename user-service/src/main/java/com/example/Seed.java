package com.example;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import com.example.models.Person;
import com.example.services.PersonService;

@Component
public class Seed implements ApplicationRunner {
    @Autowired
    PersonService personService;
    @Autowired
	private BCryptPasswordEncoder encoder;

    
    public void run(ApplicationArguments args) throws Exception {
        try {
        	
        	List<Person> persons = new ArrayList<Person>();
            persons.add(new Person("Ajla Becic", "abecic1", encoder.encode("admin"), "abecic1@etf.unsa.ba", "ADMIN"));
            persons.add(new Person("Amera Alic", "aalic1", encoder.encode("admin"), "aalic1@etf.unsa.ba", "USER"));
            persons.add(new Person("Maid Bajramovic", "mbajramovi1", encoder.encode("admin"), "mbajramovi1@etf.unsa.ba", "USER"));
            
            persons = (List<Person>) personService.saveAll(persons);

         
        }
        catch(Exception ex) {
            System.out.println(ex.getMessage());
        }
     }
}
