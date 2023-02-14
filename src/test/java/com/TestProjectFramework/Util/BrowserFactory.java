package com.TestProjectFramework.Util;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserFactory {

	public static WebDriver startApplication(WebDriver driver, String browser, String appUrl)
	{
		if(browser.equalsIgnoreCase("Chrome")) {
			System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
			driver = new ChromeDriver();
		}
		else if(browser.equalsIgnoreCase("firefox")){
			System.setProperty("webdriver.gecko.driver", "./Drivers/geckodriver.exe");
			driver = new FirefoxDriver();
		}
		else if(browser.equalsIgnoreCase("Edge")){
			System.setProperty("webdriver.edge.driver", "./Drivers/msedgedriver.exe");
			driver = new EdgeDriver();
		}
		else{
			System.out.println("We do not support this broswer!!!");
		}
		driver.manage().deleteAllCookies();
		
		driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);
		
		driver.manage().window().maximize();
		
		driver.get(appUrl);
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		return driver;
		
	}
	
	public static void quitBrowser(WebDriver driver)
	{
		driver.quit();
	}
	
}
