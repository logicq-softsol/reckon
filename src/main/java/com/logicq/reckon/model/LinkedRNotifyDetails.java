package com.logicq.reckon.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "LINKED_RNOTIFY")
public class LinkedRNotifyDetails implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1658358082519357065L;

	@Id
	@Column(name = "LINKED_ID", nullable = false)
	private Long linkedId;
	

	@Column(name = "LINKED_FOR", nullable = false)
	private String linkedType;

	@Column(name = "LINKED_ICON", nullable = false)
	private String iconURL;
	
	@Column(name = "LINKED_NAME")
	private String linkedName;

	@Column(name = "LINKED_STATUS")
	private String status;

	@Column(name = "RNOTIY_ID")
	private Long notifiers;

	public Long getLinkedId() {
		return linkedId;
	}

	public void setLinkedId(Long linkedId) {
		this.linkedId = linkedId;
	}

	public String getLinkedType() {
		return linkedType;
	}

	public void setLinkedType(String linkedType) {
		this.linkedType = linkedType;
	}

	public String getIconURL() {
		return iconURL;
	}

	public void setIconURL(String iconURL) {
		this.iconURL = iconURL;
	}

	public String getLinkedName() {
		return linkedName;
	}

	public void setLinkedName(String linkedName) {
		this.linkedName = linkedName;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Long getNotifiers() {
		return notifiers;
	}

	public void setNotifiers(Long notifiers) {
		this.notifiers = notifiers;
	}

	
}
