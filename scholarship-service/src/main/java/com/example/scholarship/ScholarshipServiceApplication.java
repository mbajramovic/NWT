package com.example.scholarship;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@EnableFeignClients
@Controller
@EnableDiscoveryClient
@SpringBootApplication
public class ScholarshipServiceApplication {
	
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

}
