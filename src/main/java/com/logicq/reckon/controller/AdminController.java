package com.logicq.reckon.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.logicq.reckon.model.ServiceDetails;
import com.logicq.reckon.model.TableInventory;
import com.logicq.reckon.model.UserDetails;
import com.logicq.reckon.service.InventoryService;
import com.logicq.reckon.service.ServiceDetailsService;
import com.logicq.reckon.service.TableStatusService;
import com.logicq.reckon.vo.LoginVO;

@RestController
@EnableAutoConfiguration
@RequestMapping("/api")
public class AdminController {

	@Autowired
	HttpServletRequest request;

	@Autowired
	InventoryService inventoryService;

	@Autowired
	TableStatusService tableStatusService;

	@Autowired
	ServiceDetailsService serviceDetailsService;

	@RequestMapping(value = "/login", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<LoginVO> login() {
		LoginVO loginDetails = new LoginVO();
		String username = (String) request.getHeader("username");
		String password = (String) request.getHeader("password");
		UserDetails user = new UserDetails();
		user.setMobileNo("7057014118");
		user.setUsername(username);
		user.setActive(Boolean.TRUE);
		/*
		 * Map<Long, ServiceRequestVO> result =
		 * tableStatusService.getBusyTableDetails(); loginDetails.setUser(user);
		 * loginDetails.setTableDetails(result);
		 */ return new ResponseEntity<LoginVO>(loginDetails, HttpStatus.OK);
	}

	@RequestMapping(value = "/linkTableAndDevice", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<TableInventory>> linkTableAndDevice(@RequestBody List<TableInventory> tableInventories) {
		if (!tableInventories.isEmpty()) {
			inventoryService.saveMultiTableAndDevices(tableInventories);
		} else {
			return new ResponseEntity<List<TableInventory>>(tableInventories, HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<List<TableInventory>>(tableInventories, HttpStatus.OK);
	}

	@RequestMapping(value = "/linkdTableAndDevice", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<TableInventory>> linkTableAndDevice(@RequestBody TableInventory tableInventories) {
		List<TableInventory> tables = null;
		if (null != tableInventories) {
			inventoryService.saveLinkTableAndDevice(tableInventories);
			tables = inventoryService.getAllTables();
		} else {
			return new ResponseEntity<List<TableInventory>>(tables, HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<List<TableInventory>>(tables, HttpStatus.OK);
	}

	@RequestMapping(value = "/deleteLinkedTableandDevice", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<TableInventory>> delinkTableAndDevice(@RequestBody TableInventory table) {
		List<TableInventory> tables = null;
		if (null != table) {
			inventoryService.deleteLinkTablesAndDevices(table);
			tables = inventoryService.getAllTables();
		} else {
			return new ResponseEntity<List<TableInventory>>(tables, HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<List<TableInventory>>(tables, HttpStatus.OK);
	}

	@RequestMapping(value = "/linkedDevices", method = RequestMethod.GET)
	public ResponseEntity<List<TableInventory>> linkedDevices() {
		return new ResponseEntity<List<TableInventory>>(inventoryService.getLinkedTables(), HttpStatus.OK);
	}

	@RequestMapping(value = "/alltables", method = RequestMethod.GET)
	public ResponseEntity<List<TableInventory>> allTables() {
		return new ResponseEntity<List<TableInventory>>(inventoryService.getAllTables(), HttpStatus.OK);
	}

	@RequestMapping(value = "/delinkedDevices", method = RequestMethod.GET)
	public ResponseEntity<List<TableInventory>> delinkedDevices() {
		return new ResponseEntity<List<TableInventory>>(inventoryService.getNotLinkedTables(), HttpStatus.OK);
	}

	@RequestMapping(value = "/allserviceDetails", method = RequestMethod.GET)
	public ResponseEntity<List<ServiceDetails>> allServiceDetails() {
		return new ResponseEntity<List<ServiceDetails>>(serviceDetailsService.getAllServicesDetails(), HttpStatus.OK);
	}

	@RequestMapping(value = "/saveServiceDetails", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<ServiceDetails>> saveServiceDetails(@RequestBody ServiceDetails serviceDetails) {
		serviceDetailsService.saveServicesDetails(serviceDetails);
		return new ResponseEntity<List<ServiceDetails>>(serviceDetailsService.getAllServicesDetails(), HttpStatus.OK);
	}

	@RequestMapping(value = "/serviceDetailsForName/{servicename}", method = RequestMethod.GET)
	public ResponseEntity<ServiceDetails> serviceDetailsForServiceName(@PathVariable String serviceName) {
		return new ResponseEntity<ServiceDetails>(serviceDetailsService.servicesDetailsForName(serviceName),
				HttpStatus.OK);
	}

	@RequestMapping(value = "/serviceDetailsForCode/{serviccode}", method = RequestMethod.GET)
	public ResponseEntity<ServiceDetails> serviceDetailsForServiceName(@PathVariable Long serviceCode) {
		return new ResponseEntity<ServiceDetails>(serviceDetailsService.servicesDetailsForCode(serviceCode),
				HttpStatus.OK);
	}

	@RequestMapping(value = "/deleteServiceDetails", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<ServiceDetails>> deleteService(@RequestBody ServiceDetails serviceDetails) {
		serviceDetailsService.deleteServicesDetails(serviceDetails);
		return new ResponseEntity<List<ServiceDetails>>(serviceDetailsService.getAllServicesDetails(), HttpStatus.OK);
	}

}
