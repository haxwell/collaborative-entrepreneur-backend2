package com.savvato.collaborativeentrepreneur.backend.services;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.savvato.collaborativeentrepreneur.backend.dto.IdeaSpecificSkillDTO;
import com.savvato.collaborativeentrepreneur.backend.entities.IdeaSpecificSkill;
import com.savvato.collaborativeentrepreneur.backend.entities.Industry;
import com.savvato.collaborativeentrepreneur.backend.entities.Skill;
import com.savvato.collaborativeentrepreneur.backend.entities.SkillLevel;
import com.savvato.collaborativeentrepreneur.backend.repositories.IdeaSpecificSkillRepository;

@Service
public class IdeaSpecificSkillServiceImpl implements IdeaSpecificSkillService {

	@Autowired
	IdeaSpecificSkillRepository issRepository;
	
	@Autowired
	IdeaService ideaService;
	
	@Autowired
	SkillService skillService;
	
	@Autowired
	IndustryService industryService;
	
	public IdeaSpecificSkill create(Long ideaId, Skill skill, SkillLevel skillLevel, Industry industry) {
		
		Long skillId;
		Long skillLevelId;
		Long industryId;
		
		if (skill.getId() == -1)
			throw new IllegalArgumentException("Must define a skill for an idea's specific skill mapping.");
		else
			skillId = skill.getId();
		
		if (skillLevel.getId() == -1)
			skillLevelId = null;
		else
			skillLevelId = skillLevel.getId();
		
		if (industry.getId() == -1)
			industryId = null;
		else
			industryId = industry.getId();
		
		IdeaSpecificSkill iss = new IdeaSpecificSkill(ideaId, skillId, skillLevelId, industryId);
		
		return this.issRepository.save(iss);
	}
	
	public void delete(Long ideaId, Skill skill, SkillLevel skillLevel, Industry industry) {
		
		// TODO WILO, pass in the objects instead, and have the constructor look for IDs, and handle nulls
		IdeaSpecificSkill iss = new IdeaSpecificSkill(ideaId, skill.getId(), skillLevel.getId(), industry.getId());
		
		this.issRepository.delete(iss);
	}
	
	public List<IdeaSpecificSkillDTO> getByIdeaId(Long ideaId) {
		Iterable<IdeaSpecificSkill> iterable = this.issRepository.findByIdeaId(ideaId);
		Iterator<IdeaSpecificSkill> iterator = iterable.iterator();

		List<IdeaSpecificSkillDTO> rtn = new ArrayList<>();
		
		while (iterator.hasNext()) {
			IdeaSpecificSkill iss = iterator.next();
			
			IdeaSpecificSkillDTO dto = new IdeaSpecificSkillDTO();
			
			dto.idea = ideaService.getById(iss.getIdeaId());
			dto.skill = skillService.getById(iss.getSkillId());

			if (iss.getSkillLevelId() != null)
				dto.skillLevel = skillService.getByLevelId(iss.getSkillLevelId());

			if (iss.getIndustryId() != null)
				dto.industry = industryService.getById(iss.getIndustryId());

			rtn.add(dto);
		}
		
		return rtn;
	}
}
