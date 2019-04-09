package com.example.experienceservice.domain.service;

import java.util.HashMap;
import java.util.Map;

import com.example.experienceservice.domain.entity.Person;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

@Component
public class SyncRequestSender {


    @Value("${interaction.ip}")
    private String ip;

    @Value("${interaction.port}")
    private String port;


    
    public Boolean friendshipExists(Integer userId, Integer followerId)  {

        String uri = "http://" + ip + ":" + port + "/follow/follow/{followerId}/{followingId}";
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

