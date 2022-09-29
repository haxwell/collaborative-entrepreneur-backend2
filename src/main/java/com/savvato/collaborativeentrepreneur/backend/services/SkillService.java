package com.savvato.collaborativeentrepreneur.backend.services;

import java.util.List;

import com.savvato.collaborativeentrepreneur.backend.entities.Skill;
import com.savvato.collaborativeentrepreneur.backend.entities.SkillLevel;

public interface SkillService {
	public Iterable<Skill> getAll();
	
	public Skill getById(Long id);
	
	public Skill createNewSkill(String name);
	
	public List<Skill> getSkillsForUserId(Long userId);

	public Skill update(Long id, String name);	

	public Iterable<SkillLevel> getLevels();
	
	public SkillLevel getByLevelId(Long id);
}
