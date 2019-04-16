package com.example.models;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Table(name="PERSON")
public class Person {
	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PERSON_SEQ")
    @SequenceGenerator(sequenceName = "person_seq", allocationSize = 1, initialValue=100, name = "PERSON_SEQ")
    private Integer id;
	
	@Column(name = "username")
	private String username;
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Column(name = "password")
	private String password;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name="parent_id")
	//@OnDelete(action = OnDeleteAction.CASCADE)
	private Set<Apartment> apartments = new HashSet<Apartment>();
	
	public Person() {}
	
	public Person (String username, Integer mainId) {
		this.username = username;
		this.id = 0;
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
	
	
}
