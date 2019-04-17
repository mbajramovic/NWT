package com.example.demo;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertThat;

import java.util.Arrays;

import org.json.JSONObject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.example.scholarship.domain.entity.Scholarship;
import com.example.scholarship.domain.entity.User;
import com.example.scholarship.domain.repository.ScholarshipRepository;
import com.fasterxml.jackson.databind.SerializationFeature;

@RunWith(SpringRunner.class)
public class ScholarshipServiceApplicationTests {
;
/*
	@Test
    public void sincGetAll() throws Exception {
        
		Person user = new Person("Selmaaaa Begic", "selma123", "selma123pasS", "selma123@etf.unsa.ba");
        
		JSONObject js=new JSONObject();
		js.put("username", "selma12345");
		js.put("password", "selma123");
		js.put("email", "selma123@etf.unsa.ba");
		js.put("name", "Selmaaaa Begic");
		
		System.out.println("Dosla u test");
		MappingJackson2HttpMessageConverter jsonHttpMessageConverter = new MappingJackson2HttpMessageConverter();
		jsonHttpMessageConverter.getObjectMapper().configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
		restTemplate.getMessageConverters().add(jsonHttpMessageConverter);
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		System.out.println(js.toString());
        ResponseEntity<Person> p=restTemplate.exchange(
        		  "http://localhost:8060/user/new",
        		  HttpMethod.POST, new HttpEntity<Object>(user, headers), Person.class);
        assertThat(p.getStatusCode().value()==200).isTrue();
        assertThat(p.getBody().getName()).isEqualTo("Selmaaaa Begic");
        		
    }

*/
	  @Test
	  public void testAssertNotSame() {

	    assertNotSame("should not be same Object", new User(), new User());

	  }


}
