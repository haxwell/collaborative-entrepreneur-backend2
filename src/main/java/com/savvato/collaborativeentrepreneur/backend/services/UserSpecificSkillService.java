package com.savvato.collaborativeentrepreneur.backend.services;

import java.util.List;

import com.savvato.collaborativeentrepreneur.backend.dto.UserSpecificSkillDTO;
import com.savvato.collaborativeentrepreneur.backend.entities.Industry;
import com.savvato.collaborativeentrepreneur.backend.entities.Skill;
import com.savvato.collaborativeentrepreneur.backend.entities.SkillLevel;
import com.savvato.collaborativeentrepreneur.backend.entities.UserSpecificSkill;

public interface UserSpecificSkillService {

	public UserSpecificSkill create(Long userId, Skill skill, SkillLevel skillLevel, Industry industry);
	public List<UserSpecificSkillDTO> getByUserId(Long userId);

	public void delete(Long userId, Skill skill, SkillLevel skillLevel, Industry industry);
}
