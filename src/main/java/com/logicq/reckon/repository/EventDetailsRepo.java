package com.logicq.reckon.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.logicq.reckon.model.EventDetails;

@Repository
public interface EventDetailsRepo extends JpaRepository<EventDetails, Long> {

}
