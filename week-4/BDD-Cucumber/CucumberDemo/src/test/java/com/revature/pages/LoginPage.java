package com.revature.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

// Page Object Model (POM), not to be confused with Maven POM (Project Object Model)
public class LoginPage extends BasePage {
	
	private By loginHeader = By.xpath("//label[@for='username']/parent::div/preceding-sibling::h1");
	private By usernameInput = By.id("username");
	private By passwordInput = By.id("password");
	private By loginButton = By.id("login");
	private By invalidLoginText = By.tagName("p");
	
	public LoginPage(WebDriver driver) {
		super(driver);
	}
	
	public void enterUsername(String username) {
		this.driver.findElement(usernameInput).sendKeys(username);
	}
	
	public void enterPassword(String password) {
		this.driver.findElement(passwordInput).sendKeys(password);
	}
	
	public void clickLoginButton() {
		this.driver.findElement(loginButton).click();
	}
	
	public String getLoginHeaderText() {
		return this.driver.findElement(loginHeader).getText();
	}
	
	public String getInvalidLoginText() {
		super.waitForElementToAppear(invalidLoginText); // Explicit wait for the element to appear (where we
		// wait for maximum of 5 seconds, according to our WebDriverWait object inside of the abstract BasePage 
		// parent class)
		return this.driver.findElement(invalidLoginText).getText();
	}
	
}
