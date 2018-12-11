package com.logicq.reckon.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "CLICK_EVENT_DETAILS")
public class EventDetails implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -158545868879946412L;

	@Id
	@Column(name = "SERVICE_CODE", nullable = false)
	private String serviceCode;

	@Column(name = "CLICKED_EVENT")
	private Date clickedTime;

	public String getServiceCode() {
		return serviceCode;
	}

	public void setServiceCode(String serviceCode) {
		this.serviceCode = serviceCode;
	}

	public Date getClickedTime() {
		return clickedTime;
	}

	public void setClickedTime(Date clickedTime) {
		this.clickedTime = clickedTime;
	}

}
