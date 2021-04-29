package com.revature.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LandingPage extends BasePage {
	
	By landingHeader = By.xpath("//*[@id='user']/preceding-sibling::h1");
	
	public LandingPage(WebDriver driver) {
		super(driver);
	}
	
	public String getLandingHeaderText() {
		super.waitForElementToAppear(landingHeader);
		return this.driver.findElement(landingHeader).getText();
	}
	
}
