package com.logicq.reckon.repository;

import java.util.List;

import com.logicq.reckon.model.TableInventory;

public interface InventoryQueryRepository {

	List<TableInventory> deLinkedTables();

	List<TableInventory> linkedTables();

	List<TableInventory> allTables();

}
