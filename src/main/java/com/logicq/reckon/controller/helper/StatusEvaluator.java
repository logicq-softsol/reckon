package com.logicq.reckon.controller.helper;

import java.time.Duration;
import java.time.Instant;
import java.util.Date;

import org.springframework.stereotype.Component;

@Component
public class StatusEvaluator {

	public String getStatusCodeForTime(Date startdate, Instant end) {
		Instant start = startdate.toInstant();
		Duration timeElapsed = Duration.between(start, end);

		if (timeElapsed.getSeconds() > 300) {
			System.out.println(" Duration Gap Time : " + timeElapsed.getSeconds() + " Type : " + "RSC");
			return "SRC";
		} else if (timeElapsed.toMinutes() > 180 && timeElapsed.getSeconds() < 300) {
			System.out.println(" Duration Gap Time : " + timeElapsed.getSeconds() + " Type : " + "RSM");
			return "SRM";
		} else {
			System.out.println(" Duration Gap Time : " + timeElapsed.getSeconds() + " Type : " + "RS");
			return "SR";
		}

	}

}
