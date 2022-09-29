package com.savvato.collaborativeentrepreneur.backend.repositories;

import org.springframework.data.repository.CrudRepository;

import com.savvato.collaborativeentrepreneur.backend.entities.Industry;

public interface IndustryRepository extends CrudRepository<Industry, Long> {

//	@Query(nativeQuery = true, value = "select i.* from industry i")
//	List<Skill> findByUserId(Long userId);
	
}
