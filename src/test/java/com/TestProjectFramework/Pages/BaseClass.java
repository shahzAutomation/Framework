package com.TestProjectFramework.Pages;

import java.io.File;
import org.openqa.selenium.WebDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.TestProjectFramework.Util.BrowserFactory;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentReporter;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;


public class BaseClass {

public WebDriver driver;
public static ExtentSparkReporter extent;
public static ExtentReports report;
public static ExtentTest extentLogger;
	
	@BeforeSuite
	public void SetReport()
	{
		extent = new ExtentSparkReporter(new File(System.getProperty("user.dir")+"/Reports/HrmTestReport"+".html"));
		report = new ExtentReports();
		report.attachReporter(extent);
		
		extent.config().setDocumentTitle("Automation Report");
		extent.config().setReportName("Orange HRM Report");
		extent.config().setTheme(Theme.DARK);
	}
	
	@BeforeMethod
	public void initialSetup()
	{
		Reporter.log("Setting Done Test starts.....",true);
		
		driver = BrowserFactory.startApplication(driver, "Chrome", "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		Reporter.log("Test Started",true);
	}
	
	@AfterMethod
	public void closeBrowser()
	{
		BrowserFactory.quitBrowser(driver);
	}
	
	@AfterSuite
	public void reportFlush()
	{
		report.flush();
	}

}
