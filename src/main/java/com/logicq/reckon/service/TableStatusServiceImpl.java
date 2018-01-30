package com.logicq.reckon.service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.logicq.reckon.model.EventIdentifier;
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

	@Transactional
	public void saveEvent(EventVO eventVO) {
		Long event_status = eventVO.getStatus();
		TableInventory tableinventory = inventoryService.getByTableid(eventVO.getEventid());
		if (null != event_status && 0l != event_status) {
			TableStatus tableStatus = tableStatusRepository.getByTableid(tableinventory.getTableid());
			if (null == tableStatus) {
				tableStatus = new TableStatus();
				tableStatus.setDate(new Date());
				tableStatus.setTableid(tableinventory.getTableid());
			}
			if (EventIdentifier.REQUEST.equals(EventIdentifier.fromValue(event_status))) {
				tableStatus.setStatus("RE");
			} else {
				tableStatus.setStatus("CA");
			}
			tableStatusRepository.saveAndFlush(tableStatus);
			sendMessage(tableStatus);
		}

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
		Map<Long, String> statusMap = new HashMap<>();
		statusMap.put(tableStatus.getTableid(), tableStatus.getStatus());
		brokerMessagingTemplate.convertAndSend("/topics/event", tableStatus);
	}

	@Override
	public List<TableStatus> getBusyTables() {
		return tableStatusRepository.getBusyTables();
	}

}
