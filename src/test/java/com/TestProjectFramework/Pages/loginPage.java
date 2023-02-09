package com.TestProjectFramework.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

public class loginPage {

	
	@FindBy(id="password")
	@CacheLookup
	WebElement password;
	
}
