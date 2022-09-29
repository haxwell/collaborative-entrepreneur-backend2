package com.savvato.collaborativeentrepreneur.backend.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.savvato.collaborativeentrepreneur.backend.entities.Skill;

public interface SkillRepository extends CrudRepository<Skill, Long> {

	@Query(nativeQuery = true, value = "select s.* from skill s ")
	List<Skill> findByUserId(Long userId);
	
}
