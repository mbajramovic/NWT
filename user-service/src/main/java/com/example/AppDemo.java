package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.rest.RepositoryRestMvcAutoConfiguration;
import org.springframework.context.annotation.Lazy;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.discovery.EurekaClient;


@SpringBootApplication
@RestController
@EnableAutoConfiguration(exclude = RepositoryRestMvcAutoConfiguration.class)
public class AppDemo implements GreetingController {
 
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