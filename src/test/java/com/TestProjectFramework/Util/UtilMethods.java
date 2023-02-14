package com.TestProjectFramework.Util;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class UtilMethods {

	public static void validateUrl(WebDriver driver, String path) {
		
		String url = driver.getCurrentUrl();
		Assert.assertTrue(url.contains(path));
		
	}
	
}
