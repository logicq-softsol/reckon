package com.logicq.reckon.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.logicq.reckon.model.Threshold;

@Repository
public interface ThresholdDetailsRepo extends JpaRepository<Threshold, Long> {

}
