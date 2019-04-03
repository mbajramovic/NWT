package com.example.scholarship.domain.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="users")
public class User {
	
	private static final String patternUsername="^[a-z0-9_-]{3,15}$";
	//validan username
	
	public User(String username) {
		
		if(username.matches(patternUsername)) this.username = username;
		
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		if(username.matches(patternUsername)) this.username = username;
	}
	
	@NotNull
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	
	@NotNull
	@Column(name="username")
	private String username;
	
	public User() {
		
	}
}
