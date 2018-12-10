package com.logicq.reckon.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "LINK_SERVICE")
public class LinkServiceDetails implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3241145120609088262L;

	@Id
	@Column(name = "LINK_CODE", nullable = false)
	private String linkCode;

	@Column(name = "LINK_NAME")
	private String linkName;

	@Column(name = "LINK_STATUS", nullable = false)
	private String status;

	@Column(name = "SERVICE_ID", nullable = false)
	private String serviceId;

	public String getLinkCode() {
		return linkCode;
	}

	public void setLinkCode(String linkCode) {
		this.linkCode = linkCode;
	}

	public String getLinkName() {
		return linkName;
	}

	public void setLinkName(String linkName) {
		this.linkName = linkName;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getServiceId() {
		return serviceId;
	}

	public void setServiceId(String serviceId) {
		this.serviceId = serviceId;
	}

}
