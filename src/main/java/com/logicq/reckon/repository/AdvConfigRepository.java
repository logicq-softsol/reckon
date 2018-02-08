package com.logicq.reckon.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import com.logicq.reckon.model.AdvConfig;

@Transactional
public interface AdvConfigRepository extends JpaRepository<AdvConfig, Long>{

}
