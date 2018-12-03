package com.logicq.reckon.service;

import java.util.List;

import com.logicq.reckon.model.RNotifierClikedStatus;

public interface RNotifierClikedStatusService {

	public void sendMessage();

	public List<RNotifierClikedStatus> clikedNotifiersDetails();

}
