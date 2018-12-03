package com.logicq.reckon.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "SERVICES")
public class ServiceConfig implements Serializable {

	@Id
	@Column(name = "SERVICE_NAME", nullable = false)
	private String serviceName;

	@Column(name = "SERVICE_CODE", nullable = false)
	private String iconURL;

	public String getServiceName() {
		return serviceName;
	}

	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}

	public String getIconURL() {
		return iconURL;
	}

	public void setIconURL(String iconURL) {
		this.iconURL = iconURL;
	}

	@Override
	public String toString() {
		return "ServiceConfig [serviceName=" + serviceName + ", iconURL=" + iconURL + "]";
	}

	
}
