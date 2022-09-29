package com.savvato.collaborativeentrepreneur.backend.dto;

import com.savvato.collaborativeentrepreneur.backend.entities.Industry;
import com.savvato.collaborativeentrepreneur.backend.entities.Skill;
import com.savvato.collaborativeentrepreneur.backend.entities.SkillLevel;

public class SpecificSkillRequest {

	public Skill skill;
	public Industry industry;
	public SkillLevel skillLevel;

}