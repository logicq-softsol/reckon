package com.logicq.reckon.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.logicq.reckon.model.Event;
import com.logicq.reckon.repository.EventRepository;

@Service
public class EventServiceImpl implements EventService {

	@Autowired
	EventRepository eventRepository;

	@Autowired
	SimpMessagingTemplate brokerMessagingTemplate;

	@Transactional
	public void saveEvent(Event event) {
		System.out.println(" Event recived before insert : " + event);
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

	@Override
	public void sendMessage(Event event) {
		brokerMessagingTemplate.convertAndSend("/topics/event", JSON.toJSONString(event, SerializerFeature.BrowserCompatible));
		System.out.println(" message Send to /topics/event "+event);
	}

}
