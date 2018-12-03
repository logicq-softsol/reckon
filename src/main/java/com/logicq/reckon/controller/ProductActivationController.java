package com.logicq.reckon.controller;

import java.util.List;
import java.util.Properties;

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

import com.logicq.reckon.helper.PropertyFileHelper;
import com.logicq.reckon.helper.RandomHelper;
import com.logicq.reckon.model.ActivationDetails;
import com.logicq.reckon.model.CompanyDetails;
import com.logicq.reckon.model.UserDetails;
import com.logicq.reckon.repository.ActivationDetailsRepo;
import com.logicq.reckon.repository.CompanyDetailsRepo;
import com.logicq.reckon.repository.UserDetailsRepository;
import com.logicq.reckon.vo.ActivationStatus;

@RestController
@EnableAutoConfiguration
@RequestMapping("api/reckon/product")
public class ProductActivationController {

	@Autowired
	UserDetailsRepository userDetailsRepo;

	@Autowired
	CompanyDetailsRepo companyDetailsRepo;

	@Autowired
	ActivationDetailsRepo activationDetailsRepo;

	@Autowired
	RandomHelper randomHelper;

	@Autowired
	PropertyFileHelper propertyFileHelper;

	@Autowired
	HttpServletRequest request;

	@RequestMapping(value = "/activate", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ActivationStatus> activate(@RequestBody ActivationDetails activationDetails)
			throws Exception {
		ActivationStatus status = new ActivationStatus();
		activationDetails.setActivationKey(randomHelper.generateProductKey());
		activationDetails.getCompanyDetails().setCompanyId(randomHelper.generateCopmanyKey());
		activationDetails.getUserDetails().setUsername(activationDetails.getUserDetails().getUsername());
		activationDetailsRepo.save(activationDetails);
		propertyFileHelper.generateActivationFile(activationDetails);
		status.setIsActive(Boolean.TRUE);
		status.setUserName(activationDetails.getUserDetails().getUsername());
		status.setCompanyName(activationDetails.getCompanyDetails().getCompname());
		return new ResponseEntity<ActivationStatus>(status, HttpStatus.OK);
	}

	@RequestMapping(value = "/user", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<UserDetails> saveUser(@RequestBody UserDetails user) throws Exception {
		userDetailsRepo.save(user);
		return new ResponseEntity<UserDetails>(user, HttpStatus.OK);
	}

	@RequestMapping(value = "/companyinfo", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<CompanyDetails> saveCopmanyDetails(@RequestBody CompanyDetails company) throws Exception {
		company.setCompanyId(randomHelper.generateCopmanyKey());
		companyDetailsRepo.save(company);
		return new ResponseEntity<CompanyDetails>(company, HttpStatus.OK);
	}

	@RequestMapping(value = "/validateProduct", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ActivationStatus> validateProduct() throws Exception {
		ActivationStatus status = new ActivationStatus();
		Properties prop = propertyFileHelper.loadActivationFile();
		List<ActivationDetails> activationDetails = activationDetailsRepo.findAll();
		if (activationDetails.size() > 1) {
			throw new Exception(" This key has lisenced more than onces");
		}
		if (prop.get("USER_KEY").equals(activationDetails.get(0).getActivationKey())) {
			status.setIsActive(Boolean.TRUE);
		}
		return new ResponseEntity<ActivationStatus>(status, HttpStatus.OK);
	}
}
