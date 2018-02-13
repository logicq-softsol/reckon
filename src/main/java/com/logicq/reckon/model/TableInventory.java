package com.logicq.reckon.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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

	@Column(name = "TABLE_NAME")
	private String tablename;

	@Column(name = "LINKED_STATUS")
	private String status;

	@Column(name = "ICON_PATH")
	private String iconname;
	
	@ManyToOne
    @JoinColumn(name="deptId")
	private Department department;

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

	public String getTablename() {
		return tablename;
	}

	public void setTablename(String tablename) {
		this.tablename = tablename;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getIconname() {
		return iconname;
	}

	public void setIconname(String iconname) {
		this.iconname = iconname;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}
	
	
	
		
}
