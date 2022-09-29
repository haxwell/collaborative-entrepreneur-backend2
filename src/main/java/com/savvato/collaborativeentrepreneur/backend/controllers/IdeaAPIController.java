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

import com.savvato.collaborativeentrepreneur.backend.controllers.dto.IdeaRequest;
import com.savvato.collaborativeentrepreneur.backend.dto.IdeaDTO;
import com.savvato.collaborativeentrepreneur.backend.entities.Idea;
import com.savvato.collaborativeentrepreneur.backend.services.IdeaService;

@RestController
public class IdeaAPIController {

	@Autowired
	IdeaService ideaService;
	
	IdeaAPIController() {
			
	}
	
	@RequestMapping(value = { "/api/idea/create" }, method=RequestMethod.POST)
	public ResponseEntity<Idea> createIdea(@RequestBody @Valid IdeaRequest request) {
		
		Idea idea = ideaService.createNewIdea(request.userId, request.name, request.description);
		
		if (idea == null) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
		} else {
			return ResponseEntity.status(HttpStatus.OK).body(idea);
		}
	}
	
	@RequestMapping(value = { "/api/idea" }, method=RequestMethod.GET)
	public ResponseEntity<List<IdeaDTO>> getAll() {
		
		List<IdeaDTO> list = ideaService.getAll();
		
		return ResponseEntity.status(HttpStatus.OK).body(list);
	}
	
	@RequestMapping(value = { "/api/user/{userId}/ideas" }, method=RequestMethod.GET)
	public ResponseEntity<List<Idea>> getAllByUserId(@PathVariable Long userId) {
		
		List<Idea> list = ideaService.getIdeasByUserId(userId);
		
		return ResponseEntity.status(HttpStatus.OK).body(list);
	}
	
	@RequestMapping(value = { "/api/idea/{ideaId}" }, method=RequestMethod.GET)
	public ResponseEntity<Idea> getById(@PathVariable Long ideaId) {
		
		Idea idea = ideaService.getById(ideaId);
		
		return ResponseEntity.status(HttpStatus.OK).body(idea);
	}
	
	@RequestMapping(value = { "/api/idea/{ideaId}" }, method=RequestMethod.PUT)
	public ResponseEntity<Idea> update(@RequestBody @Valid IdeaRequest request) {
		Idea idea = ideaService.update(request.id, request.name, request.description);
		
		if (idea == null) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
		} else {
			return ResponseEntity.status(HttpStatus.OK).body(idea);
		}
	}
	
}