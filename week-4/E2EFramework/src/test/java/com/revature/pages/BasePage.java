package com.revature.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class BasePage {

	public WebDriver driver;
	public WebDriverWait wdw;
	
	public BasePage(WebDriver driver) {
		this.driver = driver;
		this.wdw = new WebDriverWait(this.driver, 5);
	}
	
	public void waitForElementVisibility(By locator) {
		this.wdw.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}
	
}
