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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.logicq.reckon.model.LinkedRNotifyDetails;
import com.logicq.reckon.model.LinkedService;
import com.logicq.reckon.model.ServiceConfig;
import com.logicq.reckon.repository.LinkedRnotifyDetailsRepository;
import com.logicq.reckon.repository.LinkedServiceRepository;
import com.logicq.reckon.repository.ServiceConfigRepository;

@RestController
@EnableAutoConfiguration
@RequestMapping("/api/reckon/service")
public class ServiceConfigController {

	@Autowired
	ServiceConfigRepository serviceConfigRepository;

	@Autowired
	LinkedServiceRepository linkedServiceRepository;
	

	@Autowired
	LinkedRnotifyDetailsRepository linkedRnotifyDetailsRepository;

	@RequestMapping(value = "/configs", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<ServiceConfig>> getAllServiceDetails() {
		return new ResponseEntity<List<ServiceConfig>>(serviceConfigRepository.findAll(), HttpStatus.OK);
	}

	@RequestMapping(value = "/config", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<ServiceConfig>> addServiceCode(@RequestBody ServiceConfig serviceConfig) {
		serviceConfigRepository.save(serviceConfig);
		return new ResponseEntity<List<ServiceConfig>>(serviceConfigRepository.findAll(), HttpStatus.OK);
	}

	@RequestMapping(value = "/config", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<ServiceConfig>> updateServiceCode(@RequestBody ServiceConfig serviceConfig) {
		serviceConfigRepository.save(serviceConfig);
		return new ResponseEntity<List<ServiceConfig>>(serviceConfigRepository.findAll(), HttpStatus.OK);
	}

	@RequestMapping(value = "/config/{serviceName}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<ServiceConfig>> updateServiceCode(@RequestParam String serviceName) {
		serviceConfigRepository.delete(serviceName);
		return new ResponseEntity<List<ServiceConfig>>(serviceConfigRepository.findAll(), HttpStatus.OK);
	}

	@RequestMapping(value = "/links", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<LinkedService>> getLinkedServiceDetails() {
		return new ResponseEntity<List<LinkedService>>(linkedServiceRepository.findAll(), HttpStatus.OK);
	}
	
	

	@RequestMapping(value = "/link", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<LinkedService>> addLinkedService(@RequestBody LinkedService linkedService) {
		linkedServiceRepository.save(linkedService);
		return new ResponseEntity<List<LinkedService>>(linkedServiceRepository.findAll(), HttpStatus.OK);
	}

	@RequestMapping(value = "/link", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<LinkedService>> updateLinkedService(@RequestBody LinkedService linkedService) {
		linkedServiceRepository.save(linkedService);
		return new ResponseEntity<List<LinkedService>>(linkedServiceRepository.findAll(), HttpStatus.OK);
	}

	@RequestMapping(value = "/link/{serviceCode}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<LinkedService>> updateServiceCode(@RequestParam Long serviceCode) {
		LinkedService linkService = new LinkedService();
		linkService.setServiceCode(serviceCode);
		linkedServiceRepository.delete(linkService);
		return new ResponseEntity<List<LinkedService>>(linkedServiceRepository.findAll(), HttpStatus.OK);
	}

}
