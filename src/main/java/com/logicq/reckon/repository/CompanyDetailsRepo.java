package com.logicq.reckon.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.logicq.reckon.model.CompanyDetails;
import com.logicq.reckon.model.LoginDetails;

@Repository
public interface CompanyDetailsRepo extends JpaRepository<CompanyDetails, Long> {

}
