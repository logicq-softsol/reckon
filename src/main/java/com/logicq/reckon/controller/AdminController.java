package com.logicq.reckon.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.logicq.reckon.model.TableInventory;
import com.logicq.reckon.model.UserDetails;
import com.logicq.reckon.service.InventoryService;

@RestController
@EnableAutoConfiguration
@RequestMapping("/api")
public class AdminController {

	@Autowired
	HttpServletRequest request;

	@Autowired
	InventoryService inventoryService;

	@RequestMapping(value = "/login", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<UserDetails> login() {
		String username = (String) request.getHeader("username");
		String password = (String) request.getHeader("password");
		UserDetails user = new UserDetails();
		user.setMobileNo("7057014118");
		user.setUsername(username);
		user.setActive(Boolean.TRUE);
		return new ResponseEntity<UserDetails>(user, HttpStatus.OK);
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

	@RequestMapping(value = "/delinkedTableAndDevice", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<TableInventory>> delinkTableAndDevice(
			@RequestBody List<TableInventory> tableInventories) {
		if (!tableInventories.isEmpty()) {
			inventoryService.deleteLinkTablesAndDevices(tableInventories);
		} else {
			return new ResponseEntity<List<TableInventory>>(tableInventories, HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<List<TableInventory>>(tableInventories, HttpStatus.OK);
	}

	@RequestMapping(value = "/linkedDevices", method = RequestMethod.GET)
	public ResponseEntity<List<TableInventory>> linkedDevices() {
		return new ResponseEntity<List<TableInventory>>(inventoryService.getLinkedTables(), HttpStatus.OK);
	}

	@RequestMapping(value = "/delinkedDevices", method = RequestMethod.GET)
	public ResponseEntity<List<TableInventory>> delinkedDevices() {
		return new ResponseEntity<List<TableInventory>>(inventoryService.getNotLinkedTables(), HttpStatus.OK);
	}

}
