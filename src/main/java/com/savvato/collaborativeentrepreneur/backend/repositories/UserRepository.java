package com.savvato.collaborativeentrepreneur.backend.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.savvato.collaborativeentrepreneur.backend.entities.User;

public interface UserRepository extends CrudRepository<User, Long> {

	@Query(nativeQuery = true, value = "select u.* from user u where u.name=?1 and (u.phone=?2 or u.email=?3)")
	Optional<User> findByNamePhoneOrEmail(String name, String phone, String email);
	
	Optional<User> findByName(String name);
	Optional<User> findByNameAndPassword(String name, String password);
	
	Optional<User> findByEmail(String email);
	Optional<User> findByEmailAndPassword(String email, String password);
	
	@Query(nativeQuery = true, value = "select u.* from user u where u.phone like %?1% or u.email like %?1% LIMIT 1")
	Optional<User> findByPhoneOrEmail(String query);
}
