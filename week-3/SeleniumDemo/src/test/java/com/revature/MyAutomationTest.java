package com.revature;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.revature.pages.LandingPage;
import com.revature.pages.MercuryToursHomepage;

// This annotation tells JUnit Jupiter to run our tests in order according to the annotations
@TestMethodOrder(OrderAnnotation.class)
public class MyAutomationTest {

	private static WebDriver driver;
	
	private static MercuryToursHomepage mtHomepage;
	private static LandingPage landingPage;
	
	@BeforeAll // In JUnit 4, the equivalent was @BeforeClass
	static void setUpBeforeClass() throws Exception {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\BachTran\\Desktop\\maven-workspace\\SeleniumDemo\\src\\main\\resources\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.get("http://demo.guru99.com/test/newtours/");
		mtHomepage = new MercuryToursHomepage(driver);
		landingPage = new LandingPage(driver);
	}

	@Test
	@Order(1) // introduced w/ JUnit5
	void test_titleIsCorrect() {
		String expected = "Welcome: Mercury Tours".trim();
		
		assertEquals(expected, mtHomepage.getTitle());
	}
	
	@Test
	@Order(2)
	void test_validLogin() {
		mtHomepage.typeUsername("dogbert");
		mtHomepage.typePassword("dogbert");
		
		mtHomepage.clickSubmit();
		
		assertEquals("Login Successfully", landingPage.getLoginSuccessfulText());
	}
	
	@Test
	@Order(3)
	void test_signoff() {
		landingPage.clickSignOff();
		
		assertEquals("Welcome: Mercury Tours".trim(), mtHomepage.getTitle());
	}
	
	@AfterAll
	static void tearDownAfterClass() {
		driver.close();
	}
	
}
