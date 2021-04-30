package com.revature.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage {
	
	@FindBy(xpath = "//input[@id='username']")
	private WebElement usernameInput;
	
	@FindBy(id = "password")
	private WebElement passwordInput;
	
	@FindBy(tagName = "button")
	private WebElement loginButton;
	
	public LoginPage(WebDriver driver) {
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	public void typeUsername(String username) {
		this.usernameInput.sendKeys(username);
	}
	
	public void typePassword(String password) {
		this.passwordInput.sendKeys(password);
	}
	
	public void clickLoginButton() {
		this.loginButton.click();
	}
}
