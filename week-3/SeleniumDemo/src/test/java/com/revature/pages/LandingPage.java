package com.revature.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LandingPage {

	private WebDriver driver;
	
	// Define element locators here
	private By loginSuccessfulElement = By.xpath("//*[text()='Login Successfully']");
	private By signOffButton = By.xpath("//a[text()='SIGN-OFF']");
	
	public LandingPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public String getLoginSuccessfulText() {
		return driver.findElement(loginSuccessfulElement).getText();
	}
	
	public void clickSignOff() {
		driver.findElement(signOffButton).click();
	}
	
}
