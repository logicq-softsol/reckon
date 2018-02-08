package com.logicq.reckon.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.logicq.reckon.model.GlobalDirectory;

@Transactional
public interface GlobalDirectoryRepository extends JpaRepository<GlobalDirectory, String> {

}
