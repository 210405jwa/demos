package com.revature.gluecode;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.revature.pages.LoginPage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ScenarioOutlineExampleDefinition {

	private WebDriver driver;
	private LoginPage loginPage;
	
    @Given("^User is on the login page$")
    public void user_is_on_the_login_page() throws Throwable {
    	System.setProperty("webdriver.chrome.driver", "C:\\Users\\BachTran\\Desktop\\maven-workspace\\CucumberDemo\\src\\test\\resources\\chromedriver.exe");
    	this.driver = new ChromeDriver();
    	this.loginPage = new LoginPage(driver);
    	
    	this.driver.get("http://ec2-18-223-188-185.us-east-2.compute.amazonaws.com:7000");
    }

    @When("^User enters invalid username (.+) and invalid password (.+)$")
    public void user_enters_and_password(String username, String password) throws Throwable {
    	this.loginPage.enterUsername(username);
    	this.loginPage.enterPassword(password);
    	
    	this.loginPage.clickLoginButton();
    }

    @Then("^\"([^\"]*)\" is displayed$")
    public void something_is_displayed(String expected) throws Throwable {
    	String actual = this.loginPage.getInvalidLoginText();
    	
    	assertEquals(expected, actual);
    	this.driver.close();
    }
	
}
