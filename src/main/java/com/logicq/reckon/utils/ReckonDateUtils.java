package com.logicq.reckon.utils;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Component
public class ReckonDateUtils {

	@Autowired
	Environment env;

	static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");

	public Date findTodayStartDate() {
		LocalDateTime startDate = LocalDateTime.now(ZoneId.of(env.getProperty("eazdine.date.zoneid"))).with(LocalTime.MIN);
		return Date.from(startDate.atZone(ZoneId.of(env.getProperty("eazdine.date.zoneid"))).toInstant());

	}

	public Date find2mrEndDate() {
		LocalDateTime endDateTime = LocalDateTime.now(ZoneId.of(env.getProperty("eazdine.date.zoneid"))).plusDays(1)
				.with(LocalTime.MAX);
		return Date.from(endDateTime.atZone(ZoneId.of(env.getProperty("eazdine.date.zoneid"))).toInstant());

	}

	public Date currentDate() {
		LocalDateTime currentTime = LocalDateTime.now(ZoneId.of(env.getProperty("eazdine.date.zoneid")));
		return Date.from(currentTime.atZone(ZoneId.of(env.getProperty("eazdine.date.zoneid"))).toInstant());
	}

	public String getTodayDay() {
		return LocalDate.now(ZoneId.of(env.getProperty("eazdine.date.zoneid"))).getDayOfWeek().name();
	}

	public Date generateHostMaxValidityDate(Date hostDate) {
		LocalDateTime currentLocalDate = LocalDateTime.ofInstant(hostDate.toInstant(),
				ZoneId.of(env.getProperty("eazdine.date.zoneid")));
		LocalDateTime maxValidityLocalDate = currentLocalDate.plusHours(Integer.valueOf(env.getProperty("eazdine.host.validity.hour")) );
		return Date.from(maxValidityLocalDate.atZone(ZoneId.of(env.getProperty("eazdine.date.zoneid"))).toInstant());
	}

}
