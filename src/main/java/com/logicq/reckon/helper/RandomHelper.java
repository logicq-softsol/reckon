package com.logicq.reckon.helper;

import org.apache.commons.lang.RandomStringUtils;
import org.springframework.stereotype.Component;

@Component
public class RandomHelper {

	public String generateProductKey() {
		return RandomStringUtils.randomAlphanumeric(20);
	}

	public String generateCopmanyKey() {
		return RandomStringUtils.randomAlphanumeric(7);
	}
	
	public String generateKey() {
		return RandomStringUtils.randomAlphanumeric(40);
	}

}
