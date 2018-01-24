package com.logicq.reckon.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import com.logicq.reckon.model.TableInventory;

@Transactional
public interface InventoryRepository extends JpaRepository<TableInventory, Long>, InventoryQueryRepository {

	Optional<TableInventory> findByDeviceid(Long deviceid);

}
