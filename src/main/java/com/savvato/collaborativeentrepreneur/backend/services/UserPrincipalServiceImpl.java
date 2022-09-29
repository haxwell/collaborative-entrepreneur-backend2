package com.savvato.collaborativeentrepreneur.backend.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.savvato.collaborativeentrepreneur.backend.config.principle.UserPrincipal;
import com.savvato.collaborativeentrepreneur.backend.entities.User;
import com.savvato.collaborativeentrepreneur.backend.repositories.UserRepository;

@Service
public class UserPrincipalServiceImpl implements UserPrincipalService {

	@Autowired
	UserRepository userRepo;
	
	public UserPrincipal getUserPrincipalByName(String name) {
		Optional<User> opt = userRepo.findByName(name);
		
		if (opt.isPresent())
			return new UserPrincipal(opt.get());
		else
			return null;
	}
	
	public UserPrincipal getUserPrincipalByEmail(String email) {
		Optional<User> opt = userRepo.findByEmail(email);
		
		if (opt.isPresent())
			return new UserPrincipal(opt.get());
		else
			return null;
	}
}
