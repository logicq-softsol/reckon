package com.logicq.reckon.vo;

import java.io.Serializable;

public class ActivationStatus implements Serializable {

	private String userName;
	private String companyName;
	private Boolean isActive;
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public Boolean getIsActive() {
		return isActive;
	}
	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}
	@Override
	public String toString() {
		return "ActivationStatus [userName=" + userName + ", companyName=" + companyName + ", isActive=" + isActive
				+ "]";
	}
	
	

}
