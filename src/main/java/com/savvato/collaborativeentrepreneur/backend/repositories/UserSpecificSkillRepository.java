package com.savvato.collaborativeentrepreneur.backend.repositories;

import org.springframework.data.repository.CrudRepository;

import com.savvato.collaborativeentrepreneur.backend.entities.UserSpecificSkill;

public interface UserSpecificSkillRepository extends CrudRepository<UserSpecificSkill, Long> {

	public Iterable<UserSpecificSkill> findByUserId(Long userId);
}
