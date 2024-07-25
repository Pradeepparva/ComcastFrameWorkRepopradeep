package com.comcast.crm.ListenerUtility;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.comcast.BaseClass.BaseClass;

public class ListImpClass implements ITestListener, ISuiteListener{
	
	public ExtentSparkReporter spark;
	public ExtentReports report;
	public static ExtentTest test;
	
	public void onStart(ISuite suite) {
		System.out.println("Report configuration");
		
		//Spark report configuration
		ExtentSparkReporter spark=new ExtentSparkReporter("./AdvanceReport/report.html");
		spark.config().setDocumentTitle("CRM Test Suite Results");
		spark.config().setReportName("CRM Report");
		spark.config().setTheme(Theme.DARK);
		
		//Add ENV information and create test
		report=new ExtentReports();
		report.attachReporter(spark);
		report.setSystemInfo("BROWSER", "CHROME-100");
		report.setSystemInfo("OS", "WINDOWS-10");
		
	}
	
	public void onFinish(ISuite suite) {
		System.out.println("Report Backup");
		report.flush();
	}
	
	public void  onTestStart(ITestResult result) {
		System.out.println("==========>"+result.getMethod().getMethodName()+"<=====Start=====");
		test = report.createTest(result.getMethod().getMethodName());
		test.log(Status.INFO, result.getMethod().getMethodName()+"===> STARTED <===");
	}
	
	public void onTestSuccess(ITestResult result) {
		System.out.println("==========>"+result.getMethod().getMethodName()+"<=====End=====");
		test.log(Status.PASS, result.getMethod().getMethodName()+"===> COMPLETED <===");
	}
	
	public void onTestFailure(ITestResult result) {
		String testName=result.getMethod().getMethodName();
		
		TakesScreenshot edriver=(TakesScreenshot)BaseClass.sdriver;
		String Filepath=edriver.getScreenshotAs(OutputType.BASE64);
		
		String time = new Date().toString().replace(" ", "_").replace(":", "_");
		test.addScreenCaptureFromBase64String(Filepath, testName+"-"+time);
		test.log(Status.FAIL, result.getMethod().getMethodName()+"===> FAILED <===");

	}
	
	public void onTestSkipped(ITestResult result) {
	
	}
}