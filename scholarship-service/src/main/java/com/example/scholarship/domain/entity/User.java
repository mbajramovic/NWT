package com.example.scholarship.domain.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="users")
public class User {
	
	private static final String patternUsername="^[a-z0-9_-]{3,15}$";
	//validan username
	
	

	public Integer getId() {
		return id;
	}

	public User(@NotNull String username, @NotNull String password, @NotNull String email, @NotNull String name) {
		if(username.matches(patternUsername)) this.username = username;
		
		this.password = password;
		this.email = email;
		this.name = name;
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
	
	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "STUDENT_SEQ")
    @SequenceGenerator(sequenceName = "student_seq", allocationSize = 1, initialValue=100, name = "STUDENT_SEQ")
    private Integer id;
	
	
	@NotNull
	@Column(name="username")
	private String username;
	
	@NotNull
	@Column(name="password")
	private String password;
	
	@NotNull
	@Column(name="email")
	private String email;
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@NotNull
	@Column(name="name")
	private String name;
	
	public User() {
		
	}
}
