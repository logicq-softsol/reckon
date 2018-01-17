package com.logicq.reckon.controller;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.logicq.reckon.model.UserDetails;

@RestController
@EnableAutoConfiguration
@RequestMapping("/api")
public class MainController {

	@RequestMapping(value = "/login",  method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<UserDetails> login() {
		UserDetails user=new UserDetails();
		user.setMobileNo("7057014118");
		user.setUsername("Demo");
		return new ResponseEntity<UserDetails>(user, HttpStatus.OK);
	}

}
