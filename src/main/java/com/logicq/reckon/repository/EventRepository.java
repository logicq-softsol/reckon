package com.logicq.reckon.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import com.logicq.reckon.model.Event;

@Transactional
public interface EventRepository extends JpaRepository<Event, String> {

}
