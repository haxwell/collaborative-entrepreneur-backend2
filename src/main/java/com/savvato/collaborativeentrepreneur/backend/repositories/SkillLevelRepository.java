package com.savvato.collaborativeentrepreneur.backend.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.savvato.collaborativeentrepreneur.backend.entities.SkillLevel;

public interface SkillLevelRepository extends CrudRepository<SkillLevel, Long> {
	Optional<SkillLevel> findById(Long id);
}
