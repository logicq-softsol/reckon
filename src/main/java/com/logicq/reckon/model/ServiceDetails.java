package com.logicq.reckon.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "SERVICE_DETAILS")
public class ServiceDetails implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 216015083415993815L;

	@Id
	@Column(name = "ID", nullable = false)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "NAME")
	private String servicename;

	@Column(name = "CODE")
	private Long servicecode;

	@Column(name = "THRESHOLD")
	private Long threshold;

	@Column(name = "ICON_NAME")
	private String iconName;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getServicename() {
		return servicename;
	}

	public void setServicename(String servicename) {
		this.servicename = servicename;
	}

	public Long getServicecode() {
		return servicecode;
	}

	public void setServicecode(Long servicecode) {
		this.servicecode = servicecode;
	}

	public Long getThreshold() {
		return threshold;
	}

	public void setThreshold(Long threshold) {
		this.threshold = threshold;
	}

	public String getIconName() {
		return iconName;
	}

	public void setIconName(String iconName) {
		this.iconName = iconName;
	}

	@Override
	public String toString() {
		return "ServiceDetails [id=" + id + ", servicename=" + servicename + ", servicecode=" + servicecode
				+ ", threshold=" + threshold + ", iconName=" + iconName + "]";
	}

	

}
