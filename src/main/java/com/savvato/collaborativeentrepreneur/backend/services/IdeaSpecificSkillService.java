package com.savvato.collaborativeentrepreneur.backend.services;

import java.util.List;

import com.savvato.collaborativeentrepreneur.backend.dto.IdeaSpecificSkillDTO;
import com.savvato.collaborativeentrepreneur.backend.entities.IdeaSpecificSkill;
import com.savvato.collaborativeentrepreneur.backend.entities.Industry;
import com.savvato.collaborativeentrepreneur.backend.entities.Skill;
import com.savvato.collaborativeentrepreneur.backend.entities.SkillLevel;

public interface IdeaSpecificSkillService {

	public IdeaSpecificSkill create(Long ideaId, Skill skill, SkillLevel skillLevel, Industry industry);
	public List<IdeaSpecificSkillDTO> getByIdeaId(Long ideaId);

	public void delete(Long ideaId, Skill skill, SkillLevel skillLevel, Industry industry);
}
