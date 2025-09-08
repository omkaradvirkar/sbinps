package com.sbi.nps;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {
	 private Properties properties;

	    /**
	     * Constructor to initialize the configuration reader.
	     * Loads properties from the config file.
	     */
	    public ConfigReader() {
	        File src = new File("./Configuration/config.properties");

	        try (FileInputStream fileInputStream = new FileInputStream(src)) {
	            properties = new Properties();
	            properties.load(fileInputStream);
	        } catch (IOException e) {
	           System.out.println(
	  "Exception occurred while loading configuration: " + e.getMessage());
	        }
	    }
	    /**
	     * Retrieves the application base URL from the configuration file.
	     *
	     * @return the application base URL as a String.
	     */
	    public String getApplicationURL() {
	        return properties.getProperty("baseURL");
	    }

	    /**
	     * Retrieves the screenshot path from the configuration file.
	     *
	     * @return the screenshot path as a String.
	     */
	    public String getScreenshotPath() {
	        return properties.getProperty("screenshot.path");
	    }

	    /**
	     * Retrieves the download path from the configuration file.
	     *
	     * @return the download path as a String.
	     */
	    public String getDownloadPath() {
	        return properties.getProperty("download.path");
	    }
}
