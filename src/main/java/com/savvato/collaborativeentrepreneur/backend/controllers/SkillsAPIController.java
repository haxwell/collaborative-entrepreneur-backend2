package com.savvato.collaborativeentrepreneur.backend.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.savvato.collaborativeentrepreneur.backend.controllers.dto.SkillRequest;
import com.savvato.collaborativeentrepreneur.backend.entities.Skill;
import com.savvato.collaborativeentrepreneur.backend.entities.SkillLevel;
import com.savvato.collaborativeentrepreneur.backend.services.SkillService;

@RestController
public class SkillsAPIController {

	@Autowired
	SkillService skillService;
	
	SkillsAPIController() {
			
	}
	
	@RequestMapping(value = { "/api/skill/create" }, method=RequestMethod.POST)
	public ResponseEntity<Skill> createSkill(@RequestBody @Valid SkillRequest request) {

		Skill skill = skillService.createNewSkill(request.name);

		if (skill == null) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
		} else {
			return ResponseEntity.status(HttpStatus.OK).body(skill);
		}
	}
	
	@RequestMapping(value = { "/api/skill/all" }, method=RequestMethod.GET)
	public ResponseEntity<Iterable<Skill>> getAll() {
		
		Iterable<Skill> iterable = skillService.getAll();
		
		return ResponseEntity.status(HttpStatus.OK).body(iterable);
	}
	
	@RequestMapping(value = { "/api/user/{userId}/skills" }, method=RequestMethod.GET)
	public ResponseEntity<List<Skill>> getAllByUserId(@PathVariable Long userId) {
		
		List<Skill> list = skillService.getSkillsForUserId(userId);
		
		return ResponseEntity.status(HttpStatus.OK).body(list);
	}
	
	@RequestMapping(value = { "/api/skill/{skillId}" }, method=RequestMethod.GET)
	public ResponseEntity<Skill> getById(@PathVariable Long skillId) {
		
		Skill skill = skillService.getById(skillId);
		
		return ResponseEntity.status(HttpStatus.OK).body(skill);
	}
	
	@RequestMapping(value = { "/api/skill/levels" }, method=RequestMethod.GET)
	public ResponseEntity<Iterable<SkillLevel>> getSkillLevels() {
		
		Iterable<SkillLevel> iter = skillService.getLevels();
		
		return ResponseEntity.status(HttpStatus.OK).body(iter);
	}
	
	@RequestMapping(value = { "/api/skill/{skillId}" }, method=RequestMethod.PUT)
	public ResponseEntity<Skill> update(@RequestBody @Valid SkillRequest request) {
		Skill skill = skillService.update(request.id, request.name);
		
		if (skill == null) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
		} else {
			return ResponseEntity.status(HttpStatus.OK).body(skill);
		}
	}
	
}