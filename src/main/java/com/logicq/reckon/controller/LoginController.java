package com.logicq.reckon.controller;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ValidationException;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.logicq.reckon.exception.SucessMessage;
import com.logicq.reckon.model.ActivationDetails;
import com.logicq.reckon.model.LoginDetails;
import com.logicq.reckon.model.User;
import com.logicq.reckon.repository.LoginDetailsRepo;
import com.logicq.reckon.repository.ProductActivationRepo;
import com.logicq.reckon.repository.UserDetailsRepo;
import com.logicq.reckon.security.JwtTokenProvider;
import com.logicq.reckon.utils.ReckonDateUtils;
import com.logicq.reckon.vo.ActivationVO;

@RestController
@EnableAutoConfiguration
@RequestMapping("/api/patner")
public class LoginController {

	@Autowired
	UserDetailsRepo userDetailsRepo;

	@Autowired
	LoginDetailsRepo loginDetailsRepo;

	@Autowired
	ProductActivationRepo productActivationRepo;

	@Autowired
	AuthenticationManager authenticationManager;

	@Autowired
	PasswordEncoder passwordEncoder;

	@Autowired
	JwtTokenProvider tokenProvider;

	@Autowired
	ReckonDateUtils reckonDateUtils;

	@Autowired
	HttpServletRequest context;

	@RequestMapping(value = "/activateProduct", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<SucessMessage> registerPartner(@RequestBody ActivationVO activateDetails) throws Exception {
		if (null != activateDetails && !StringUtils.isEmpty(activateDetails.getLicense())
				&& !StringUtils.isEmpty(activateDetails.getUser().getUserName())) {
			ActivationDetails activationDetails = new ActivationDetails();
			activationDetails.setActivationDate(reckonDateUtils.currentDate());
			activationDetails.setActivationKey(passwordEncoder.encode(activateDetails.getLicense()));
			activationDetails.setLicenseKey(activateDetails.getLicense());
			activationDetails.setExpiryDate(activateDetails.getExpiryDate());
			activationDetails.setProductName(activateDetails.getProductName());
			activationDetails.setProductStatus(activateDetails.getProductStatus());
			activationDetails.setProductVersion(activateDetails.getProductVersion());

			User userDetails = new User();
			userDetails.setUserName(activateDetails.getUser().getUserName());
			userDetails.setAddress(activateDetails.getUser().getAddress());
			userDetails.setCity(activateDetails.getUser().getCity());
			userDetails.setCountry(activateDetails.getUser().getCountry());
			userDetails.setEmail(activateDetails.getUser().getEmail());
			userDetails.setFirstname(activateDetails.getUser().getFirstname());
			userDetails.setLastname(activateDetails.getUser().getLastname());
			userDetails.setMobileno(activateDetails.getUser().getMobileno());
			userDetails.setPostalcode(activateDetails.getUser().getPostalcode());

			LoginDetails loginDetails = new LoginDetails();
			loginDetails.setLoginStatus("IN_ACTIVE");
			loginDetails.setUserName(activateDetails.getUser().getUserName());
			loginDetails.setPassword(passwordEncoder.encode(activateDetails.getUser().getPassword()));

			productActivationRepo.save(activationDetails);
			userDetailsRepo.save(userDetails);
			loginDetailsRepo.save(loginDetails);

			return new ResponseEntity<SucessMessage>(
					new SucessMessage(reckonDateUtils.currentDate(), "SUCESS", "Product Register Sucessfully"),
					HttpStatus.OK);
		}

		return new ResponseEntity<SucessMessage>(
				new SucessMessage(reckonDateUtils.currentDate(), "ERROR", "Unable to Register Product"),
				HttpStatus.EXPECTATION_FAILED);
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<SucessMessage> login(@RequestBody LoginDetails login) throws Exception {
		if (!StringUtils.isEmpty(login.getUserName())) {
			Authentication authentication = authenticationManager
					.authenticate(new UsernamePasswordAuthenticationToken(login.getUserName(), login.getPassword()));

			SecurityContextHolder.getContext().setAuthentication(authentication);
			if (SecurityContextHolder.getContext().getAuthentication().isAuthenticated()) {
				String jwt = tokenProvider.generateToken(authentication);
				LoginDetails loginDetails = loginDetailsRepo.findByUserName(login.getUserName());
				if (null != loginDetails) {
					loginDetails.setLoginTime(reckonDateUtils.currentDate());
					loginDetails.setLoginStatus("ACTIVE");
					loginDetailsRepo.save(loginDetails);
				}
				return new ResponseEntity<SucessMessage>(
						new SucessMessage(reckonDateUtils.currentDate(), jwt, "acess_token"), HttpStatus.OK);
			} else {
				throw new ValidationException("ERROR-LOGIN");
			}
		}
		return new ResponseEntity<SucessMessage>(
				new SucessMessage(reckonDateUtils.currentDate(), "Invalid login", "ERROR"), HttpStatus.BAD_REQUEST);
	}

	@RequestMapping(value = "/logout", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<SucessMessage> logout(@RequestBody User user) throws Exception {
		if (SecurityContextHolder.getContext().getAuthentication().isAuthenticated()) {
			String userName = tokenProvider.getUserIdFromJWT(tokenProvider.getJwtFromRequest(context));
			LoginDetails loginDetails = loginDetailsRepo.findByUserName(userName);
			if (null != loginDetails) {
				loginDetails.setLoginStatus("IN_ACTIVE");
				loginDetailsRepo.save(loginDetails);
			}
			return new ResponseEntity<SucessMessage>(
					new SucessMessage(reckonDateUtils.currentDate(), "Logout Sucess ", "SLOGOUT"), HttpStatus.OK);
		}
		return new ResponseEntity<SucessMessage>(
				new SucessMessage(reckonDateUtils.currentDate(), "Unable to logout ", "ERROR"), HttpStatus.BAD_REQUEST);
	}

}
