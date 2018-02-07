package com.logicq.reckon.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import com.logicq.reckon.model.ServiceDetails;


@Transactional
public interface ServiceRepository extends JpaRepository<ServiceDetails, Long> ,ServiceQueryRepository{

}
