package com.logicq.reckon.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.logicq.reckon.model.TableInventory;
import com.logicq.reckon.repository.InventoryRepository;

@Service
public class InventoryServiceImpl implements InventoryService {

	@Autowired
	InventoryRepository inventoryRepository;

	@Override
	@Transactional
	public void saveLinkTableAndDevice(TableInventory tableInventory) {
		inventoryRepository.saveAndFlush(tableInventory);
	}

	@Override
	@Transactional
	public void saveMultiTableAndDevices(List<TableInventory> tableList) {
		inventoryRepository.save(tableList);
	}

	@Override
	@Transactional
	public void deleteLinkTableAndDevice(TableInventory tableInventory) {
		inventoryRepository.delete(tableInventory);
	}

	@Override
	@Transactional
	public void deleteLinkTablesAndDevices(List<TableInventory> tables) {
		inventoryRepository.delete(tables);
	}

	@Override
	@Transactional
	public List<TableInventory> getNotLinkedTables() {
		return inventoryRepository.deLinkedTables();
	}

	@Override
	@Transactional
	public List<TableInventory> getLinkedTables() {
		return inventoryRepository.linkedTables();
	}

	@Override
	@Transactional
	public TableInventory getByTableid(Long reckonid) {
		return inventoryRepository.findByReckonid(reckonid);
	}

	@Override
	@Transactional
	public TableInventory getByReckonid(Long tableid) {
		return inventoryRepository.findByTableid(tableid);
	}

}
