package com.logicq.reckon.service;

import java.util.List;

import com.logicq.reckon.model.TableStatus;
import com.logicq.reckon.vo.EventVO;

public interface TableStatusService {

	void sendMessage(TableStatus tableStatus);

	void saveEvent(EventVO eventVO);

	List<TableStatus> findAllEvent();

	void delete(String id);

	List<TableStatus> getBusyTables();

}
