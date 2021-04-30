package com.revature.tests;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.revature.base.Base;
import com.revature.pages.LandingPage;
import com.revature.pages.LoginPage;

public class LoginTest extends Base {

	// In TestNG, the hierarchy from largest to smallest is
	
	// 1. Suite: containing many "tests"
	// 2. Test: containing many "test classes"
	// 3. Class: containing "test groups" (if any groups are specified, otherwise just containing the methods)
	// 4. Groups: containing many "test methods"
	// 5. Methods: what we normally think of as a "single test"
	
	private static Logger logger = LoggerFactory.getLogger(LoginTest.class);
	
	@BeforeClass
	public void logInitial() {
		logger.info("STARTING: LoginTest Class");
	}

	@BeforeMethod
	public void setUp() {
		super.initializeDriver();
		super.driver.get("http://ec2-18-223-188-185.us-east-2.compute.amazonaws.com:7000");
	}
	
	@DataProvider
	public Object[][] getLoginData() {
		// Inside here you might be parsing out a .csv file or excel file containing the login information
		// that you want to test
		
		// And that data should be converted into a 2D Object array
		
		// But for demonstration purposes, we're just going to hardcode it right here
		Object[][] data = new Object[3][2];
		data[0][0] = "user";
		data[0][1] = "password";
		
		// Since we only have a single user and password in the backend, just pretend these are some other
		// logins that are different and working
		data[1][0] = "user";
		data[1][1] = "password";
		
		data[2][0] = "user1";
		data[2][1] = "password";
		
		return data;
	}
	
	@Test(dataProvider="getLoginData")
	public void loginTest(Object[] row) {
		LoginPage loginPage = new LoginPage(super.driver);
		
		loginPage.typeUsername((String) row[0]);
		loginPage.typePassword((String) row[1]);
		loginPage.clickLoginButton();
		
		LandingPage landingPage = new LandingPage(super.driver);
		String userInfoText = landingPage.getUserInformationText();
		
		Assert.assertTrue(userInfoText.contains("username: " + (String) row[0] + ", password: " + (String) row[1]));
	}
	
	@AfterMethod
	public void cleanUp() {
		super.driver.quit();
	}
	
	@AfterClass
	public void logFinal() {
		logger.info("ENDING: LoginTest Class");
	}
	
}
