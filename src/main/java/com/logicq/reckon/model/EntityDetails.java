package com.logicq.reckon.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ENTITY")
public class EntityDetails extends AttributeDetails {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3043675769313534970L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ENTITY_ID")
	private Long entityId;

	public Long getEntityId() {
		return entityId;
	}

	public void setEntityId(Long entityId) {
		this.entityId = entityId;
	}

}
