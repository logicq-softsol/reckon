package com.logicq.reckon.service;

import java.util.List;

import com.logicq.reckon.model.TableInventory;

public interface InventoryService {

	void saveLinkTableAndDevice(TableInventory tableInventory);

	void saveMultiTableAndDevices(List<TableInventory> tableList);

	void deleteLinkTableAndDevice(TableInventory tableInventory);

	void deleteLinkTablesAndDevices(TableInventory table);

	List<TableInventory> getNotLinkedTables();

	List<TableInventory> getLinkedTables();

	TableInventory getByTableid(Long reckonid);
	
	TableInventory getByReckonid(Long tableid);
	
	List<TableInventory> getAllTables();

}
