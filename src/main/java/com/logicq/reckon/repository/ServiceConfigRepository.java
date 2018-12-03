package com.logicq.reckon.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import com.logicq.reckon.model.ServiceConfig;

@Transactional
public interface ServiceConfigRepository extends JpaRepository<ServiceConfig, String> {

}
