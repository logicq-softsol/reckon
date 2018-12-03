package com.logicq.reckon.helper;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.Properties;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.logicq.reckon.model.ActivationDetails;

@Component
public class PropertyFileHelper {

	@Autowired
	HttpServletRequest request;

	@Autowired
	RandomHelper randomHelper;

	public Properties generateActivationFile(ActivationDetails activationDetails) throws Exception {
		Properties prop = new Properties();
		prop.setProperty("USER_KEY", activationDetails.getActivationKey());
		prop.setProperty("HOST", request.getRemoteAddr());
		File file = new File("activate.properties");
		FileOutputStream activeFileOut=new FileOutputStream(file);
		prop.store(activeFileOut,"Properties");
		InputStream input = new FileInputStream(file);
		prop.load(input);
		return prop;
	}

	public Properties loadActivationFile() throws Exception {
		Properties prop = new Properties();
		InputStream input = new FileInputStream("activate.properties");
		prop.load(input);
		return prop;
	}

}
