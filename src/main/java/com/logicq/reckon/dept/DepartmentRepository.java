package com.logicq.reckon.dept;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import com.logicq.reckon.model.Department;

@Transactional
public interface DepartmentRepository extends JpaRepository<Department, Long> {


}
