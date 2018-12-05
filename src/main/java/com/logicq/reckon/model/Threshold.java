package com.logicq.reckon.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "THRESHOLD")
public class Threshold extends AttributeDetails implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1866318703798116218L;

	@Id
	@Column(name = "ID", nullable = false)
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long thresholdId;

	@Column(name = "INTERVAL")
	private Long interval;

	@Column(name = "COLOR_CODE")
	private String colorCode;

	public Long getThresholdId() {
		return thresholdId;
	}

	public void setThresholdId(Long thresholdId) {
		this.thresholdId = thresholdId;
	}

	public Long getInterval() {
		return interval;
	}

	public void setInterval(Long interval) {
		this.interval = interval;
	}

	public String getColorCode() {
		return colorCode;
	}

	public void setColorCode(String colorCode) {
		this.colorCode = colorCode;
	}

}
