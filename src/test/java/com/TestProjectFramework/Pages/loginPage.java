package com.TestProjectFramework.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class loginPage {

	WebDriver driver;
	public loginPage(WebDriver ldriver) {
		this.driver=ldriver;
	}
	
	@FindBy(name="username")
	@CacheLookup
	WebElement userName;
	
	public void enterUsername(String username) throws Exception
	{
		Thread.sleep(2000);
		userName.sendKeys(username);
	}
	
	@FindBy(name="password")
	@CacheLookup
	WebElement password;
	
	public void enterPassword(String pwd) throws Exception
	{
		Thread.sleep(2000);
		password.sendKeys(pwd);
	}
	
	@FindBy(xpath="//button")
	@CacheLookup
	WebElement loginBtn;
	
	public void clickOnLoginBtn() throws Exception
	{
		Thread.sleep(2000);
		loginBtn.click();
	}

}