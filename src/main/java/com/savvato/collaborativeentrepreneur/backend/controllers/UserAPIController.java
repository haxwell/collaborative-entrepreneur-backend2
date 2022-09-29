package com.savvato.collaborativeentrepreneur.backend.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.savvato.collaborativeentrepreneur.backend.constants.Constants;
import com.savvato.collaborativeentrepreneur.backend.controllers.dto.CreateNewUserRequest;
import com.savvato.collaborativeentrepreneur.backend.entities.User;
import com.savvato.collaborativeentrepreneur.backend.services.MeetingService;
import com.savvato.collaborativeentrepreneur.backend.services.UserService;

@RestController
public class UserAPIController {

	@Autowired
	UserService userService;
	
	@Autowired
	MeetingService meetingService;
	
	UserAPIController() {
		
	}
	
	@RequestMapping(value = { "/api/public/user/new" }, method=RequestMethod.POST)
	public ResponseEntity<User> createUser(@RequestBody @Valid CreateNewUserRequest req) {
		
		User user = userService.createNewUser(req.name, req.password, req.phone, req.email, Constants.SMS);
		
		if (user == null) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
		} else {
			return ResponseEntity.status(HttpStatus.OK).body(user);
		}
	}
	
}
