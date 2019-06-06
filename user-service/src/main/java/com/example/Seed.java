package com.example;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.example.models.Person;
import com.example.services.PersonService;

@Component
public class Seed implements ApplicationRunner {
    @Autowired
    PersonService personService;
    PasswordEncoder passwordEncoder;
    
    public void run(ApplicationArguments args) throws Exception {
        try {
        	
        	List<Person> persons = new ArrayList<Person>();
            persons.add(new Person("Ajla Becic", "abecic1", "admin", "abecic1@etf.unsa.ba"));
            persons.add(new Person("Amera Alic", "aalic1", "admin", "aalic1@etf.unsa.ba"));
            persons.add(new Person("Maid Bajramovic", "mbajramovi1", "admin", "mbajramovi1@etf.unsa.ba"));
            
            persons = (List<Person>) personService.saveAll(persons);
            
         
        }
        catch(Exception ex) {
            System.out.println(ex.getMessage());
        }
     }
}
