package com.logicq.reckon.schedule;

import java.time.Instant;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import com.logicq.reckon.controller.helper.StatusEvaluator;
import com.logicq.reckon.model.TableStatus;
import com.logicq.reckon.service.TableStatusService;

@Configuration
@EnableScheduling
public class TableStatusSchedule {

	@Autowired
	SimpMessagingTemplate brokerMessagingTemplate;

	@Autowired
	TableStatusService tableStatusService;

	@Autowired
	StatusEvaluator statusEvaluator;

	@Scheduled(fixedDelay = 60000)
	public void scheduleFixedDelayTask() {
		List<TableStatus> tablelist = tableStatusService.getBusyTables();
		System.out.println(" Busy Table List : "+tablelist.size() );
		if (!tablelist.isEmpty()) {
			Map<Long, String> result = new HashMap();
			Instant end = Instant.now();
			tablelist.stream().forEach((data) -> {
				String statusCode = statusEvaluator.getStatusCodeForTime(data.getDate(), end);
				System.out.println(" Status Code : "+statusCode );
				result.put(data.getTableid(), statusCode);
			});

			brokerMessagingTemplate.convertAndSend("/topics/event", result);
		}

	}

}
