package com.logicq.reckon.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "EVENT")
public class Event implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 364840974712227316L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Long id;

	@Column(name = "eventid", nullable = false)
	private String eventId;

	@Column(name = "date", nullable = false)
	private String date;

	@Column(name = "status", nullable = false)
	private boolean isActive;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEventId() {
		return eventId;
	}

	public void setEventId(String eventId) {
		this.eventId = eventId;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	@Override
	public String toString() {
		return "Event [id=" + id + ", eventId=" + eventId + ", date=" + date + ", isActive=" + isActive + "]";
	}


}
