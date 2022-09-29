package com.savvato.collaborativeentrepreneur.backend.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.savvato.collaborativeentrepreneur.backend.entities.Idea;

public interface IdeaRepository extends CrudRepository<Idea, Long> {

	List<Idea> findByUserId(Long userId);
}
