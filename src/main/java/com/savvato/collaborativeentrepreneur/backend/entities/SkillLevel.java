package com.savvato.collaborativeentrepreneur.backend.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class SkillLevel {

	private static final long serialVersionUID = 12432920L;
	
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
	private Integer level;

	public Integer getLevel() {
		return level;
	}

	public void setLevel(Integer level) {
		this.level = level;
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
	public SkillLevel(Integer level, String name) {
		this.level = level;
		this.name = name;
	}
	
	public SkillLevel() {
		
	}
	
	public String toString() {
		return "id : " + id + " / name: " + name + " / level: " + level;
	}
}
