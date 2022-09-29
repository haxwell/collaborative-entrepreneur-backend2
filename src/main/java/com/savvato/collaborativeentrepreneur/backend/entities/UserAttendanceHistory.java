package com.savvato.collaborativeentrepreneur.backend.entities;

import java.util.Calendar;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;

@Entity
@IdClass(UserAttendanceHistoryId.class)
public class UserAttendanceHistory {

	@Id
	private Long meetingId;
	
	public Long getMeetingId() {
		return meetingId;
	}
	
	public void setMeetingId(Long id) {
		this.meetingId = id;
	}
	
	@Id
	private Long userId;
	
	public Long getUserId() {
		return this.userId;
	}
	
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	
    private java.sql.Timestamp checkinTimestamp;

    public java.sql.Timestamp getCheckinTimestamp() {
        return checkinTimestamp;
    }
	
    public void setCheckinTimestamp() {
    	this.checkinTimestamp = java.sql.Timestamp.from(Calendar.getInstance().toInstant());
    }
    
    public void setCheckinTimestamp(java.sql.Timestamp ts) {
    	this.checkinTimestamp = ts;
    }

    public UserAttendanceHistory(Long meetingId, Long userId) {
    	this.meetingId = meetingId;
    	this.userId = userId;
    	
    	this.setCheckinTimestamp();
    }
    
    public UserAttendanceHistory() {
    	this.setCheckinTimestamp();
    }
}
