package com.logicq.reckon.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.logicq.reckon.model.ServiceDetails;

@Repository
@Transactional(readOnly = true)
public class ServiceRepositoryImpl implements ServiceQueryRepository {

	@PersistenceContext
	EntityManager entityManager;
	
	@Override
	public List<ServiceDetails> allServiceDetails() {
		Query query = entityManager.createQuery("SELECT SD FROM ServiceDetails SD",
				ServiceDetails.class);
		return query.getResultList();
	}

	@Override
	public ServiceDetails getServiceDetailsAccordingToServiceCode(Long serviceCode) {
		Query query = entityManager.createQuery("SELECT SD FROM ServiceDetails SD WHERE SD.servicecode="+serviceCode+";",
				ServiceDetails.class);
		return (ServiceDetails) query.getSingleResult();
	}

	@Override
	public ServiceDetails getServiceDetailsAccordingToServiceName(String serviceName) {
		Query query = entityManager.createQuery("SELECT SD FROM ServiceDetails SD WHERE SD.servicename='"+serviceName+"';",
				ServiceDetails.class);
		return (ServiceDetails) query.getSingleResult();
	}

}
