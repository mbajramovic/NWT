package com.example.scholarship;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.rest.RepositoryRestMvcAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.scholarship.domain.entity.Scholarship;
import com.example.scholarship.domain.exception.EntityNotFoundException;
import com.example.scholarship.domain.service.ScholarshipService;
import com.example.scholarship.sinc.GreetingClient;
import com.example.scholarship.sinc.ScholarshipController;
import com.netflix.discovery.EurekaClient;

@EnableFeignClients
@Controller
@EnableDiscoveryClient
@EnableAutoConfiguration(exclude = RepositoryRestMvcAutoConfiguration.class)
@SpringBootApplication
public class ScholarshipServiceApplication implements ScholarshipController{
	
	@Autowired
    private GreetingClient greetingClient;
	
	public static void main(String[] args) {
		SpringApplication.run(ScholarshipServiceApplication.class, args);
	}
	
	
	@RequestMapping("/get-greeting")
    public String greeting(Model model) {
        model.addAttribute("greeting", greetingClient.greeting());
        return "greeting-view";
    }
	
	//da user dohvati stipendije
	public ScholarshipService ss;
	
	@Override
	public String scholarship() throws EntityNotFoundException {
		// TODO Auto-generated method stub
		Iterable<Scholarship> pom=ss.getAll();
		return String.format("Lista stipendija: %s", pom);
	}
/*
	@Override
	public String scholarshipUser() throws EntityNotFoundException {
		System.out.println("Radi 2");
		Iterable<Scholarship> pom=ss.scholarshipsByUser(2);
		System.out.println(String.format("Lista stipendija: %s", pom));
		return String.format("Lista stipendija: %s", pom);
	}	
	*/
}
