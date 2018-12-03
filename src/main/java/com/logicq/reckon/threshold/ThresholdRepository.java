package com.logicq.reckon.threshold;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import com.logicq.reckon.model.Threshold;

@Transactional
public interface ThresholdRepository extends JpaRepository<Threshold, Long> {

	Threshold findByName(String name);
	
	List<Threshold> findAllByOrderByIntervalDesc();

}
