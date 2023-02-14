package com.TestProjectFramework.TestScript;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.TestProjectFramework.Pages.BaseClass;
import com.TestProjectFramework.Pages.loginPage;
import com.TestProjectFramework.Util.UtilMethods;
import com.aventstack.extentreports.Status;

public class loginScript extends BaseClass {

	@Test
	public void validateLogin() throws Exception
	{
		
		extentLogger=report.createTest("Login Functionality Validation");
		loginPage lp = PageFactory.initElements(driver, loginPage.class);
		
		lp.enterUsername();
		extentLogger.log(Status.PASS, "Username entered successfully...");
		lp.enterPassword();
		lp.clickOnLoginBtn();
		extentLogger.log(Status.PASS, "Login Succes");
		UtilMethods.validateUrl(driver, "/dashboard/index");
		extentLogger.log(Status.PASS, "Validation Completed Assertion Passed");
		
	}
	
	@Test
	public void validateLoginFunctionality() throws Exception
	{
		extentLogger=report.createTest("Login Functionality Invalid Test");
		loginPage lp = PageFactory.initElements(driver, loginPage.class);
		
		lp.enterUsername();
		lp.enterPassword();
		lp.clickOnLoginBtn();
		extentLogger.log(Status.PASS, "User Logged In Successfully...");
		System.out.println("Test 2 Executed");
	}
	
}
