package com.example.user;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import static org.assertj.core.api.Assertions.assertThat;
import com.example.models.Person;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class UserControllerTest {
	@Autowired
	private TestRestTemplate restTemplate;
	
	@Test
    public void postUserReturnsNewUser() throws Exception {
        Person user = new Person(
        		
        		"selma123",
        		"selma123pasS",
        	    
        	    "selma123@etf.unsa.ba",
        	    "Selmaaaa Begic"
        	    
        );
        System.out.println("Dosla u test");
        ResponseEntity<Person> responseEntity =
                restTemplate.postForEntity("/user/new", user, Person.class);
        assertThat(responseEntity.getStatusCode().value() == 103).isTrue();
        assertThat(responseEntity.getBody().toString()).isEqualTo("{\r\n" + 
        		"    \"id\": 103,\r\n" + 
        		"    \"username\": \"selma123\",\r\n" + 
        		"    \"password\": \"selma123\",\r\n" + 
        		"    \"email\": \"selma123@etf.unsa.ba\",\r\n" + 
        		"    \"name\": \"Selmaaaa Begic\"\r\n" + 
        		"}");
    }



}
