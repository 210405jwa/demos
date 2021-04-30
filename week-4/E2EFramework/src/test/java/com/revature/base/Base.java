package com.revature.base;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public abstract class Base {

	public Properties properties;
	public WebDriver driver;
	public OSChecker osChecker;
	
	public Base() {
		super();
		this.osChecker = new OSChecker();
		
		this.properties = new Properties();
		// Load the properties file
		InputStream is = this.getClass().getResourceAsStream("/config.properties");
		
		try {
			this.properties.load(is);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void initializeDriver() {
		// Imagine we have support for different browsers. We should have a property in our properties file where we
		// can easily specify which browser we are using to run our tests
		
		if (this.properties.getProperty("browser").equalsIgnoreCase("chrome")) {
			
			// Check if ChromeDriver should be running in headless mode or not, and set it to the appropriate setting
			ChromeOptions options = new ChromeOptions();
			if (this.properties.getProperty("headless") != null && this.properties.getProperty("headless").equals("yes")) {
				options.addArguments("--headless");
			}
			
			if (osChecker.isWindows()) {
				
				System.out.println("Setting up driver for Windows");
				System.setProperty("webdriver.chrome.driver", "Driver/chromedriver_windows.exe");
				
			} else if (osChecker.isMac()) {
				
				System.out.println("Setting up driver for Mac");
				System.setProperty("webdriver.chrome.driver", "Driver/chromedriver_mac");
				
			} else if (osChecker.isUnix()) {
				
				System.out.println("Setting up driver for Unix");
				System.setProperty("webdriver.chrome.driver", "Driver/chromedriver_unix");
				
			} else {
				throw new RuntimeException("Operating System not detected as Windows, Max, or Unix");
			}
			
			this.driver = new ChromeDriver(options);
			
		} else if (this.properties.getProperty("browser").equalsIgnoreCase("firefox")) {
			// Add firefox support later
		} else if (this.properties.getProperty("browser").equalsIgnoreCase("ie")) {
			// Add IE support later
		}
	}
	
}
