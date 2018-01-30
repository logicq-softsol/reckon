package com.logicq.reckon.schedule;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import com.logicq.reckon.model.TableStatus;
import com.logicq.reckon.service.TableStatusService;

@Configuration
@EnableScheduling
public class TableStatusSchedule {

	@Autowired
	SimpMessagingTemplate brokerMessagingTemplate;

	@Autowired
	TableStatusService tableStatusService;

	@Scheduled(fixedDelay = 60000)
	public void scheduleFixedDelayTask() {
		List<TableStatus> tablelist = tableStatusService.getBusyTables();
		if (!tablelist.isEmpty()) {
			Map<Long, String> result = tablelist.stream()
					.collect(Collectors.toMap(TableStatus::getTableid, TableStatus::getStatus));
			brokerMessagingTemplate.convertAndSend("/topics/event", result);
		}

	}

}
