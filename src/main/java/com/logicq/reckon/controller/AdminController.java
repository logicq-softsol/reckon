package com.logicq.reckon.controller;

import java.util.List;

import javax.annotation.PostConstruct;
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

import com.logicq.reckon.model.AdvConfig;
import com.logicq.reckon.model.GlobalDirectory;
import com.logicq.reckon.model.ServiceDetails;
import com.logicq.reckon.model.TableInventory;
import com.logicq.reckon.model.UserDetails;
import com.logicq.reckon.repository.GlobalDirectoryRepository;
import com.logicq.reckon.repository.UserDetailsRepository;
import com.logicq.reckon.service.AdvConfigServiceImpl;
import com.logicq.reckon.service.InventoryService;
import com.logicq.reckon.service.ServiceDetailsService;
import com.logicq.reckon.service.TableStatusService;
import com.logicq.reckon.vo.UserVO;

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

	@Autowired
	AdvConfigServiceImpl advConfigService;

	@Autowired
	GlobalDirectoryRepository globalDirectory;

	@Autowired
	UserDetailsRepository userDetailsRepo;

	@Autowired
	UserVO uservo;

	@RequestMapping(value = "/login", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<UserDetails> login() throws Exception {
		UserDetails usrDetails = new UserDetails();
		String username = (String) request.getHeader("username");
		String password = (String) request.getHeader("password");
		if (uservo.getUsername().equals(username)) {
			usrDetails.setActive(Boolean.TRUE);
			usrDetails.setAddress(uservo.getAddress());
			usrDetails.setCity(uservo.getCity());
			usrDetails.setCountry(uservo.getCountry());
			usrDetails.setEmail(uservo.getEmail());
			usrDetails.setFirstname(uservo.getEmail());
			usrDetails.setLastname(uservo.getLastname());
			usrDetails.setMobileno(uservo.getMobileno());
			usrDetails.setPostalcode(uservo.getPostalcode());
			usrDetails.setUsername(uservo.getUsername());
		} else {
			throw new Exception(" Username or passowrd may be incorrect");
		}
		return new ResponseEntity<UserDetails>(usrDetails, HttpStatus.OK);
	}

	@PostConstruct
	public void init() {
		List<UserDetails> users = userDetailsRepo.findAll();
		if (null == users || users.isEmpty()) {
			UserDetails usrDetails = new UserDetails();
			usrDetails.setActive(Boolean.TRUE);
			usrDetails.setAddress(uservo.getAddress());
			usrDetails.setCity(uservo.getCity());
			usrDetails.setCountry(uservo.getCountry());
			usrDetails.setEmail(uservo.getEmail());
			usrDetails.setFirstname(uservo.getEmail());
			usrDetails.setLastname(uservo.getLastname());
			usrDetails.setMobileno(uservo.getMobileno());
			usrDetails.setPostalcode(uservo.getPostalcode());
			usrDetails.setUsername(uservo.getUsername());
			userDetailsRepo.save(usrDetails);
		}
	}

	@RequestMapping(value = "/userDetails", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<UserDetails> getUserDetails() {
		UserDetails user = null;
		List<UserDetails> users = userDetailsRepo.findAll();
		if (null == users || users.size() > 1) {
			return new ResponseEntity<UserDetails>(user, HttpStatus.BAD_REQUEST);
		} else {
			user = users.get(0);
			return new ResponseEntity<UserDetails>(user, HttpStatus.OK);
		}
	}

	@RequestMapping(value = "/updateUserDetails", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<UserDetails> updateUser(@RequestBody  UserDetails user) throws Exception {
		userDetailsRepo.save(user);
		List<UserDetails> userdetails = userDetailsRepo.findAll();
		if (userdetails != null && userdetails.size() > 1) {
			throw new Exception(" Multi User not allow to acess.Only Single lisence");
		}
		return new ResponseEntity<UserDetails>(userdetails.get(0), HttpStatus.OK);
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
		return new ResponseEntity<List<ServiceDetails>>(serviceDetailsService.saveServicesDetails(serviceDetails),
				HttpStatus.OK);
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
		return new ResponseEntity<List<ServiceDetails>>(serviceDetailsService.deleteServicesDetails(serviceDetails),
				HttpStatus.OK);
	}

	@RequestMapping(value = "/allAdv", method = RequestMethod.GET)
	public ResponseEntity<List<AdvConfig>> allAdv() {
		return new ResponseEntity<List<AdvConfig>>(advConfigService.getAllAdvConfig(), HttpStatus.OK);
	}

	@RequestMapping(value = "/AdvConfig", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<AdvConfig>> saveAdvConfig(@RequestBody AdvConfig advConfig) {
		return new ResponseEntity<List<AdvConfig>>(advConfigService.saveAdvConfig(advConfig), HttpStatus.OK);
	}

	@RequestMapping(value = "/deleteAdvConfig", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<AdvConfig>> deleteAdvConfig(@RequestBody AdvConfig advConfig) {
		return new ResponseEntity<List<AdvConfig>>(advConfigService.deleteAdvConfig(advConfig), HttpStatus.OK);
	}

	@RequestMapping(value = "/directories", method = RequestMethod.GET)
	public ResponseEntity<List<GlobalDirectory>> allDirectories() {
		return new ResponseEntity<List<GlobalDirectory>>(globalDirectory.findAll(), HttpStatus.OK);
	}

	@RequestMapping(value = "/saveDirectories", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<GlobalDirectory>> saveDirectories(@RequestBody GlobalDirectory directories) {
		globalDirectory.save(directories);
		return new ResponseEntity<List<GlobalDirectory>>(globalDirectory.findAll(), HttpStatus.OK);
	}

}
