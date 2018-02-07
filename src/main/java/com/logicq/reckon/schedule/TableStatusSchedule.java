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
import com.logicq.reckon.vo.ServiceRequestVO;

@Configuration
@EnableScheduling
public class TableStatusSchedule {

	@Autowired
	SimpMessagingTemplate brokerMessagingTemplate;

	@Autowired
	TableStatusService tableStatusService;

	@Autowired
	StatusEvaluator statusEvaluator;

	@Scheduled(fixedDelay = 30000)
	public void scheduleFixedDelayTask() {
		List<TableStatus> tablelist = tableStatusService.getBusyTables();
		System.out.println(" Busy Table List : " + tablelist.size());
		if (!tablelist.isEmpty()) {
			Map<Long, ServiceRequestVO> result = new HashMap();
			Instant now = Instant.now();
			tablelist.stream().forEach((data) -> {
				ServiceRequestVO serviceReq = new ServiceRequestVO();
				serviceReq.setRequestTime(data.getDate());
				String statusCode = statusEvaluator.getStatusCodeForTime(serviceReq, now);
				serviceReq.setStatus(statusCode);
				result.put(data.getTableid(), serviceReq);
			});

			brokerMessagingTemplate.convertAndSend("/topics/event", result);
		}

	}

}
