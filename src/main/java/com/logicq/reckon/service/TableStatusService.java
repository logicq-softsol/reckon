package com.logicq.reckon.service;

import java.util.List;
import java.util.Map;

import com.logicq.reckon.model.TableStatus;
import com.logicq.reckon.vo.EventVO;
import com.logicq.reckon.vo.ServiceRequestVO;

public interface TableStatusService {

	void busyTableDetails();

	void saveEvent(EventVO eventVO);

	List<TableStatus> findAllEvent();

	void delete(String id);

	List<TableStatus> getBusyTables();
	 Map<Long, ServiceRequestVO>  getBusyTableDetails();

}
