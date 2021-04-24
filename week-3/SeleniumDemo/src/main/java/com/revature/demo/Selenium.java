package com.revature.demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Selenium {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\BachTran\\Desktop\\maven-workspace\\SeleniumDemo\\src\\main\\resources\\chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("http://google.com");
		
		// WebElement googleSearchInput = driver.findElement(By.name("q")); // using the By.name matcher
		// WebElement googleSearchInput = driver.findElement(By.cssSelector("[name='q']")); // Using By.cssSelector
		WebElement googleSearchInput = driver.findElement(By.xpath("//input[@name='q']")); // Using xpath
		
		// CSS Selectors are around 10x faster than xPath, but xPath is more versatile in how we can select elements
		// Here's an example of a complicated xpath locator
		// //h2[@class='left'][2]/span/parent::h2/following-sibling::a[1]
		
		// Type in our search
		googleSearchInput.sendKeys("selenium");
		
		// After typing in Selenium, we need to wait for the 'Google Search' button to be clickable, otherwise
		// we will get some sort of exception, because when we type in the search results, the button is not immediately
		// loaded due to how Google is retrieving some autosuggestions
		
		// So here, we can use an implicit wait
		// driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		// However, most people would say that you should avoid implicit waits whenever possible, because implicit waits
		// don't really tell you much about what is being waited on
		
		// The implicit wait above will take effect any time in your Selenium automation, there is something that does not
		// exist yet in the browser
		
		// So there is also the concept of explicit waits, which make it really clear as to what you are wanting to wait on
		
		WebDriverWait wdw = new WebDriverWait(driver, 5);
		
		// Wait for an element to appear before trying to find the element, so we don't get some sort of exception
		// like ElementNotVisible
		wdw.until(ExpectedConditions.visibilityOfElementLocated(By.name("btnK")));
		WebElement googleSearchButton = driver.findElement(By.name("btnK"));
		
		// Waiting for an element to be clickable, if it's currently not clickable
		wdw.until(ExpectedConditions.elementToBeClickable(googleSearchButton));
		googleSearchButton.click();
		
		WebElement seleniumTextElement = driver.findElement(By.xpath("//div[@id='wp-tabs-container']/descendant::span[text()='Selenium']"));
		// Extracting text from an element
		System.out.println(seleniumTextElement.getText());
	}

}
