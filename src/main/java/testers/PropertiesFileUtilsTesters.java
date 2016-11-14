package testers;

import dao.PropertiesFileUtils;

public class PropertiesFileUtilsTesters {

	public static void main(String[] args) {
		System.out.println(PropertiesFileUtils.getPropertyValue("config.properties", "username"));
		System.out.println(PropertiesFileUtils.getPropertyValue("config.properties", "password"));
	}
	
}
