package com.GS.Utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertyFileUtil {
	

	public static Properties loadProperties(String filePath) throws FileNotFoundException, IOException {
	

		File propertyFile = new File(filePath);
		Properties properties = new Properties();
		properties.load(new FileInputStream(propertyFile));
	

		return properties;

	}

	public static String getPropertyValue(Properties properties, String propertyName) {
	

		String propertyValue = properties.getProperty(propertyName).trim();
		if (propertyValue == null) {
			propertyValue = "";
		}
	
	
		return propertyValue;
	}

	

	
}
