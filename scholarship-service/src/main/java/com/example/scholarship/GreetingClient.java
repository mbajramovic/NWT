package com.example.scholarship;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient("spring-cloud-eureka-client-user")
public interface GreetingClient {
    @RequestMapping("/greeting")
    String greeting();
}
