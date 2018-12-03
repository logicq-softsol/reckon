package com.logicq.reckon.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.logicq.reckon.model.ActivationDetails;
import com.logicq.reckon.model.EntityDetails;

@Repository
@Transactional
public interface EntityDetailsRepo extends JpaRepository<EntityDetails, String> {

}
