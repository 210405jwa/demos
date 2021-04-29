package com.revature.gluecode;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.revature.pages.LandingPage;
import com.revature.pages.LoginPage;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SuccessfulLoginDefinition {
	
	private WebDriver driver;
	private LoginPage loginPage;
	private LandingPage landingPage;
	
    @Given("^We have a WebDriver instantiated and configured$")
    public void we_have_a_webdriver_instantiated_and_configured() throws Throwable {
    	System.setProperty("webdriver.chrome.driver", "C:\\Users\\BachTran\\Desktop\\maven-workspace\\CucumberDemo\\src\\test\\resources\\chromedriver.exe");
    	driver = new ChromeDriver();
    }
    
    @And("^We have instantiated the LoginPage and LandingPage$")
    public void we_have_instantiated_the_loginpage() throws Throwable {
        loginPage = new LoginPage(driver);
        landingPage = new LandingPage(driver);
    }
	
    @Given("^User is at the login page$")
    public void user_is_at_the_login_page() throws Throwable {
    	// Write code to navigate Selenium to the main login page
    	driver.get("http://ec2-18-223-188-185.us-east-2.compute.amazonaws.com:7000");
    	
    	String loginHeader = loginPage.getLoginHeaderText();
    	assertEquals("Login!", loginHeader);
    }

    @When("^User enters username \"([^\"]*)\" and password \"([^\"]*)\"$")
    public void user_enters_username_something_and_password_something(String username, String password) throws Throwable {
        // Write code to type in username and password
    	loginPage.enterUsername(username);
    	loginPage.enterPassword(password);
    }
    
    @And("^User presses login$")
    public void user_presses_login() throws Throwable {
        // Write code to press the login button
    	loginPage.clickLoginButton();
    }

    @Then("^User should see a landing page with the header Successfully logged in as$")
    public void user_should_see_a_landing_page_with_the_header_successfully_logged_in_as() throws Throwable {
        // Find header element and assert that the text equals 'Successfully logged in as'
    	String actual = this.landingPage.getLandingHeaderText();
    	String expected = "Successfully logged in as:";
    	
    	assertEquals(expected, actual);
    	driver.close();
    }
    
}
