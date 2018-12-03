package com.logicq.reckon.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.logicq.reckon.controller.helper.EventIdentifier;
import com.logicq.reckon.controller.helper.Status;
import com.logicq.reckon.model.LinkedRNotifyDetails;
import com.logicq.reckon.model.LinkedService;
import com.logicq.reckon.model.RNotifierClikedStatus;
import com.logicq.reckon.model.ServiceConfig;
import com.logicq.reckon.model.Threshold;
import com.logicq.reckon.repository.ClickedRnotifyDetailsRepository;
import com.logicq.reckon.repository.LinkedRnotifyDetailsRepository;
import com.logicq.reckon.repository.LinkedServiceRepository;
import com.logicq.reckon.repository.ServiceConfigRepository;
import com.logicq.reckon.service.RNotifierClikedStatusService;
import com.logicq.reckon.threshold.ThresholdRepository;
import com.logicq.reckon.vo.RNotifierCliked;

@RestController
@EnableAutoConfiguration
@RequestMapping("/api/rnotify")
public class RNotifyController {

	@Autowired
	LinkedRnotifyDetailsRepository linkedRnotifyDetailsRepository;

	@Autowired
	ClickedRnotifyDetailsRepository clickedRnotifyDetailsRepository;

	@Autowired
	ThresholdRepository thresholdRepository;

	@Autowired
	LinkedServiceRepository linkedServiceRepository;

	@Autowired
	ServiceConfigRepository serviceConfigRepository;

	@Autowired
	RNotifierClikedStatusService rNotifierClikedStatusService;

	@Autowired
	SimpMessagingTemplate brokerMessagingTemplate;

