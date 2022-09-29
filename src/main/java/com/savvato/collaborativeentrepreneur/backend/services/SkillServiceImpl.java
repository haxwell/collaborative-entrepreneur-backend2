package com.savvato.collaborativeentrepreneur.backend.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.savvato.collaborativeentrepreneur.backend.entities.Skill;
import com.savvato.collaborativeentrepreneur.backend.entities.SkillLevel;
import com.savvato.collaborativeentrepreneur.backend.repositories.SkillLevelRepository;
import com.savvato.collaborativeentrepreneur.backend.repositories.SkillRepository;

@Service
public class SkillServiceImpl implements SkillService {

	@Autowired
	SkillRepository skillRepo;
	
	// TODO move SkillLevelRepo access to its own service
	@Autowired
	SkillLevelRepository skillLevelRepo;
	
	public Skill createNewSkill(String name) {
		Skill entity = new Skill(name);
		
		return skillRepo.save(entity);
	}
	
	public Iterable<Skill> getAll() {
		return skillRepo.findAll();
	}
	
	public List<Skill> getSkillsForUserId(Long userId) {
		return skillRepo.findByUserId(userId);
	}
	
	public Skill getById(Long skillId) {
		Optional<Skill> opt = skillRepo.findById(skillId);
		
		if (opt.isPresent())
			return opt.get();
		else
			return null;
	}
	
	public Skill update(Long skillId, String name) {
		Optional<Skill> opt = skillRepo.findById(skillId);
		
		if (opt.isPresent()) {
			
			Skill skill = opt.get();
			
			skill.setName(name);
			
			return skillRepo.save(skill);
		} else {
			return null;
		}
	}
	
	public Iterable<SkillLevel> getLevels() {
		return skillLevelRepo.findAll();
	}

	public SkillLevel getByLevelId(Long id) {
		Optional<SkillLevel> opt = skillLevelRepo.findById(id);
		
		if (opt.isEmpty())
			return null;
		
		return opt.get();
	}
}
