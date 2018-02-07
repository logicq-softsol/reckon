package com.logicq.reckon.vo;

import java.util.Date;

public class ServiceRequestVO {

	private Date requestTime;
	private String status;
	private long waitTime;

	public Date getRequestTime() {
		return requestTime;
	}

	public void setRequestTime(Date requestTime) {
		this.requestTime = requestTime;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public long getWaitTime() {
		return waitTime;
	}

	public void setWaitTime(long waitTime) {
		this.waitTime = waitTime;
	}

	@Override
	public String toString() {
		return "ServiceRequestVO [requestTime=" + requestTime + ", status=" + status + ", waitTime=" + waitTime + "]";
	}

}
