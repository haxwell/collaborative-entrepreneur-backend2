package com.savvato.collaborativeentrepreneur.backend.services;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.savvato.collaborativeentrepreneur.backend.dto.UserSpecificSkillDTO;
import com.savvato.collaborativeentrepreneur.backend.entities.Industry;
import com.savvato.collaborativeentrepreneur.backend.entities.Skill;
import com.savvato.collaborativeentrepreneur.backend.entities.SkillLevel;
import com.savvato.collaborativeentrepreneur.backend.entities.UserSpecificSkill;
import com.savvato.collaborativeentrepreneur.backend.repositories.UserSpecificSkillRepository;

@Service
public class UserSpecificSkillServiceImpl implements UserSpecificSkillService {

	@Autowired
	UserSpecificSkillRepository ussRepository;
	
	@Autowired
	UserService userService;
	
	@Autowired
	SkillService skillService;
	
	@Autowired
	IndustryService industryService;

	public UserSpecificSkill create(Long userId, Skill skill, SkillLevel skillLevel, Industry industry) {
		
		UserSpecificSkill uss = new UserSpecificSkill(userId, skill.getId(), skillLevel.getId(), industry.getId());
		
		return this.ussRepository.save(uss);
	}
	
	public void delete(Long userId, Skill skill, SkillLevel skillLevel, Industry industry) {
		
		UserSpecificSkill iss = new UserSpecificSkill(userId, skill.getId(), skillLevel.getId(), industry.getId());
		
		this.ussRepository.delete(iss);
	}
	
	public List<UserSpecificSkillDTO> getByUserId(Long userId) {
		Iterable<UserSpecificSkill> iterable = this.ussRepository.findByUserId(userId);
		Iterator<UserSpecificSkill> iterator = iterable.iterator();

		List<UserSpecificSkillDTO> rtn = new ArrayList<>();
		
		while (iterator.hasNext()) {
			UserSpecificSkill iss = iterator.next();
			
			UserSpecificSkillDTO dto = new UserSpecificSkillDTO();
			
			dto.user = userService.findById(iss.getUserId());
			dto.skill = skillService.getById(iss.getSkillId());
			dto.skillLevel = skillService.getByLevelId(iss.getSkillLevelId());
			dto.industry = industryService.getById(iss.getIndustryId());
			
			rtn.add(dto);
		}
		
		return rtn;
	}
	
}
