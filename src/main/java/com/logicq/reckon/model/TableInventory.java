package com.logicq.reckon.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
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
	private Long reckonid;

	@Column(name = "COMMENTS")
	private String comments;

	public Long getTableid() {
		return tableid;
	}

	public void setTableid(Long tableid) {
		this.tableid = tableid;
	}

	public Long getReckonid() {
		return reckonid;
	}

	public void setReckonid(Long reckonid) {
		this.reckonid = reckonid;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	@Override
	public String toString() {
		return "TableInventory [tableid=" + tableid + ", reckonid=" + reckonid + ", comments=" + comments + "]";
	}

	
	

}
