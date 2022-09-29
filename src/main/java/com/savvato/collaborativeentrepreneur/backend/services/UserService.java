package com.savvato.collaborativeentrepreneur.backend.services;

import com.savvato.collaborativeentrepreneur.backend.entities.User;

public interface UserService {
	public User createNewUser(String name, String password, String phone, String email, String preferredContactMethod);

	public User find(String query);
	public User findById(Long id);
}
