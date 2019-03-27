package com.example.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="PERSON")
public class Person {
	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PERSON_SEQ")
    @SequenceGenerator(sequenceName = "person_seq", allocationSize = 1, initialValue=100, name = "PERSON_SEQ")
    private Integer id;
	
	@Column(name = "username")
	private String username;

	@Column(name = "mainId")
	private Integer mainId;
	
	public Person() {}
	
	public Person (String username, Integer mainId) {
		this.username = username;
		this.mainId = mainId;
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

	public Integer getMainId() {
		return mainId;
	}

	public void setMainId(Integer mainId) {
		this.mainId = mainId;
	}
	
	
}
