package com.logicq.reckon.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import com.logicq.reckon.model.AdvDetails;

@Transactional
public interface AdvDetailsRepository extends JpaRepository<AdvDetails, Long>{
	List<AdvDetails> findByAdvType(String advType);

}
