package com.logicq.reckon.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.logicq.reckon.model.ActivationDetails;

@Repository
public interface ProductActivationRepo extends JpaRepository<ActivationDetails, Long> {

}
