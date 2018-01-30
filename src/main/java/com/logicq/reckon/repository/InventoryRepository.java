package com.logicq.reckon.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import com.logicq.reckon.model.TableInventory;

@Transactional
public interface InventoryRepository extends JpaRepository<TableInventory, Long>, InventoryQueryRepository {

	TableInventory findByReckonid(Long reckonid);

	TableInventory findByTableid(Long tableid);
}
