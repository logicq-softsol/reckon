package com.logicq.reckon.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import com.logicq.reckon.model.LinkedService;

@Transactional
public interface LinkedServiceRepository extends JpaRepository<LinkedService, Long> {
	List<LinkedService> findByReckonID(Long reckonId);

	LinkedService findByServiceCode(Long serviceCode);

}
