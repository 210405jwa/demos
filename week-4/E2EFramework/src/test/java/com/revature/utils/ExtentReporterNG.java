package com.revature.utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReporterNG {

	private static ExtentReports extent;
	
	public static ExtentReports getExtentObject() {
		if (extent == null) {
			generateExtentReport();
		}
		
		return extent;
	}
	
	private static void generateExtentReport() {
		String path = System.getProperty("user.dir") + "\\reports\\index.html";
		
		// Instantiating and Configuring Reporter object
		ExtentSparkReporter reporter = new ExtentSparkReporter(path);
		reporter.config().setReportName("Automation Reports");
		reporter.config().setDocumentTitle("Test Results");
		
		extent = new ExtentReports();
		// Attach reporter to ExtentReports object
		extent.attachReporter(reporter);
		extent.setSystemInfo("Tester", "Bach");
	}
	
}
