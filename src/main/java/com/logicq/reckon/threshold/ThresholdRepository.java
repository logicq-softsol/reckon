package com.logicq.reckon.threshold;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import com.logicq.reckon.model.Threshold;

@Transactional
public interface ThresholdRepository extends JpaRepository<Threshold, Long> {

}
