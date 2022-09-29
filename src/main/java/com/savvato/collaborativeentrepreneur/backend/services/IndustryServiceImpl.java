package com.savvato.collaborativeentrepreneur.backend.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.savvato.collaborativeentrepreneur.backend.entities.Industry;
import com.savvato.collaborativeentrepreneur.backend.repositories.IndustryRepository;

@Service
public class IndustryServiceImpl implements IndustryService {

	@Autowired
	IndustryRepository industryRepo;
	
	public Industry createNewIndustry(String name) {
		Industry entity = new Industry(name);
		
		return industryRepo.save(entity);
	}
	
	public Iterable<Industry> getAll() {
		return industryRepo.findAll();
	}
	
	public List<Industry> getIndustryForUserId(Long userId) {
		return null; // industryRepo.findByUserId(userId);
	}
	
	public Industry getById(Long id) {
		Optional<Industry> opt = industryRepo.findById(id);
		
		if (opt.isPresent())
			return opt.get();
		else
			return null;
	}
	
	public Industry update(Long id, String name) {
		Optional<Industry> opt = industryRepo.findById(id);
		
		if (opt.isPresent()) {
			
			Industry industry = opt.get();
			
			industry.setName(name);
			
			return industryRepo.save(industry);
		} else {
			return null;
		}
	}
}
