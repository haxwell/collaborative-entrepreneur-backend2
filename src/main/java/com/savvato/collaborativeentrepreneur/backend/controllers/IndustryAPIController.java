package com.savvato.collaborativeentrepreneur.backend.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.savvato.collaborativeentrepreneur.backend.controllers.dto.IndustryRequest;
import com.savvato.collaborativeentrepreneur.backend.entities.Industry;
import com.savvato.collaborativeentrepreneur.backend.services.IndustryService;

@RestController
public class IndustryAPIController {

	@Autowired
	IndustryService industryService;

	IndustryAPIController() {

	}

	@RequestMapping(value = { "/api/industry/create" }, method = RequestMethod.POST)
	public ResponseEntity<Industry> createIndustry(@RequestBody @Valid IndustryRequest request) {

		Industry Industry = industryService.createNewIndustry(request.name);

		if (Industry == null) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
		} else {
			return ResponseEntity.status(HttpStatus.OK).body(Industry);
		}
	}

	@RequestMapping(value = { "/api/industry/all" }, method = RequestMethod.GET)
	public ResponseEntity<Iterable<Industry>> getAll() {

		Iterable<Industry> iterable = industryService.getAll();

		return ResponseEntity.status(HttpStatus.OK).body(iterable);
	}

	@RequestMapping(value = { "/api/user/{userId}/industries" }, method = RequestMethod.GET)
	public ResponseEntity<List<Industry>> getAllByUserId(@PathVariable Long userId) {

		List<Industry> list = industryService.getIndustryForUserId(userId);

		return ResponseEntity.status(HttpStatus.OK).body(list);
	}

	@RequestMapping(value = { "/api/industry/{IndustryId}" }, method = RequestMethod.GET)
	public ResponseEntity<Industry> getById(@PathVariable Long IndustryId) {

		Industry Industry = industryService.getById(IndustryId);

		return ResponseEntity.status(HttpStatus.OK).body(Industry);
	}

	@RequestMapping(value = { "/api/industry/{IndustryId}" }, method = RequestMethod.PUT)
	public ResponseEntity<Industry> update(@RequestBody @Valid IndustryRequest request) {
		Industry Industry = industryService.update(request.id, request.name);

		if (Industry == null) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
		} else {
			return ResponseEntity.status(HttpStatus.OK).body(Industry);
		}
	}

}