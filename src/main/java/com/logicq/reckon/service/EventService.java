package com.logicq.reckon.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.logicq.reckon.model.Event;
import com.logicq.reckon.repository.EventRepository;

@Service
public class EventService {

	@Autowired
	EventRepository eventRepository;

	@Transactional
	public void saveEvent(Event event) {
		eventRepository.saveAndFlush(event);
	}

	@Transactional(readOnly = true)
	public List<Event> findAllEvent() {
		return eventRepository.findAll();
	}

	@Transactional
	public void delete(String id) {
		eventRepository.delete(id);
	}

}
