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

import com.savvato.collaborativeentrepreneur.backend.dto.SpecificSkillRequest;
import com.savvato.collaborativeentrepreneur.backend.dto.UserSpecificSkillDTO;
import com.savvato.collaborativeentrepreneur.backend.entities.UserSpecificSkill;
import com.savvato.collaborativeentrepreneur.backend.services.UserRoleMapService;
import com.savvato.collaborativeentrepreneur.backend.services.UserService;
import com.savvato.collaborativeentrepreneur.backend.services.UserSpecificSkillService;

@RestController
public class UserSpecificSkillAPIController {

	@Autowired
	UserService userService;
	
	@Autowired
	UserSpecificSkillService userSpecificSkillService;
	
	@Autowired
	UserRoleMapService userRoleMapService;

	UserSpecificSkillAPIController() {
		
	}
	
	@RequestMapping(value = { "/api/user/{userId}/specific-skill/new" }, method=RequestMethod.POST)
	public ResponseEntity<UserSpecificSkill> createUserSpecificSkill(@PathVariable Long userId, @RequestBody @Valid SpecificSkillRequest req) {

		UserSpecificSkill us = userSpecificSkillService.create(userId, req.skill, req.skillLevel, req.industry);

		if (us == null) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
		} else {
			userRoleMapService.addRoleToUser(userId, UserRoleMapService.ROLES.ENTREPRENEUR);

			return ResponseEntity.status(HttpStatus.OK).body(us);
		}
	}

	@RequestMapping(value = { "/api/user/{userId}/specific-skills" }, method=RequestMethod.GET)
	public ResponseEntity<List<UserSpecificSkillDTO>> getByUserId(@PathVariable Long userId) {
		return ResponseEntity.status(HttpStatus.OK).body(userSpecificSkillService.getByUserId(userId));
	}
	
	@RequestMapping(value = { "/api/user/{userId}/specific-skills" }, method=RequestMethod.DELETE)
	public ResponseEntity getByUserId(@PathVariable Long userId, @RequestBody @Valid SpecificSkillRequest req) {
		userSpecificSkillService.delete(userId, req.skill, req.skillLevel, req.industry);
		
		return ResponseEntity.status(HttpStatus.OK).body(null);
	}
	
}
