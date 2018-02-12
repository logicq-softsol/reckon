package com.logicq.reckon.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "THRESHOLD")
public class Threshold implements Serializable{

	@Id
	@Column(name = "THRESHOLD_ID", nullable = false)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long thresholdId;

	@Column(name = "NAME", nullable = false)
	private String name;

	@Column(name = "SECONDS")
	private Long seconds;

	@Column(name = "COLOR_CODE")
	private String color;

	 @ManyToMany(mappedBy = "thresholds")
	private Set<ServiceDetails> services = new HashSet<>();

	public Long getThresholdId() {
		return thresholdId;
	}

	public void setThresholdId(Long thresholdId) {
		this.thresholdId = thresholdId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getSeconds() {
		return seconds;
	}

	public void setSeconds(Long seconds) {
		this.seconds = seconds;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public Set<ServiceDetails> getServices() {
		return services;
	}

	public void setServices(Set<ServiceDetails> services) {
		this.services = services;
	}
	 
	 
	
}
