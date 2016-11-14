package dao;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesFileUtils {
	
	/**
	 * Returns the value of the specified key from a defined properties file.
	 * 
	 * @param fileName the resource name
	 * @param key the property key
	 * @return the property value of the specified key
	 */
	public static String getPropertyValue(String fileName, String key) {
		String propertyValue = "";
		// Create an empty property list
		Properties properties = new Properties();
		try (InputStream is = PropertiesFileUtils.class.getClassLoader().getResourceAsStream(fileName)){
			// Read a property list from the specified input stream
			properties.load(is);
			// Search for the property with the specified key in this property list
			propertyValue = properties.getProperty(key);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return propertyValue;
	}
}
