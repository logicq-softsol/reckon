package com.logicq.reckon.vo;

import java.io.Serializable;
import java.util.Map;

import com.logicq.reckon.model.UserDetails;

public class LoginVO implements Serializable {
	
	private UserDetails user;
	private Map<Long, String> tableDetails;
	
	public UserDetails getUser() {
		return user;
	}
	public void setUser(UserDetails user) {
		this.user = user;
	}
	public Map<Long, String> getTableDetails() {
		return tableDetails;
	}
	public void setTableDetails(Map<Long, String> tableDetails) {
		this.tableDetails = tableDetails;
	}
	
	@Override
	public String toString() {
		return "LoginVO [user=" + user + ", tableDetails=" + tableDetails + "]";
	}
	
	

}
