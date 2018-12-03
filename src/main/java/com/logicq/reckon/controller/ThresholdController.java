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
import org.springframework.web.bind.annotation.RestController;

import com.logicq.reckon.model.Threshold;
import com.logicq.reckon.threshold.ThresholdRepository;

@RestController
@EnableAutoConfiguration
@RequestMapping("/api/reckon")
public class ThresholdController {

	@Autowired
	ThresholdRepository thresholdRepository;

	@RequestMapping(value = "/thresolds", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Threshold>> getAllThresolds() {
		return new ResponseEntity<List<Threshold>>(thresholdRepository.findAll(), HttpStatus.OK);
	}

	@RequestMapping(value = "/threshold", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Threshold>> addThreshold(@RequestBody Threshold thresold) {
		thresholdRepository.save(thresold);
		return new ResponseEntity<List<Threshold>>(thresholdRepository.findAll(), HttpStatus.OK);
	}

	@RequestMapping(value = "/threshold", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Threshold>> updateThreshold(@RequestBody Threshold thresold) {
		thresholdRepository.save(thresold);
		return new ResponseEntity<List<Threshold>>(thresholdRepository.findAll(), HttpStatus.OK);
	}

	@RequestMapping(value = "/threshold/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Threshold>> removeThreashold(@PathVariable Long id) {
		Threshold thres = new Threshold();
		thres.setId(id);
		thresholdRepository.delete(thres);
		return new ResponseEntity<List<Threshold>>(thresholdRepository.findAll(), HttpStatus.OK);
	}

}
