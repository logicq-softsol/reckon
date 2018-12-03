package com.logicq.reckon.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "LINKED_SERVICES")
public class LinkedService {

	@Id
	@Column(name = "SERVICE_CODE")
	private Long serviceCode;

	@Column(name = "SERVICE_NAME")
	private String serviceName;

	@Column(name = "RECKON_ID")
	private Long reckonID;

	public Long getServiceCode() {
		return serviceCode;
	}

	public void setServiceCode(Long serviceCode) {
		this.serviceCode = serviceCode;
	}

	public String getServiceName() {
		return serviceName;
	}

	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}

	public Long getReckonID() {
		return reckonID;
	}

	public void setReckonID(Long reckonID) {
		this.reckonID = reckonID;
	}

	@Override
	public String toString() {
		return "LinkedService [serviceCode=" + serviceCode + ", serviceName=" + serviceName + ", reckonID=" + reckonID
				+ "]";
	}
	
	
	
}
