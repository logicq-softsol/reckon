package com.logicq.reckon.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.logicq.reckon.model.UserDetails;

public interface UserDetailsRepository extends JpaRepository<UserDetails, Long>{

}
