package com.logicq.reckon.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.logicq.reckon.model.ServiceDetails;

@Repository
public interface ServiceDetailsRepo extends JpaRepository<ServiceDetails, Long> {

}
