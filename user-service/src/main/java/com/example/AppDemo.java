package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.rest.RepositoryRestMvcAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Lazy;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.sinc.GreetingController;
import com.netflix.discovery.EurekaClient;

import com.example.sinc.GreetingController;
import com.example.sinc.ScholarshipComm;

/*import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;*/


@EnableDiscoveryClient
@SpringBootApplication
@EnableAutoConfiguration(exclude = RepositoryRestMvcAutoConfiguration.class)
public class AppDemo implements GreetingController, ScholarshipComm {
 
    @Autowired
    @Lazy
    private EurekaClient eurekaClient;
 
    @Value("${spring.application.name}")
    private String appName;
 
    public static void main(String[] args) {
        SpringApplication.run(AppDemo.class, args);
    }
 
    @Override
    public String greeting() {
    	System.out.println("jnjn");
    	System.out.println(String.format("Hello from '%s'!", eurekaClient.getApplication(appName).getName()));
        return String.format("Hello from '%s'!", eurekaClient.getApplication(appName).getName());
    }

    @RequestMapping("/get-scholarships")
	@Override
	public String scholarship() {
		//model.addAttribute("scholarship", scholarshipComm.scholarship());
		System.out.println(scholarshipComm.scholarship());
    	return "njnjnj";
	}


    @Autowired
    private ScholarshipComm scholarshipComm;
    
   /*
	@RequestMapping("/get-scholarships-user") // {userId}
	@Override
	public String scholarshipUser() { //@PathVariable("userId")Integer id
		System.out.println("Radi 1");
		//System.out.println(id);
		String s=scholarshipComm.scholarshipUser();//id
		return "radi";
		
	}
*/
}
/*
@EnableDiscoveryClient
@SpringBootApplication
public class AppDemo  {

	public static void main(String[] args) {
		SpringApplication.run(AppDemo.class, args);
	}

}

@RestController
class ServiceInstanceRestController {

    @Autowired
    private DiscoveryClient discoveryClient;

    @RequestMapping("/service-instances/{applicationName}")
    public List<ServiceInstance> serviceInstancesByApplicationName(@PathVariable String applicationName) {
        return this.discoveryClient.getInstances(applicationName);
    }
}
*/