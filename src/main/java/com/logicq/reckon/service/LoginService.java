package com.logicq.reckon.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.logicq.reckon.model.LoginDetails;

public interface LoginService  extends UserDetailsService {


	LoginDetails fetchUserLoginDetails(String userName);

}
