package com.TestProjectFramework.Util;

import java.io.IOException;
import org.testng.annotations.DataProvider;

public class ExcelDataProvider {

	@DataProvider(name="LoginData")
	public Object[][] getData() throws IOException
	{	
		//get the data from excel
		XLUtility xlutil=new XLUtility("./TestData/Userdata.xlsx");
		
		int totalrows=xlutil.getRowCount("Sheet1");
		int totalcols=xlutil.getCellCount("Sheet1",0);	
				
		Object loginData[][]=new String[totalrows][totalcols];	
		for(int i=1;i<=totalrows;i++) //1
		{
			for(int j=0;j<totalcols;j++) //0
			{
				loginData[i-1][j]=xlutil.getAnyCellData("Sheet1", i, j);
			}			
		}
		return loginData;
	}
}