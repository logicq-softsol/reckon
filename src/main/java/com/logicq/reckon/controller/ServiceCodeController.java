package com.logicq.reckon.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.logicq.reckon.model.ServiceDetails;
import com.logicq.reckon.servicecode.ServiceCodeRepository;

@RestController
@EnableAutoConfiguration
@RequestMapping("/api/service")
public class ServiceCodeController {

	@Autowired
	ServiceCodeRepository serviceCodeRepository;

	@RequestMapping(value = "/allServiceCode", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<ServiceDetails>> getAllServiceDetails() {
		return new ResponseEntity<List<ServiceDetails>>(serviceCodeRepository.findAll(), HttpStatus.OK);
	}

	@RequestMapping(value = "/serviceCode", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<ServiceDetails>> addServiceCode(@RequestBody ServiceDetails service) {
		serviceCodeRepository.save(service);
		return new ResponseEntity<List<ServiceDetails>>(serviceCodeRepository.findAll(), HttpStatus.OK);
	}

	@RequestMapping(value = "/removeServiceCode", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<ServiceDetails>> removeServiceCode(@RequestBody ServiceDetails service) {
		serviceCodeRepository.delete(service);
		return new ResponseEntity<List<ServiceDetails>>(serviceCodeRepository.findAll(), HttpStatus.OK);
	}

}
