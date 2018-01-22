package com.logicq.reckon.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.logicq.reckon.model.Event;
import com.logicq.reckon.service.EventService;

@RestController
@EnableAutoConfiguration
@RequestMapping("/api")
public class EventController {

	@Autowired
	EventService eventService;

	 @MessageMapping("/event")
	  @SendTo("/topic/message")
	public ResponseEntity<Event> recivedEvent(@RequestBody Event event) {
		System.out.println("called to post "+event);
		//eventService.saveEvent(event);
		return new ResponseEntity<Event>(event, HttpStatus.OK);
	}

	@RequestMapping(value = "/allEvents", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Event>> getAllEvents() throws Exception {
		List<Event> eventList = eventService.findAllEvent();
		return new ResponseEntity<List<Event>>(eventList, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/events/{status}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Event>> getEventsAccordingToStatus(@PathVariable String status) throws Exception {
		List<Event> eventList = eventService.findAllEvent();
		return new ResponseEntity<List<Event>>(eventList, HttpStatus.OK);
	}

}
