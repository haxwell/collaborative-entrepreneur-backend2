package com.savvato.collaborativeentrepreneur.backend.services;

import com.savvato.collaborativeentrepreneur.backend.config.principle.UserPrincipal;

public interface UserPrincipalService {
	public UserPrincipal getUserPrincipalByName(String name);
	public UserPrincipal getUserPrincipalByEmail(String email);
}
