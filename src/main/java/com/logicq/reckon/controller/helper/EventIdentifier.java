package com.logicq.reckon.controller.helper;

public enum EventIdentifier {

	REQUEST, CANCEL;

	public static EventIdentifier fromValue(Long value) {
		if (value == 123l) {
			return EventIdentifier.REQUEST;
		} else {
			return EventIdentifier.CANCEL;
		}
	}
	

}
