package com.savvato.collaborativeentrepreneur.backend.services;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.savvato.collaborativeentrepreneur.backend.dto.IdeaDTO;
import com.savvato.collaborativeentrepreneur.backend.entities.Idea;
import com.savvato.collaborativeentrepreneur.backend.entities.User;
import com.savvato.collaborativeentrepreneur.backend.repositories.IdeaRepository;

@Service
public class IdeaServiceImpl implements IdeaService {

	@Autowired
	IdeaRepository ideaRepo;
	
	@Autowired
	UserService userService;
	
	@Autowired
	UserRoleMapService userRoleMapService;


	public Idea createNewIdea(Long userId, String name, String description) {
		Idea entity = new Idea(userId, name, description);
		
		Idea rtn = ideaRepo.save(entity);

		userRoleMapService.addRoleToUser(userId, UserRoleMapService.ROLES.IDEATOR);

		return rtn;
	}
	
	public List<Idea> getIdeasByUserId(Long userId) {
		return ideaRepo.findByUserId(userId);
	}
	
	public List<IdeaDTO> getAll() {
		Iterable<Idea> iterable = ideaRepo.findAll();
		
		Iterator<Idea> iterator = iterable.iterator();
		
		List<IdeaDTO> list = new ArrayList<>();
		
		while (iterator.hasNext()) {
			Idea idea = iterator.next();
			
			// TODO.. some caching of some sort is necessary here.. to keep from reading the database so many times.
			User u = userService.findById(idea.getUserId());
			
			IdeaDTO rtn = new IdeaDTO();
			rtn.idea = idea;
			rtn.user = u;
			
			list.add(rtn);
		}
		
		return list;
	}
	
	public Idea getById(Long ideaId) {
		Optional<Idea> opt = ideaRepo.findById(ideaId);
		
		if (opt.isPresent())
			return opt.get();
		else
			return null;
	}
	
	public Idea update(Long ideaId, String name, String description) {
		Optional<Idea> opt = ideaRepo.findById(ideaId);
		
		if (opt.isPresent()) {
			
			Idea idea = opt.get();
			
			idea.setName(name);
			idea.setDescription(description);
			
			return ideaRepo.save(idea);
		} else {
			return null;
		}
	}
}
