package com.example.demo;

import org.json.JSONObject;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.context.WebApplicationContext;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.CoreMatchers.any;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

import com.example.controllers.PersonController;

import com.example.models.Person;
import com.example.services.PersonService;
import com.fasterxml.jackson.databind.SerializationFeature;

@RunWith(SpringRunner.class)
public class AppDemoTest {

	
	private RestTemplate restTemplate=new RestTemplate();
	
	@Before
    public void setup() {
		List<Person> persons = new ArrayList<Person>();
        persons.add(new Person("Ajlaaa Becic", "abecic1", "admin", "abecic1@etf.unsa.ba"));
        persons.add(new Person("Ameraaa Alic", "aalic1", "admin", "aalic1@etf.unsa.ba"));
        persons.add(new Person("Maidddd Bajramovic", "mbajramovi1", "admin", "mbajramovi1@etf.unsa.ba"));
        }
	
   
	
	@Test
    public void postUserReturnsNewUser() throws Exception {
        
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


	  @Test
	  public void testAssertNotSame() {

	    assertNotSame("should not be same Object", new Person(), new Person());

	  }
	  

		@Test
	    public void sincTestGetAll() throws Exception {
			String url="http://localhost:8060/get-scholarships";
			ResponseEntity<String> response
			  = restTemplate.getForEntity(url + "", String.class);
			assertThat(response.getStatusCode(), equalTo(HttpStatus.OK));	
	    }

/*
	    
	    @Test
	    public void givenPerson_whenGetEmployees_thenReturnJsonArray()
	      throws Exception {
	         
	        Person alex = new Person("aalic1", "admin1256AA", "aalic1@etf.unsa.ba", "Amera Alic");
	        service.save(alex);
	        List<Person> allEmployees = service.getAll();
	        System.out.println(allEmployees);
	        mvc.perform(get("/user/")
	          .contentType(MediaType.APPLICATION_JSON))
	          .andExpect(status().isOk())
	          .andExpect(jsonPath("$[0].name", is(alex.getName())));
	    }
	    */
	    /*

	@Test
	public void testUserRead() {
	    String responseBody = "";
	    String output;
	    Boolean result = true;
	    Boolean expResult = true;
	 
	    try {
	        URL url = new URL("localhost:8060/user/100");
	        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
	        conn.setRequestMethod("GET");
	        conn.setRequestProperty("Accept", "application/json");
	 
	        if (conn.getResponseCode() != 200) {
	            // if not 200 response code then fail test
	            result = false;
	        }
	        BufferedReader br = new BufferedReader(new InputStreamReader(
	                (conn.getInputStream())));
	        while ((output = br.readLine()) != null) {
	            responseBody = output;
	        }
	        if (responseBody.length() < 1) {
	            // if response body is empty then fail test
	            result = false;
	        }
	        conn.disconnect();
	    } catch (IOException e) {
	        // if MalformedURLException, ConnectException, etc. then fail test
	        result = false;
	    }
	    assertEquals(expResult, result);
	}
	*/

}
