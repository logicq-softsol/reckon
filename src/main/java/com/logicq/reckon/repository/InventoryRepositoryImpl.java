package com.logicq.reckon.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.logicq.reckon.model.TableInventory;

@Repository
@Transactional(readOnly = true)
public class InventoryRepositoryImpl implements InventoryQueryRepository {

	@PersistenceContext
	EntityManager entityManager;

	@Override
	public List<TableInventory> deLinkedTables() {
		Query query = entityManager.createQuery("SELECT TI FROM TableInventory TI WHERE TI.deviceid IS NULL",
				TableInventory.class);
		return query.getResultList();
	}

	@Override
	public List<TableInventory> linkedTables() {
		Query query = entityManager.createQuery("SELECT TI FROM TableInventory TI WHERE TI.reckonid!=NULL",
				TableInventory.class);
		return query.getResultList();
	}
	
	@Override
	public List<TableInventory> allTables() {
		Query query = entityManager.createQuery("SELECT TI FROM TableInventory TI ",
				TableInventory.class);
		return query.getResultList();
	}

}
