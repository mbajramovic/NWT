package com.example.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="STUDENT")
public class Person {
	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "STUDENT_SEQ")
    @SequenceGenerator(sequenceName = "student_seq", allocationSize = 1, initialValue=100, name = "STUDENT_SEQ")
    private Integer id;
	
	@NotNull
	@Column(name = "username")
	private String username;
	
	@NotNull
	@Column(name = "password")
	private String password;

	@Email
	@Column(name = "email")
	private String email;
	
	@Column(name = "name")
	private String name;
	
	public Person() {}

	public Person(String name, String username, String password, String email) {
		super();
		this.username = username;
		this.password = password;
		this.email = email;
		this.name = name;
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
		this.username = username;
	}

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
	
	
	
}
