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

import com.savvato.collaborativeentrepreneur.backend.dto.IdeaSpecificSkillDTO;
import com.savvato.collaborativeentrepreneur.backend.dto.SpecificSkillRequest;
import com.savvato.collaborativeentrepreneur.backend.entities.IdeaSpecificSkill;
import com.savvato.collaborativeentrepreneur.backend.services.IdeaService;
import com.savvato.collaborativeentrepreneur.backend.services.IdeaSpecificSkillService;

@RestController
public class IdeaSpecificSkillAPIController {

	@Autowired
	IdeaService ideaService;
	
	@Autowired
	IdeaSpecificSkillService ideaSpecificSkillService;
	
	IdeaSpecificSkillAPIController() {
		
	}
	
	@RequestMapping(value = { "/api/idea/{ideaId}/specific-skill/new" }, method=RequestMethod.POST)
	public ResponseEntity<IdeaSpecificSkill> createIdeaSpecificSkill(@PathVariable Long ideaId, @RequestBody @Valid SpecificSkillRequest req) {

		IdeaSpecificSkill iss = ideaSpecificSkillService.create(ideaId, req.skill, req.skillLevel, req.industry);
		
		if (iss == null) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
		} else {
			return ResponseEntity.status(HttpStatus.OK).body(iss);
		}
	}
	
	@RequestMapping(value = { "/api/idea/{ideaId}/specific-skills" }, method=RequestMethod.GET)
	public ResponseEntity<List<IdeaSpecificSkillDTO>> getByIdeaId(@PathVariable Long ideaId) {
		return ResponseEntity.status(HttpStatus.OK).body(ideaSpecificSkillService.getByIdeaId(ideaId));
	}
	
	@RequestMapping(value = { "/api/idea/{ideaId}/specific-skills" }, method=RequestMethod.DELETE)
	public ResponseEntity getByIdeaId(@PathVariable Long ideaId, @RequestBody @Valid SpecificSkillRequest req) {
		ideaSpecificSkillService.delete(ideaId, req.skill, req.skillLevel, req.industry);
		
		return ResponseEntity.status(HttpStatus.OK).body(null);
	}
	
}
