package com.logicq.reckon.vo;

import java.io.Serializable;

public class EventVO implements Serializable {

	private Long eventid;
	private Long status;

	public Long getEventid() {
		return eventid;
	}

	public void setEventid(Long eventid) {
		this.eventid = eventid;
	}

	public Long getStatus() {
		return status;
	}

	public void setStatus(Long status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "EventVO [eventid=" + eventid + ", status=" + status + "]";
	}

}
