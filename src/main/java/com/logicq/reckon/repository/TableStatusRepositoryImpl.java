package com.logicq.reckon.repository;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.logicq.reckon.model.TableInventory;
import com.logicq.reckon.model.TableStatus;

@Repository
@Transactional(readOnly = true)
public class TableStatusRepositoryImpl implements TableStatusQueryRepository {

	@PersistenceContext
	EntityManager entityManager;

	@Override
	public List<TableStatus> getBusyTables() {
		Query query = entityManager.createQuery(
				"SELECT TI FROM TableStatus TI WHERE TI.status IN ('RE','RM','RC','CA')", TableStatus.class);
		return query.getResultList();
	}

}
