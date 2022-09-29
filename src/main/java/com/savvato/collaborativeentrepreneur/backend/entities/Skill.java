package com.savvato.collaborativeentrepreneur.backend.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Skill {

	private static final long serialVersionUID = 305332921L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	///
	private String name;
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}

    /////
	public Skill(String name) {
		this.name = name;
	}
	
	public Skill() {
		
	}
	
	public String toString() {
		return "id: " + id + " / name: " + name;
	}
}
