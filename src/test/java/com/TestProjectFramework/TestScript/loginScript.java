package com.TestProjectFramework.TestScript;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import com.TestProjectFramework.Pages.BaseClass;
import com.TestProjectFramework.Pages.loginPage;
import com.TestProjectFramework.Util.ExcelDataProvider;
import com.TestProjectFramework.Util.UtilMethods;
import com.aventstack.extentreports.Status;

public class loginScript extends BaseClass {
	
	@Test(dataProvider = "LoginData", dataProviderClass = ExcelDataProvider.class)
	public void validateLogin(String uname, String pwd) throws Exception
	{
		
		Logger log = (Logger) LogManager.getLogger();
		extentLogger=report.createTest("Login Functionality Validation");
		loginPage lp = PageFactory.initElements(driver, loginPage.class);
		lp.enterUsername(uname);
		log.info("Username entered successfully");
		extentLogger.log(Status.PASS, "Username entered successfully...");
		System.out.println("Username entered successfully...");
		lp.enterPassword(pwd);
		log.info("Password entered successfully");
		lp.clickOnLoginBtn();
		log.info("Login Successfull");
		extentLogger.log(Status.PASS, "Login Succes");
		UtilMethods.validateUrl(driver, "/dashboard/index");
		extentLogger.log(Status.PASS, "Validation Completed Assertion Passed");
		log.info("Validation completed");
		
	}
	
//	@Test
//	public void validateLoginFunctionality() throws Exception
//	{
//		extentLogger=report.createTest("Login Functionality Invalid Test");
//		loginPage lp = PageFactory.initElements(driver, loginPage.class);
//		
//		lp.enterUsername("Admin");
//		lp.enterPassword("admin123");
//		lp.clickOnLoginBtn();
//		extentLogger.log(Status.PASS, "User Logged In Successfully...");
//		System.out.println("Test 2 Executed");
//	}
//	
}
