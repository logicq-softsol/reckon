package com.logicq.reckon.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.logicq.reckon.model.EntityDetails;

@Repository
public interface EntityDetailsRepo extends JpaRepository<EntityDetails, Long> {

}
