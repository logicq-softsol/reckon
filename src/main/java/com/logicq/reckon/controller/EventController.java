package com.logicq.reckon.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.logicq.reckon.model.EventDetails;
import com.logicq.reckon.repository.EventDetailsRepo;

@RestController
@RequestMapping("/api/event")
public class EventController {

	@Autowired
	EventDetailsRepo eventDetailsRepo;

	@RequestMapping(value = "/clicked", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<EventDetails> clickedEvent(@RequestBody EventDetails eventDetails) {
		eventDetailsRepo.save(eventDetails);
		return new ResponseEntity<EventDetails>(eventDetails, HttpStatus.OK);
	}

}
