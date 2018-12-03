package com.logicq.reckon.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import com.logicq.reckon.model.RNotifierClikedStatus;

@Transactional
public interface ClickedRnotifyDetailsRepository extends JpaRepository<RNotifierClikedStatus, Long>{
	
	List<RNotifierClikedStatus> findByNotifiers(Long notifiers);
	List<RNotifierClikedStatus> findByRnotifyCode(Long rnotifyCode);
	
}
