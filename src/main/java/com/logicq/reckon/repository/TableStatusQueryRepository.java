package com.logicq.reckon.repository;

import java.util.List;

import com.logicq.reckon.model.TableStatus;

public interface TableStatusQueryRepository {

	List<TableStatus> getBusyTables();

}
