package com.logicq.reckon.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ADV_DETAILS")
public class AdvDetails implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Long advId;

	@Column(name = "FILE_NAME")
	private String filename;

	@Column(name = "FILE_TYPE")
	private String fileType;

	@Column(name = "PATH")
	private String filepath;

	@Column(name = "URL")
	private String fileURL;

	@Column(name = "TEXT")
	private String advText;

	@Column(name = "ADV_TYPE")
	private String advType;

	@Column(name = "SEQUENCE")
	private Integer sequence;

	@Column(name = "IS_ACTIVE")
	private Boolean isActive;

	public Long getAdvId() {
		return advId;
	}

	public void setAdvId(Long advId) {
		this.advId = advId;
	}

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	public String getFileType() {
		return fileType;
	}

	public void setFileType(String fileType) {
		this.fileType = fileType;
	}

	public String getFilepath() {
		return filepath;
	}

	public void setFilepath(String filepath) {
		this.filepath = filepath;
	}

	public String getFileURL() {
		return fileURL;
	}

	public void setFileURL(String fileURL) {
		this.fileURL = fileURL;
	}

	public String getAdvText() {
		return advText;
	}

	public void setAdvText(String advText) {
		this.advText = advText;
	}

	public String getAdvType() {
		return advType;
	}

	public void setAdvType(String advType) {
		this.advType = advType;
	}

	public Integer getSequence() {
		return sequence;
	}

	public void setSequence(Integer sequence) {
		this.sequence = sequence;
	}

	public Boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	@Override
	public String toString() {
		return "AdvertisementDetails [advId=" + advId + ", filename=" + filename + ", fileType=" + fileType
				+ ", filepath=" + filepath + ", fileURL=" + fileURL + ", advText=" + advText + ", advType=" + advType
				+ ", sequence=" + sequence + ", isActive=" + isActive + "]";
	}

}
