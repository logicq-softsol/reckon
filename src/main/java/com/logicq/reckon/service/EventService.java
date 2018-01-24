package com.logicq.reckon.service;

import java.util.List;

import com.logicq.reckon.model.Event;

public interface EventService {

	void sendMessage(Event event);

	void saveEvent(Event event);

	List<Event> findAllEvent();

	void delete(String id);

}
