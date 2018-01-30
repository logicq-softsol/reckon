package com.logicq.reckon.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TABLE_STATUS")
public class TableStatus implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 364840974712227316L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Long id;

	@Column(name = "tableid", nullable = false)
	private Long tableid;

	@Column(name = "date", nullable = false)
	private Date date;

	@Column(name = "status", nullable = false)
	private String status;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getTableid() {
		return tableid;
	}

	public void setTableid(Long tableid) {
		this.tableid = tableid;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "TableStatus [id=" + id + ", tableid=" + tableid + ", date=" + date + ", status=" + status + "]";
	}

	

}
