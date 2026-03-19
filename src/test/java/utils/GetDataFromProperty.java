package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class GetDataFromProperty {
	
	public static Properties config = null;
	public String locatorValue;

	public String propertyData(String locatorKey) throws IOException {
		config = new Properties();
		FileInputStream ip = new FileInputStream(System.getProperty("user.dir") + "//src//test//resources//config//locators.properties");
		config.load(ip);
		locatorValue = config.getProperty(locatorKey);
		return locatorValue;
	}
}
