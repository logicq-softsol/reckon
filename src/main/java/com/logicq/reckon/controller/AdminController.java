package com.logicq.reckon.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.logicq.reckon.model.ActivationDetails;
import com.logicq.reckon.model.AdvDetails;
import com.logicq.reckon.model.EntityDetails;
import com.logicq.reckon.model.UserDetails;
import com.logicq.reckon.repository.ActivationDetailsRepo;
import com.logicq.reckon.repository.AdvDetailsRepository;
import com.logicq.reckon.repository.EntityDetailsRepo;
import com.logicq.reckon.repository.UserDetailsRepository;

@RestController
@EnableAutoConfiguration
@RequestMapping("/api")
public class AdminController {

	@Autowired
	UserDetailsRepository userDetailsRepo;

	@Autowired
	ActivationDetailsRepo activationDetailsRepo;

	@Autowired
	AdvDetailsRepository advDetailsRepository;

	@Autowired
	EntityDetailsRepo entityDetailsRepo;

	@RequestMapping(value = "/login", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ActivationDetails> login(@RequestBody UserDetails loginDetails) throws Exception {
		List<UserDetails> userDetailsList = userDetailsRepo.findAll();
		if (userDetailsList.isEmpty() || userDetailsList.size() > 1) {
			throw new Exception("User Not Register or more than one user using this key ");
		}
		// UserDetails userDetails = userDetailsList.get(0);
		ActivationDetails activationDetails = activationDetailsRepo.findAll().get(0);
		/*
		 * if (!(userDetails.getUsername().equals(loginDetails.getUsername()))
		 * && (userDetails.getPassword().equals(loginDetails.getPassword()))) {
		 * throw new Exception(
		 * "User Not Register or more than one user using this key "); }
		 */
		return new ResponseEntity<ActivationDetails>(activationDetails, HttpStatus.OK);
	}

	@RequestMapping(value = "/userDetails", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ActivationDetails> getUserDetails() {
		UserDetails user = null;
		List<UserDetails> users = userDetailsRepo.findAll();
		ActivationDetails activationDetails = null;
		if (null == users || users.size() > 1) {
			return new ResponseEntity<ActivationDetails>(activationDetails, HttpStatus.BAD_REQUEST);
		} else {
			activationDetails = activationDetailsRepo.findAll().get(0);
			return new ResponseEntity<ActivationDetails>(activationDetails, HttpStatus.OK);
		}
	}

	@RequestMapping(value = "/updateUserDetails", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<UserDetails> updateUser(@RequestBody UserDetails user) throws Exception {
		userDetailsRepo.save(user);
		List<UserDetails> userdetails = userDetailsRepo.findAll();
		if (userdetails != null && userdetails.size() > 1) {
			throw new Exception(" Multi User not allow to acess.Only Single lisence");
		}
		return new ResponseEntity<UserDetails>(userdetails.get(0), HttpStatus.OK);
	}

	@RequestMapping(value = "/adv", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<AdvDetails>> getAllServiceDetails() {
		return new ResponseEntity<List<AdvDetails>>(advDetailsRepository.findAll(), HttpStatus.OK);
	}

	@RequestMapping(value = "/adv/{advType}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<AdvDetails>> getAdvTypeVideo(@PathVariable String advType) {
		return new ResponseEntity<List<AdvDetails>>(advDetailsRepository.findByAdvType(advType), HttpStatus.OK);
	}

	@RequestMapping(value = "/adv", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<AdvDetails>> addServiceCode(@RequestBody AdvDetails advDetails) {
		advDetailsRepository.save(advDetails);
		return new ResponseEntity<List<AdvDetails>>(advDetailsRepository.findAll(), HttpStatus.OK);
	}

	@RequestMapping(value = "/adv", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<AdvDetails>> updateServiceCode(@RequestBody AdvDetails advDetails) {
		advDetailsRepository.save(advDetails);
		return new ResponseEntity<List<AdvDetails>>(advDetailsRepository.findAll(), HttpStatus.OK);
	}

	@RequestMapping(value = "/adv/{advId}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<AdvDetails>> updateServiceCode(@RequestParam Long advId) {
		AdvDetails advDetails = new AdvDetails();
		advDetails.setAdvId(advId);
		advDetailsRepository.delete(advDetails);
		return new ResponseEntity<List<AdvDetails>>(advDetailsRepository.findAll(), HttpStatus.OK);
	}

	@RequestMapping(value = "/entity", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<EntityDetails>> getEntityDetails() {
		return new ResponseEntity<List<EntityDetails>>(entityDetailsRepo.findAll(), HttpStatus.OK);
	}

	@RequestMapping(value = "/entity", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<EntityDetails>> addEntityDetails(@RequestBody EntityDetails entityDetails) {
		entityDetailsRepo.save(entityDetails);
		return new ResponseEntity<List<EntityDetails>>(entityDetailsRepo.findAll(), HttpStatus.OK);
	}

	@RequestMapping(value = "/entity", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<EntityDetails>> updateEntityDetails(@RequestBody EntityDetails entityDetails) {
		entityDetailsRepo.save(entityDetails);
		return new ResponseEntity<List<EntityDetails>>(entityDetailsRepo.findAll(), HttpStatus.OK);
	}

	@RequestMapping(value = "/entity/{attrName}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<EntityDetails>> deleteEntityDetails(@RequestParam String attrName) {
		EntityDetails entityDetails = new EntityDetails();
		entityDetails.setAttrName(attrName);
		entityDetailsRepo.delete(entityDetails);
		return new ResponseEntity<List<EntityDetails>>(entityDetailsRepo.findAll(), HttpStatus.OK);
	}

}
