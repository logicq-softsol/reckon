package com.logicq.reckon.controller.helper;

public enum EventIdentifier {

	REQUEST("REQUEST"), CANCEL("CANCEL"), DEFAULT("NORMAL");

	private final String value;

	EventIdentifier(String value) {
		this.value = value;
	}

	public String getvalue() {
		return value;
	}

}