	@RequestMapping(value = "/link", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<LinkedRNotifyDetails>> getAllLinkedNotifiers() {
		return new ResponseEntity<List<LinkedRNotifyDetails>>(linkedRnotifyDetailsRepository.findAll(), HttpStatus.OK);
	}

	@RequestMapping(value = "/link", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<LinkedRNotifyDetails>> linkRNotifyDetails(
			@RequestBody LinkedRNotifyDetails linkedRNotifyDetails) {
		if (null != linkedRNotifyDetails.getLinkedId() && null != linkedRNotifyDetails.getNotifiers()) {
			linkedRNotifyDetails.setStatus(Status.LINKED.name());
		} else {
			linkedRNotifyDetails.setStatus(Status.NOT_LINKED.name());
		}
		linkedRnotifyDetailsRepository.save(linkedRNotifyDetails);
		return new ResponseEntity<List<LinkedRNotifyDetails>>(linkedRnotifyDetailsRepository.findAll(), HttpStatus.OK);
	}

	@RequestMapping(value = "/link", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<LinkedRNotifyDetails>> updateRNotifyDetails(
			@RequestBody LinkedRNotifyDetails linkedRNotifyDetails) {
		if (null != linkedRNotifyDetails.getLinkedId() && null != linkedRNotifyDetails.getNotifiers()) {
			linkedRNotifyDetails.setStatus(Status.LINKED.name());
		} else {
			linkedRNotifyDetails.setStatus(Status.NOT_LINKED.name());
		}
		linkedRnotifyDetailsRepository.save(linkedRNotifyDetails);
		return new ResponseEntity<List<LinkedRNotifyDetails>>(linkedRnotifyDetailsRepository.findAll(), HttpStatus.OK);
	}

	@RequestMapping(value = "/link/{linkedId}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<LinkedRNotifyDetails>> updateServiceCode(@RequestParam Long linkedId) {
		linkedRnotifyDetailsRepository.delete(linkedId);
		return new ResponseEntity<List<LinkedRNotifyDetails>>(linkedRnotifyDetailsRepository.findAll(), HttpStatus.OK);
	}

	/*
	 * @RequestMapping(value = "/click", method = RequestMethod.POST, produces =
	 * MediaType.APPLICATION_JSON_VALUE, consumes =
	 * MediaType.APPLICATION_JSON_VALUE) public
	 * ResponseEntity<RNotifierClikedStatus> clickRNotify(@RequestBody
	 * RNotifierCliked rNotifierCliked) { List<RNotifierClikedStatus>
	 * rnotifyList = clickedRnotifyDetailsRepository
	 * .findByNotifiers(rNotifierCliked.getReckonId()); RNotifierClikedStatus
	 * rnotifysttatus = null; if (null == rnotifysttatus ||
	 * rnotifyList.isEmpty()) { rnotifysttatus = new RNotifierClikedStatus();
	 * List<LinkedRNotifyDetails> linkedRnotifyDetailsDetails =
	 * linkedRnotifyDetailsRepository
	 * .findByNotifiers(rNotifierCliked.getReckonId());
	 * 
	 * LinkedService linkedService =
	 * linkedServiceRepository.findOne(rNotifierCliked.getRnotifyCode());
	 * Threshold thresold =
	 * thresholdRepository.findByName(EventIdentifier.DEFAULT.getvalue());
	 * ServiceConfig serviceConfig =
	 * serviceConfigRepository.findOne(linkedService.getServiceName());
	 * 
	 * // Set Notify Details if (!linkedRnotifyDetailsDetails.isEmpty()) {
	 * rnotifysttatus.setLinkedId(linkedRnotifyDetailsDetails.get(0).getLinkedId
	 * ()); rnotifysttatus.setLinkedType(linkedRnotifyDetailsDetails.get(0).
	 * getLinkedType());
	 * rnotifysttatus.setNotifiers(linkedRnotifyDetailsDetails.get(0).
	 * getNotifiers()); }
	 * rnotifysttatus.setRnotifyCode(linkedService.getServiceCode());
	 * rnotifysttatus.setServiceName(linkedService.getServiceName());
	 * rnotifysttatus.setClickStatusIcon(thresold.getName());
	 * rnotifysttatus.setClickStatusIcon(serviceConfig.getIconURL());
	 * rnotifysttatus.setClickTime(new Date());
	 * clickedRnotifyDetailsRepository.save(rnotifysttatus);
	 * rNotifierClikedStatusService.sendMessage(); } return new
	 * ResponseEntity<RNotifierClikedStatus>(rnotifysttatus, HttpStatus.OK); }
	 */

	@RequestMapping(value = "/click/{serviceCode}", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<RNotifierClikedStatus> clickRNotify(@PathVariable Long serviceCode) {
		List<RNotifierClikedStatus> rnotifyList = clickedRnotifyDetailsRepository.findByRnotifyCode(serviceCode);
		if (null == rnotifyList || rnotifyList.isEmpty()) {
			RNotifierClikedStatus rnotifysttatus = new RNotifierClikedStatus();
			LinkedService linkedService = linkedServiceRepository.findByServiceCode(serviceCode);

			LinkedRNotifyDetails linkedRnotifyDetailsDetails = linkedRnotifyDetailsRepository
					.findByNotifiers(linkedService.getReckonID());

			Threshold thresold = thresholdRepository.findByName(EventIdentifier.DEFAULT.getvalue());
			ServiceConfig serviceConfig = serviceConfigRepository.findOne(linkedService.getServiceName());

			// Set Notify Details
			if (null != linkedRnotifyDetailsDetails) {
				rnotifysttatus.setLinkedId(linkedRnotifyDetailsDetails.getLinkedId());
				rnotifysttatus.setLinkedType(linkedRnotifyDetailsDetails.getLinkedType());
				rnotifysttatus.setNotifiers(linkedRnotifyDetailsDetails.getNotifiers());
			}
			rnotifysttatus.setRnotifyCode(linkedService.getServiceCode());
			rnotifysttatus.setServiceName(linkedService.getServiceName());
			rnotifysttatus.setClickStatusIcon(thresold.getName());
			rnotifysttatus.setClickStatusIcon(serviceConfig.getIconURL());
			rnotifysttatus.setClickTime(new Date());
			clickedRnotifyDetailsRepository.save(rnotifysttatus);
			rNotifierClikedStatusService.sendMessage();
			return new ResponseEntity<RNotifierClikedStatus>(rnotifysttatus, HttpStatus.OK);
		}
		return new ResponseEntity<RNotifierClikedStatus>(new RNotifierClikedStatus(), HttpStatus.OK);
	}

	@RequestMapping(value = "/clicked", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Map<Long, RNotifierClikedStatus>> clickedNotifiers() {
		Map<Long, RNotifierClikedStatus> rnotifyMaped = rNotifierClikedStatusService.clikedNotifiersDetails().stream()
				.collect(Collectors.toMap(RNotifierClikedStatus::getLinkedId, Function.identity()));
		return new ResponseEntity<Map<Long, RNotifierClikedStatus>>(rnotifyMaped, HttpStatus.OK);
	}

}
