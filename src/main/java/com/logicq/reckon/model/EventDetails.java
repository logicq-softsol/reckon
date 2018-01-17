package com.logicq.reckon.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "EVENT_DETAILS")
public class EventDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Long id;
	
	@Column(name = "eventid")
	private Long eventid;

	@Column(name = "linked_id")
	private Integer linkedid;

	@Column(name = "linked_name")
	private String linkedname;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getEventid() {
		return eventid;
	}

	public void setEventid(Long eventid) {
		this.eventid = eventid;
	}

	public Integer getLinkedid() {
		return linkedid;
	}

	public void setLinkedid(Integer linkedid) {
		this.linkedid = linkedid;
	}

	public String getLinkedname() {
		return linkedname;
	}

	public void setLinkedname(String linkedname) {
		this.linkedname = linkedname;
	}

	@Override
	public String toString() {
		return "EventDetails [id=" + id + ", eventid=" + eventid + ", linkedid=" + linkedid + ", linkedname="
				+ linkedname + "]";
	}

	
	
}
