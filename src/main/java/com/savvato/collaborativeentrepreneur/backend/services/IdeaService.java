package com.savvato.collaborativeentrepreneur.backend.services;

import java.util.List;

import com.savvato.collaborativeentrepreneur.backend.dto.IdeaDTO;
import com.savvato.collaborativeentrepreneur.backend.entities.Idea;

public interface IdeaService {
	public Idea getById(Long ideaId);
	
	public List<IdeaDTO> getAll();
	
	public Idea createNewIdea(Long userId, String name, String description);
	
	public List<Idea> getIdeasByUserId(Long userId);

	public Idea update(Long ideaId, String name, String description);	
}

