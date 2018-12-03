package com.logicq.reckon.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "RNOTIFY_CLICK_STATUS")
public class RNotifierClikedStatus {

	@Id
	@Column(name = "CLICK_ID", nullable = false)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long clickId;

	@Column(name = "LINKED_ID", nullable = false)
	private Long linkedId;

	@Column(name = "RNOTIFY_CODE", nullable = false)
	private Long rnotifyCode;

	@Column(name = "LINKED_FOR", nullable = false)
	private String linkedType;

	@Column(name = "RNOTIY_ID")
	private Long notifiers;

	@Column(name = "CLICK_STATUS")
	private String clickStatus;

	@Column(name = "STATUS_COLOR_CODE")
	private String colorCode;

	@Column(name = "CLICK_STATUS_ICON")
	private String clickStatusIcon;

	@Column(name = "SERVICE_NAME")
	private String serviceName;

	@Column(name = "CLICKED_TIME")
	private Date clickTime;

	public Long getClickId() {
		return clickId;
	}

	public void setClickId(Long clickId) {
		this.clickId = clickId;
	}

	public Long getLinkedId() {
		return linkedId;
	}

	public void setLinkedId(Long linkedId) {
		this.linkedId = linkedId;
	}

	public Long getRnotifyCode() {
		return rnotifyCode;
	}

	public void setRnotifyCode(Long rnotifyCode) {
		this.rnotifyCode = rnotifyCode;
	}

	public String getLinkedType() {
		return linkedType;
	}

	public void setLinkedType(String linkedType) {
		this.linkedType = linkedType;
	}

	public Long getNotifiers() {
		return notifiers;
	}

	public void setNotifiers(Long notifiers) {
		this.notifiers = notifiers;
	}

	public String getClickStatus() {
		return clickStatus;
	}

	public void setClickStatus(String clickStatus) {
		this.clickStatus = clickStatus;
	}

	public String getClickStatusIcon() {
		return clickStatusIcon;
	}

	public void setClickStatusIcon(String clickStatusIcon) {
		this.clickStatusIcon = clickStatusIcon;
	}

	public String getServiceName() {
		return serviceName;
	}

	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}

	public Date getClickTime() {
		return clickTime;
	}

	public void setClickTime(Date clickTime) {
		this.clickTime = clickTime;
	}

	public String getColorCode() {
		return colorCode;
	}

	public void setColorCode(String colorCode) {
		this.colorCode = colorCode;
	}

	@Override
	public String toString() {
		return "RNotifierClikedStatus [clickId=" + clickId + ", linkedId=" + linkedId + ", rnotifyCode=" + rnotifyCode
				+ ", linkedType=" + linkedType + ", notifiers=" + notifiers + ", clickStatus=" + clickStatus
				+ ", colorCode=" + colorCode + ", clickStatusIcon=" + clickStatusIcon + ", serviceName=" + serviceName
				+ ", clickTime=" + clickTime + "]";
	}

	
	
}
