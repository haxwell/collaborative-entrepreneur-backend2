package com.savvato.collaborativeentrepreneur.backend.services;

import java.util.List;

import com.savvato.collaborativeentrepreneur.backend.entities.Industry;

public interface IndustryService {
	public Industry getById(Long id);
	
	public Iterable<Industry> getAll();
	
	public Industry createNewIndustry(String name);
	
	public List<Industry> getIndustryForUserId(Long userId);

	public Industry update(Long id, String name);	
}
