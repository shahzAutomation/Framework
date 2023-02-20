package com.TestProjectFramework.TestScript;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
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
		extentLogger=report.createTest("Login Functionality Validation");
		loginPage lp = PageFactory.initElements(driver, loginPage.class);
		lp.enterUsername(uname);
		extentLogger.log(Status.PASS, "Username entered successfully...");
		lp.enterPassword(pwd);
		lp.clickOnLoginBtn();
		extentLogger.log(Status.PASS, "Login Succes");
		UtilMethods.validateUrl(driver, "/dashboard/index");
		extentLogger.log(Status.PASS, "Validation Completed Assertion Passed");
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
