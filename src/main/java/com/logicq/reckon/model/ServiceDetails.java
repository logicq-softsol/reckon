package com.logicq.reckon.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "SERVICES")
public class ServiceDetails implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 216015083415993815L;

	@Id
	@Column(name = "SERVICE_ID", nullable = false)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long serviceId;

	@Column(name = "NAME")
	private String serviceName;

	@Column(name = "CODE")
	private Long serviceCode;

	@Column(name = "ICON")
	private String iconUrl;

	@ManyToMany(cascade = { CascadeType.ALL })
	@JoinTable(name = "SERVICE_THRESHOLD", joinColumns = { @JoinColumn(name = "serviceId") }, inverseJoinColumns = {
			@JoinColumn(name = "thresholdId") })
	private Set<Threshold> thresholds = new HashSet<>();

	@ManyToMany(mappedBy = "services")
	private Set<Department> departments = new HashSet<>();

	public Long getServiceId() {
		return serviceId;
	}

	public void setServiceId(Long serviceId) {
		this.serviceId = serviceId;
	}

	public String getServiceName() {
		return serviceName;
	}

	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
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

	public Set<Threshold> getThresholds() {
		return thresholds;
	}

	public void setThresholds(Set<Threshold> thresholds) {
		this.thresholds = thresholds;
	}

	public Set<Department> getDepartments() {
		return departments;
	}

	public void setDepartments(Set<Department> departments) {
		this.departments = departments;
	}
	
	
	
	

}
