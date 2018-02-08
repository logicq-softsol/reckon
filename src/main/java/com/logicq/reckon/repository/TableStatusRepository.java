package com.logicq.reckon.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import com.logicq.reckon.model.TableStatus;

@Transactional
public interface TableStatusRepository extends JpaRepository<TableStatus, Long>,TableStatusQueryRepository {
	
	
	TableStatus getByTableid(Long tableid);
	
}