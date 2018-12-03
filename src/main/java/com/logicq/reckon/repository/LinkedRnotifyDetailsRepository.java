package com.logicq.reckon.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import com.logicq.reckon.model.LinkedRNotifyDetails;

@Transactional
public interface LinkedRnotifyDetailsRepository extends JpaRepository<LinkedRNotifyDetails, Long> {
	LinkedRNotifyDetails findByNotifiers(Long reckonId);
}
