package com.logicq.reckon.repository;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.logicq.reckon.model.ServiceDetails;

@Transactional
public interface ServiceQueryRepository {

	List<ServiceDetails> allServiceDetails();

	ServiceDetails getServiceDetailsAccordingToServiceCode(Long serviceCode);

	ServiceDetails getServiceDetailsAccordingToServiceName(String serviceName);
}
