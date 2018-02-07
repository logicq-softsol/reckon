package com.logicq.reckon.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import com.logicq.reckon.controller.helper.Status;
import com.logicq.reckon.model.TableInventory;
import com.logicq.reckon.repository.InventoryRepository;

@Service
public class InventoryServiceImpl implements InventoryService {

	@Autowired
	InventoryRepository inventoryRepository;

	@Override
	@Transactional
	public void saveLinkTableAndDevice(TableInventory tableInventory) {
		if (null != tableInventory) {
			if (null == tableInventory.getReckonid())
				tableInventory.setStatus(Status.NOT_LINKED.name());
			else
				tableInventory.setStatus(Status.LINKED.name());
		}

		inventoryRepository.save(tableInventory);
	}

	@Override
	@Transactional
	public void saveMultiTableAndDevices(List<TableInventory> tableList) {
		if (null != tableList && !tableList.isEmpty()) {
			tableList.forEach(tab -> {
				if (null == tab.getReckonid())
					tab.setStatus(Status.NOT_LINKED.name());
				else if (StringUtils.isEmpty(tab.getStatus()))
					tab.setStatus(Status.LINKED.name());

			});

		}
		inventoryRepository.save(tableList);
	}

	@Override
	@Transactional
	public void deleteLinkTableAndDevice(TableInventory tableInventory) {
		inventoryRepository.delete(tableInventory);
	}

	@Override
	@Transactional
	public void deleteLinkTablesAndDevices(TableInventory tables) {
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

	@Override
	public List<TableInventory> getAllTables() {
		return inventoryRepository.allTables();
	}

}
