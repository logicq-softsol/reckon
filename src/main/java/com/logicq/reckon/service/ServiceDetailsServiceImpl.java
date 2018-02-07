package com.logicq.reckon.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import com.logicq.reckon.model.ServiceDetails;
import com.logicq.reckon.repository.ServiceRepository;

@Service
public class ServiceDetailsServiceImpl implements ServiceDetailsService {

	@Autowired
	ServiceRepository serviceRepository;

	@Override
	@Transactional
	public List<ServiceDetails> getAllServicesDetails() {
		return serviceRepository.allServiceDetails();
	}

	@Override
	@Transactional
	public List<ServiceDetails> saveServicesDetails(ServiceDetails serviceDetails) {
		serviceRepository.save(serviceDetails);
		return serviceRepository.allServiceDetails();
	}

	@Override
	@Transactional
	public List<ServiceDetails> deleteServicesDetails(ServiceDetails serviceDetails) {
		serviceRepository.delete(serviceDetails);
		return serviceRepository.allServiceDetails();
	}

	@Override
	@Transactional
	public ServiceDetails servicesDetailsForName(String name) {
		ServiceDetails servicedetails = null;
		if (!StringUtils.isEmpty(name)) {
			servicedetails = serviceRepository.getServiceDetailsAccordingToServiceName(name);
		}
		return servicedetails;
	}
	
	
	@Override
	@Transactional
	public ServiceDetails servicesDetailsForCode(Long code) {
		ServiceDetails servicedetails = null;
		if (null!=code) {
			servicedetails = serviceRepository.getServiceDetailsAccordingToServiceCode(code);
		}
		return servicedetails;
	}
}
