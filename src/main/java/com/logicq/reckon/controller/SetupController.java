package com.logicq.reckon.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.logicq.reckon.model.EntityDetails;
import com.logicq.reckon.model.ServiceDetails;
import com.logicq.reckon.model.Threshold;
import com.logicq.reckon.repository.EntityDetailsRepo;
import com.logicq.reckon.repository.ServiceDetailsRepo;
import com.logicq.reckon.repository.ThresholdDetailsRepo;

@RestController
@RequestMapping("/api/setup")
public class SetupController {

	@Autowired
	EntityDetailsRepo entityDetailsRepo;

	@Autowired
	ServiceDetailsRepo serviceDetailsRepo;

	@Autowired
	ThresholdDetailsRepo thresholdDetailsRepo;

	@RequestMapping(value = "/entity", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<EntityDetails>> addEntity(@RequestBody EntityDetails entityDetail) throws Exception {
		entityDetailsRepo.save(entityDetail);
		return new ResponseEntity<List<EntityDetails>>(entityDetailsRepo.findAll(), HttpStatus.OK);
	}

	@RequestMapping(value = "/entity", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<EntityDetails>> updateEntity(@RequestBody EntityDetails entityDetail) throws Exception {
		entityDetailsRepo.save(entityDetail);
		return new ResponseEntity<List<EntityDetails>>(entityDetailsRepo.findAll(), HttpStatus.OK);
	}

	@RequestMapping(value = "/entity", method = RequestMethod.GET)
	public ResponseEntity<List<EntityDetails>> getEntities() {
		return new ResponseEntity<List<EntityDetails>>(entityDetailsRepo.findAll(), HttpStatus.OK);
	}

	@RequestMapping(value = "/entity/{entityId}", method = RequestMethod.DELETE)
	public ResponseEntity<List<EntityDetails>> deleteEntityById(@PathVariable long entityId) {
		entityDetailsRepo.delete(entityId);
		return new ResponseEntity<List<EntityDetails>>(entityDetailsRepo.findAll(), HttpStatus.OK);
	}

	@RequestMapping(value = "/service", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<ServiceDetails>> addServiceDetails(@RequestBody ServiceDetails serviceDetails)
			throws Exception {
		serviceDetailsRepo.save(serviceDetails);
		return new ResponseEntity<List<ServiceDetails>>(serviceDetailsRepo.findAll(), HttpStatus.OK);
	}

	@RequestMapping(value = "/service", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<ServiceDetails>> updateServiceDetails(@RequestBody ServiceDetails serviceDetails)
			throws Exception {
		serviceDetailsRepo.save(serviceDetails);
		return new ResponseEntity<List<ServiceDetails>>(serviceDetailsRepo.findAll(), HttpStatus.OK);
	}

	@RequestMapping(value = "/service", method = RequestMethod.GET)
	public ResponseEntity<List<ServiceDetails>> getServiceDetails() {
		return new ResponseEntity<List<ServiceDetails>>(serviceDetailsRepo.findAll(), HttpStatus.OK);
	}

	@RequestMapping(value = "/service/{serviceId}", method = RequestMethod.DELETE)
	public ResponseEntity<List<ServiceDetails>> deleteServiceDetails(@PathVariable long serviceId) {
		serviceDetailsRepo.delete(serviceId);
		return new ResponseEntity<List<ServiceDetails>>(serviceDetailsRepo.findAll(), HttpStatus.OK);
	}

	@RequestMapping(value = "/threshold", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Threshold>> addThreshold(@RequestBody Threshold threshold) throws Exception {
		thresholdDetailsRepo.save(threshold);
		return new ResponseEntity<List<Threshold>>(thresholdDetailsRepo.findAll(), HttpStatus.OK);
	}

	@RequestMapping(value = "/threshold", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Threshold>> updateThreshold(@RequestBody Threshold threshold) throws Exception {
		thresholdDetailsRepo.save(threshold);
		return new ResponseEntity<List<Threshold>>(thresholdDetailsRepo.findAll(), HttpStatus.OK);
	}

	@RequestMapping(value = "/threshold", method = RequestMethod.GET)
	public ResponseEntity<List<Threshold>> getThreshold() {
		return new ResponseEntity<List<Threshold>>(thresholdDetailsRepo.findAll(), HttpStatus.OK);
	}

	@RequestMapping(value = "/threshold/{thresholdId}", method = RequestMethod.DELETE)
	public ResponseEntity<List<Threshold>> deleteThreshold(@PathVariable long thresholdId) {
		thresholdDetailsRepo.delete(thresholdId);
		return new ResponseEntity<List<Threshold>>(thresholdDetailsRepo.findAll(), HttpStatus.OK);
	}

}
