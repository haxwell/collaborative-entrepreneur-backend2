package com.savvato.collaborativeentrepreneur.backend.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.savvato.collaborativeentrepreneur.backend.entities.Meeting;

public interface MeetingRepository extends CrudRepository<Meeting, Long> {

	@Query(nativeQuery = true, value = "select m.* from meeting m ORDER BY m.timestamp DESC LIMIT 1")
	Optional<Meeting> findMostRecentlyStarted();
}
