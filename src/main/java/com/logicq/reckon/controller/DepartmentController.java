package com.logicq.reckon.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.logicq.reckon.dept.DepartmentRepository;
import com.logicq.reckon.model.Department;

@RestController
@EnableAutoConfiguration
@RequestMapping("/api/dept")
public class DepartmentController {

	@Autowired
	DepartmentRepository departmentRepository;

	@RequestMapping(value = "/allDept", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Department>> getAllDept() {
		return new ResponseEntity<List<Department>>(departmentRepository.findAll(), HttpStatus.OK);
	}

	@RequestMapping(value = "/dept", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Department>> addDept(@RequestBody Department dept) {
		departmentRepository.save(dept);
		return new ResponseEntity<List<Department>>(departmentRepository.findAll(), HttpStatus.OK);
	}

	@RequestMapping(value = "/removeDept/{deptid}", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Department>> linkTableAndDevice(@RequestBody Long deptid) {
		Department dept = new Department();
		dept.setDeptId(deptid);
		departmentRepository.delete(dept);
		return new ResponseEntity<List<Department>>(departmentRepository.findAll(), HttpStatus.OK);
	}

}
