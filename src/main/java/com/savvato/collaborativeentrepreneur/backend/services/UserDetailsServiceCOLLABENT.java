package com.savvato.collaborativeentrepreneur.backend.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.savvato.collaborativeentrepreneur.backend.config.principle.UserPrincipal;
import com.savvato.collaborativeentrepreneur.backend.entities.User;
import com.savvato.collaborativeentrepreneur.backend.repositories.UserRepository;

@Service
public class UserDetailsServiceCOLLABENT implements UserDetailsService {

	@Autowired
	UserRepository userRepo;

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		Optional<User> opt = userRepo.findByEmail(email);
		User rtn = null;

		if (opt.isPresent())
			rtn = opt.get();
		else
			throw new UsernameNotFoundException(email);

		return new UserPrincipal(rtn);
	}
}
