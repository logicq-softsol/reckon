package com.logicq.reckon.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ENTITY_DETAILS")
public class EntityDetails {

	@Column(name = "NAME")
	private String name;

	@Id
	@Column(name = "ATTR_NAME")
	private String attrName;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAttrName() {
		return attrName;
	}

	public void setAttrName(String attrName) {
		this.attrName = attrName;
	}

	@Override
	public String toString() {
		return "EntityDetails [name=" + name + ", attrName=" + attrName + "]";
	}

}
