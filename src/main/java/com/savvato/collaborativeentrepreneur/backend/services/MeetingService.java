package com.savvato.collaborativeentrepreneur.backend.services;

import java.util.List;
import java.util.Optional;

import com.savvato.collaborativeentrepreneur.backend.entities.Meeting;
import com.savvato.collaborativeentrepreneur.backend.entities.User;

public interface MeetingService {
	public Meeting createNewMeeting();
	
	public Optional<Meeting> getLastMeeting();
	
	public boolean markInAttendance(Long userId);
	public List<User> getUsersInAttendance();
	
}
