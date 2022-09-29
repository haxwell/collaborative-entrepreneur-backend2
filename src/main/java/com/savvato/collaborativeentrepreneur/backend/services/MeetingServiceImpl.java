package com.savvato.collaborativeentrepreneur.backend.services;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.savvato.collaborativeentrepreneur.backend.entities.Meeting;
import com.savvato.collaborativeentrepreneur.backend.entities.User;
import com.savvato.collaborativeentrepreneur.backend.entities.UserAttendanceHistory;
import com.savvato.collaborativeentrepreneur.backend.repositories.MeetingRepository;
import com.savvato.collaborativeentrepreneur.backend.repositories.UserAttendanceHistoryRepository;
import com.savvato.collaborativeentrepreneur.backend.repositories.UserRepository;

@Service
public class MeetingServiceImpl implements MeetingService {

	@Autowired
	MeetingRepository meetingRepo;
	
	@Autowired
	UserAttendanceHistoryRepository userAttendanceHistoryRepo;

	@Autowired
	UserRepository userRepo;

	public Meeting createNewMeeting() {
		Meeting entity = new Meeting();
		
		return meetingRepo.save(entity);
	}
	
	public Optional<Meeting> getLastMeeting() {
		return meetingRepo.findMostRecentlyStarted();
	}
	
	public boolean markInAttendance(Long userId) {
		boolean rtn = false;
		
		Optional<Meeting> opt = meetingRepo.findMostRecentlyStarted();
		if (opt.isPresent()) {
			rtn = userAttendanceHistoryRepo.save(new UserAttendanceHistory(opt.get().getId(), userId)) != null;
		}
		
		return rtn;
	}
	
	public List<User> getUsersInAttendance() {
		
		List<User> rtn = new ArrayList<>();
		
		List<UserAttendanceHistory> uahList = new ArrayList<>();
		
		Optional<Meeting> opt = meetingRepo.findMostRecentlyStarted();
		if (opt.isPresent()) {
			uahList = userAttendanceHistoryRepo.findByMeetingId(opt.get().getId());
		}

		Iterator<UserAttendanceHistory> iterator = uahList.iterator();
		while (iterator.hasNext()) {
			rtn.add(userRepo.findById(iterator.next().getUserId()).get());
		}
		
		return rtn;
	}
	
}
