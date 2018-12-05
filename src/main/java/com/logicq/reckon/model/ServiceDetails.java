package com.logicq.reckon.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "SERVICES")
public class ServiceDetails extends AttributeDetails implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 216015083415993815L;

	@Id
	@Column(name = "SERVICE_ID", nullable = false)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long serviceId;

	@Column(name = "CODE")
	private Long serviceCode;

	@Column(name = "ICON")
	private String iconUrl;

	public Long getServiceId() {
		return serviceId;
	}

	public void setServiceId(Long serviceId) {
		this.serviceId = serviceId;
	}

	public Long getServiceCode() {
		return serviceCode;
	}

	public void setServiceCode(Long serviceCode) {
		this.serviceCode = serviceCode;
	}

	public String getIconUrl() {
		return iconUrl;
	}

	public void setIconUrl(String iconUrl) {
		this.iconUrl = iconUrl;
	}

}
