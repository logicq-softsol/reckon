package com.logicq.reckon.service;

import java.util.List;

import com.logicq.reckon.model.ServiceDetails;

public interface ServiceDetailsService {

	List<ServiceDetails> getAllServicesDetails();

	List<ServiceDetails> saveServicesDetails(ServiceDetails serviceDetails);

	List<ServiceDetails> deleteServicesDetails(ServiceDetails serviceDetails);
	
	ServiceDetails servicesDetailsForCode(Long code);
	
	ServiceDetails servicesDetailsForName(String name);

}
