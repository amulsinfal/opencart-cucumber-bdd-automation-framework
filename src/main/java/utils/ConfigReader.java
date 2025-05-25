package utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ConfigReader {
	
	private static final Logger log = LogManager.getLogger(ConfigReader.class);

	public static String getValue(String key) {
		Properties properties = new Properties();
		FileInputStream fileInputStream;
		try {
			fileInputStream = new FileInputStream(System.getProperty("user.dir") + "\\src\\test\\resources\\configurations\\config.properties");
			properties.load(fileInputStream);
		} catch (FileNotFoundException e) {
			log.info("Unable to find the file config.properties.");
			e.printStackTrace();
		} catch (IOException e) {
			log.error("Error occured while trying to open the config.properties file.");
			e.printStackTrace();
		}
		return properties.getProperty(key);
	}
}
