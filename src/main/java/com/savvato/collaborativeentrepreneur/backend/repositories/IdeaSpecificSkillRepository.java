package com.savvato.collaborativeentrepreneur.backend.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.savvato.collaborativeentrepreneur.backend.entities.IdeaSpecificSkill;
import com.savvato.collaborativeentrepreneur.backend.entities.IdeaSpecificSkillId;

public interface IdeaSpecificSkillRepository extends CrudRepository<IdeaSpecificSkill, IdeaSpecificSkillId> {

	public List<IdeaSpecificSkill> findByIdeaId(Long ideaId);
}
 