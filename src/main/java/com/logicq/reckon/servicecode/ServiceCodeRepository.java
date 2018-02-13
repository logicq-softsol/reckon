package com.logicq.reckon.servicecode;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import com.logicq.reckon.model.ServiceDetails;

@Transactional
public interface ServiceCodeRepository extends JpaRepository<ServiceDetails, Long> {

}
