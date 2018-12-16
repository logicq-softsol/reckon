package com.logicq.reckon.utils;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import com.logicq.reckon.model.LoginDetails;
import com.logicq.reckon.repository.LoginDetailsRepo;
import com.logicq.reckon.security.JwtTokenProvider;

@Component
public class ReckonSecurityUtils {

	@Autowired
	LoginDetailsRepo loginDetailsRepo;

	@Autowired
	JwtTokenProvider tokenProvider;

	@Autowired
	private HttpServletRequest context;

	public LoginDetails getUserFromSecurityContext() throws Exception {
		if (SecurityContextHolder.getContext().getAuthentication().isAuthenticated()) {
			String userName = tokenProvider.getUserIdFromJWT(tokenProvider.getJwtFromRequest(context));
			return loginDetailsRepo.findByUserName(userName);
		} else {
			throw new Exception(" User is Not Authorized to acess ");
		}
	}
}
