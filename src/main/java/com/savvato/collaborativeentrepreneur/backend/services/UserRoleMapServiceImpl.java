package com.savvato.collaborativeentrepreneur.backend.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.savvato.collaborativeentrepreneur.backend.entities.UserRoleMap;
import com.savvato.collaborativeentrepreneur.backend.repositories.UserRepository;
import com.savvato.collaborativeentrepreneur.backend.repositories.UserRoleMapRepository;

@Service
public class UserRoleMapServiceImpl implements UserRoleMapService {

	@Autowired
	UserRepository userRepo;

	@Autowired
	UserRoleMapRepository userRoleMapRepo;
	
	public void addRoleToUser(Long userId, ROLES role) {
		if (role != ROLES.BRANDSPANKINNEWBIE)
			userRoleMapRepo.delete(new UserRoleMap(userId, Long.valueOf(ROLES.BRANDSPANKINNEWBIE.ordinal()+"") ));
		
		userRoleMapRepo.save(new UserRoleMap(userId, Long.valueOf(role.ordinal()+"") ));
	}
	
	public void removeRoleFromUser(Long userId, ROLES role) {
		userRoleMapRepo.delete(new UserRoleMap(userId, Long.valueOf(role.ordinal()+"") ));
	}
}
