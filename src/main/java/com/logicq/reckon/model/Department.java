package com.logicq.reckon.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "DEPARTMENT")
public class Department {
	
	
	@Id
	@Column(name = "DEPT_ID", nullable = false)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long deptId;
	
	@Column(name = "NAME")
	private String name;
	
	@Column(name = "TYPE")
	private String type;
	
	@Column(name = "RECKON_COUNT")
	private Integer reckonCount;
	
	@ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
        name = "DEPT_SERVICE", 
        joinColumns = { @JoinColumn(name = "deptId") }, 
        inverseJoinColumns = { @JoinColumn(name = "serviceId") }
    )
	private Set<ServiceDetails> services= new HashSet<>();
	
	
	 @OneToMany(mappedBy="department")
	 private Set<TableInventory> tables;


	public Long getDeptId() {
		return deptId;
	}


	public void setDeptId(Long deptId) {
		this.deptId = deptId;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
	}


	public Integer getReckonCount() {
		return reckonCount;
	}


	public void setReckonCount(Integer reckonCount) {
		this.reckonCount = reckonCount;
	}


	public Set<ServiceDetails> getServices() {
		return services;
	}


	public void setServices(Set<ServiceDetails> services) {
		this.services = services;
	}


	public Set<TableInventory> getTables() {
		return tables;
	}


	public void setTables(Set<TableInventory> tables) {
		this.tables = tables;
	}
	
	 
	 
	

}
