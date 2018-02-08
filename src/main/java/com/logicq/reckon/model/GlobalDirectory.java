package com.logicq.reckon.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "DIRECTORY")
public class GlobalDirectory  implements Serializable{

	
	@Id
	@Column(name = "TYPE")
	private String type;

	@Column(name = "PATH")
	private String filePath;

	@Column(name = "DISPLAY_TEXT")
	private String displayText;

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getDisplayText() {
		return displayText;
	}

	public void setDisplayText(String displayText) {
		this.displayText = displayText;
	}


}
