package com.TestProjectFramework.Util;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyzer implements IRetryAnalyzer{

	int counter=0, retryLimit=1;
	
	public boolean retry(ITestResult result) {
		
		if(counter<retryLimit)
		{
			System.out.println("Retrying "+result.getName() +" again & count is "+(counter+1));
			
			counter++;
			return true;
		}
		
		
		return false;
	}

	
	
	
}