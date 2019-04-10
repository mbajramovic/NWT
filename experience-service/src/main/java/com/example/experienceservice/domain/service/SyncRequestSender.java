package com.example.experienceservice.domain.service;

import java.util.HashMap;
import java.util.Map;

import com.example.experienceservice.domain.entity.Person;
import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import com.netflix.discovery.shared.Application;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

@Component
public class SyncRequestSender {
    @Autowired
    private EurekaClient eurekaClient;

    @Value("${eureka.interaction.serviceId}")
    private String interactionServiceId;
    
    public Boolean friendshipExists(Integer userId, Integer followerId)  {
        Application application = eurekaClient.getApplication(interactionServiceId);
        InstanceInfo instanceInfo = application.getInstances().get(0);
        String uri = "http://" + instanceInfo.getIPAddr() + ":" + instanceInfo.getPort() + "/follow/{followerId}/{followingId}";
        Map<String, Integer> params = new HashMap<String, Integer>();
        params.put("followerId", followerId);
        params.put("followingId", userId);
        RestTemplate restTemplate = new RestTemplate();
        Follow result = restTemplate.getForObject(uri, Follow.class, params);

        return result != null;
    }

    private static class Follow {
        public Integer id;
        public Person user;
        public Person followedUser;
    }

    

}

