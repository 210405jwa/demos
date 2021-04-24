package com.revature.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MercuryToursHomepage {

	private WebDriver driver;
	
	// Define element locators here
	private By usernameLocator = By.name("userName");
	private By passwordLocator = By.name("password");
	private By submitLocator = By.name("submit");
	
	public MercuryToursHomepage(WebDriver driver) {
		this.driver = driver;
	}
	
	public void typeUsername(String username) {
		this.driver.findElement(usernameLocator).sendKeys(username);
	}
	
	public void typePassword(String password) {
		this.driver.findElement(passwordLocator).sendKeys(password);
	}
	
	public String getTitle() {
		return this.driver.getTitle();
	}
	
	public void clickSubmit() {
		this.driver.findElement(submitLocator).click();
	}
	
}
