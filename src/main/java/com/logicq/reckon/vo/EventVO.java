package com.logicq.reckon.vo;

import java.io.Serializable;

public class EventVO implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5006963136101182905L;
	
	private boolean isActive;
	private String tableNo;
	public boolean isActive() {
		return isActive;
	}
	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}
	public String getTableNo() {
		return tableNo;
	}
	public void setTableNo(String tableNo) {
		this.tableNo = tableNo;
	}
	
	@Override
	public String toString() {
		return "EventVO [isActive=" + isActive + ", tableNo=" + tableNo + "]";
	}
	
	
	
	
	
	

}
