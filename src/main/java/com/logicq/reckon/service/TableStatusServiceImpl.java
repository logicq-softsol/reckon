package com.logicq.reckon.service;

import java.time.Instant;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.logicq.reckon.controller.helper.EventIdentifier;
import com.logicq.reckon.controller.helper.StatusEvaluator;
import com.logicq.reckon.model.TableInventory;
import com.logicq.reckon.model.TableStatus;
import com.logicq.reckon.repository.TableStatusRepository;
import com.logicq.reckon.vo.EventVO;

@Service
@Transactional
public class TableStatusServiceImpl implements TableStatusService {

	@Autowired
	TableStatusRepository tableStatusRepository;

	@Autowired
	SimpMessagingTemplate brokerMessagingTemplate;

	@Autowired
	InventoryService inventoryService;

	@Autowired
	StatusEvaluator statusEvaluator;

	@Transactional
	public void saveEvent(EventVO eventVO) {
		Long event_status = eventVO.getStatus();
		TableInventory tableinventory = inventoryService.getByTableid(eventVO.getEventid());
		if (null != event_status && 0l != event_status) {
			TableStatus tableStatus = tableStatusRepository.getByTableid(tableinventory.getTableid());
			if (null == tableStatus) {
				tableStatus = new TableStatus();
				tableStatus.setTableid(tableinventory.getTableid());
			}
			if (EventIdentifier.REQUEST.equals(EventIdentifier.fromValue(event_status))) {
				tableStatus.setDate(new Date());
				tableStatus.setStatus("SR");
			} else {
				tableStatus.setDate(new Date());
				tableStatus.setStatus("SC");
			}
			tableStatusRepository.saveAndFlush(tableStatus);
			sendMessage(tableStatus);
		}

	}

	@Transactional
	public void UpdateTableStatus(List<TableStatus> tablestatusList) {
		tableStatusRepository.save(tablestatusList);
	}

	@Transactional(readOnly = true)
	public List<TableStatus> findAllEvent() {
		return tableStatusRepository.findAll();
	}

	@Transactional
	public void delete(String id) {

	}

	@Override
	public void sendMessage(TableStatus tableStatus) {
		List<TableStatus> tablelist = tableStatusRepository.getBusyTables();
		if (!tablelist.isEmpty()) {
			Map<Long, String> result = new HashMap();
			Instant end = Instant.now();
			tablelist.stream().forEach((data) -> {
				String statusCode = statusEvaluator.getStatusCodeForTime(data.getDate(), end);
				result.put(data.getTableid(), statusCode);
			});

			brokerMessagingTemplate.convertAndSend("/topics/event", result);
		}
	}

	@Override
	public List<TableStatus> getBusyTables() {
		return tableStatusRepository.getBusyTables();
	}

}
