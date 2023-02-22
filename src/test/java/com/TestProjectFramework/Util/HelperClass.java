package com.TestProjectFramework.Util;

import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import com.google.common.io.Files;
import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class HelperClass {
    
	public static String captureCurrentDateTime() {
		
		DateFormat df = new SimpleDateFormat("MM_dd_yyyy_HH_mm_ss");
		Date curDate = new Date();
		String formatedDate = df.format(curDate);
		return formatedDate;
	}
	
	public static String captureScreenshot(WebDriver driver) {
		
		File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String screenshotPath=System.getProperty("user.dir")+"/Screenshot/OrangeHRM-"+HelperClass.captureCurrentDateTime()+".png";
		try {
			//FileHandler.copy(srcFile, new File(screenshotPath));
			Files.copy(srcFile, new File(screenshotPath));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Screenshot captured successfully...");
		
		return screenshotPath;
	}
	
	
}
