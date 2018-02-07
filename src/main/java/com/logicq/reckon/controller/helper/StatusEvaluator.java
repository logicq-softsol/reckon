package com.logicq.reckon.controller.helper;

import java.time.Duration;
import java.time.Instant;

import org.springframework.stereotype.Component;

import com.logicq.reckon.vo.ServiceRequestVO;

@Component
public class StatusEvaluator {

	public String getStatusCodeForTime(ServiceRequestVO serviceReq, Instant now) {
		Instant start = serviceReq.getRequestTime().toInstant();
		Duration timeElapsed = Duration.between(start, now);
		long time = timeElapsed.getSeconds();
		serviceReq.setWaitTime(timeElapsed.toMinutes());
		if (time < 119l) {
			System.out.println(" Duration Gap Time : " + time + " Type : " + "SR");
			return "SR";
		} else if (time >= 120l && time <= 299l) {
			System.out.println(" Duration Gap Time : " + time + " Type : " + "SRM");
			return "SRM";
		} else {
			System.out.println(" Duration Gap Time : " + time + " Type : " + "SRC");
			return "SRC";
		}

	}

}
