package com.revature.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LandingPage extends BasePage {

	@FindBy(id = "user")
	private WebElement userInformation;
	
	public LandingPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	public String getUserInformationText() {
		return super.wdw.until(ExpectedConditions.visibilityOf(userInformation)).getText();
	}
	
}
