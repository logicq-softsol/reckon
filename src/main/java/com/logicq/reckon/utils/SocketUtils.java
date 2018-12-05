package com.logicq.reckon.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
public class SocketUtils {

	@Autowired
	private SimpMessagingTemplate template;

	@Async
	public void confirmTableNotification() {
		this.template.convertAndSend("/user/host/table/", "");
	}

}
