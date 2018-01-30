package com.logicq.reckon.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.logicq.reckon.model.TableStatus;
import com.logicq.reckon.service.TableStatusService;
import com.logicq.reckon.vo.EventVO;

@RestController
@EnableAutoConfiguration
@RequestMapping("/api")
public class EventController {

	@Autowired
	TableStatusService tableStatusService;

	@RequestMapping(value = "/eventclicked", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<EventVO> clickedEvent(@RequestBody EventVO eventVO) {
		tableStatusService.saveEvent(eventVO);
		return new ResponseEntity<EventVO>(eventVO, HttpStatus.OK);
	}

	@RequestMapping(value = "/allEvents", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<TableStatus>> getAllEvents() throws Exception {
		List<TableStatus> eventList = tableStatusService.findAllEvent();
		return new ResponseEntity<List<TableStatus>>(eventList, HttpStatus.OK);
	}

	@RequestMapping(value = "/events/{status}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<TableStatus>> getEventsAccordingToStatus(@PathVariable String status) throws Exception {
		List<TableStatus> eventList = tableStatusService.findAllEvent();
		return new ResponseEntity<List<TableStatus>>(eventList, HttpStatus.OK);
	}

}
