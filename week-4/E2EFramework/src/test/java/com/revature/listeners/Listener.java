package com.revature.listeners;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.revature.utils.ExtentReporterNG;

public class Listener implements ITestListener {

	private static Logger logger = LoggerFactory.getLogger(Listener.class);
	
	private ExtentReports extent = ExtentReporterNG.getExtentObject();
	private ExtentTest test;

	@Override
	public void onTestStart(ITestResult result) {
		ITestListener.super.onTestStart(result);
		
		test = extent.createTest(result.getName());
		
		logger.info("Test '" + result.getName() + "' STARTED");
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		ITestListener.super.onTestSuccess(result);
		
		test.log(Status.PASS, "Test Successful");
		
		logger.info("Test '" + result.getName() + "' PASSED");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		ITestListener.super.onTestFailure(result);
		
		test.log(Status.FAIL, "Test Failure");
		
		logger.info("Test '" + result.getName() + "' FAILED");
		
		// Tricky part for below is getting the driver that we were using for the test
		// But we can use reflection to help us out
		WebDriver driver;
		try {
			driver = (WebDriver) result.getTestClass()
					.getRealClass()
					.getSuperclass()
					.getDeclaredField("driver")
					.get(result.getInstance());
			
			// Take a Screenshot of the browser and save the image
			// this will take the screenshot and save the file
			takeAndSaveScreenshot(result.getName(), driver);
		} catch (IllegalArgumentException | IllegalAccessException | NoSuchFieldException | SecurityException | IOException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		ITestListener.super.onTestSkipped(result);
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		ITestListener.super.onTestFailedButWithinSuccessPercentage(result);
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		ITestListener.super.onTestFailedWithTimeout(result);
	}

	@Override
	public void onStart(ITestContext context) {
		ITestListener.super.onStart(context);
	}

	@Override
	public void onFinish(ITestContext context) {
		ITestListener.super.onFinish(context);
		
		extent.flush();
	}
	
	
	// Screenshot helper method
	private void takeAndSaveScreenshot(String testCaseName, WebDriver driver) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		
		String destination = System.getProperty("user.dir") + "\\screenshots\\" + testCaseName + "-" + System.currentTimeMillis() + ".png";
		FileUtils.copyFile(source, new File(destination));
	}
	
}
