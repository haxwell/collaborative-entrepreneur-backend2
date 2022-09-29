package com.savvato.collaborativeentrepreneur.backend.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.savvato.collaborativeentrepreneur.backend.entities.UserAttendanceHistory;

public interface UserAttendanceHistoryRepository extends CrudRepository<UserAttendanceHistory, Long> {

	@Query(nativeQuery = true, value = "select * from user_attendance_history uah where uah.checkin_timestamp >= DATE_SUB(NOW(), INTERVAL 3 HOUR)")
	public List<UserAttendanceHistory> getThoseWithinTheLastThreeHours();

	public List<UserAttendanceHistory> findByUserId(Long userId);
	
	public List<UserAttendanceHistory> findByMeetingId(Long sessionId);
}