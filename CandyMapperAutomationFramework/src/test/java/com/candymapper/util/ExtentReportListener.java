package com.candymapper.util;

import org.testng.ITestNGListener;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportListener implements ITestNGListener {
	
	static ExtentReports extent;
	
	public static  ExtentReports getReportObject() 
	{
		String path = System.getProperty("user.dir")+"\\test-output\\index.html";
		ExtentSparkReporter reporter = new ExtentSparkReporter(path);
		
		reporter.config().setReportName("Candy Mapper Automation");
		reporter.config().setDocumentTitle("Automation Test Results");
		
		extent = new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo ("QA", "Ravikumar");
		return extent;
		
	}

}
