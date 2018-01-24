package com.logicq.reckon.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "TABLE_INVENTORY")
public class TableInventory implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1658358082519357065L;

	@Id
	@Column(name = "TABLE_ID", nullable = false)
	private Long tableid;

	@Column(name = "DEVICE_ID")
	private Long deviceid;

	@Column(name = "COMMENTS")
	private String comments;

	public Long getTableid() {
		return tableid;
	}

	public void setTableid(Long tableid) {
		this.tableid = tableid;
	}

	public Long getDeviceid() {
		return deviceid;
	}

	public void setDeviceid(Long deviceid) {
		this.deviceid = deviceid;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	@Override
	public String toString() {
		return "TableInventory [tableid=" + tableid + ", deviceid=" + deviceid + ", comments=" + comments + "]";
	}
	
	
	

}
