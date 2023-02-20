package com.TestProjectFramework.Util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class XLUtility {

	
	public static XSSFWorkbook wb;
	public static XSSFSheet sh;
	public static XSSFRow row;
	public static XSSFCell coll;
	public static FileInputStream fis;
	public static FileOutputStream fout;
	String path;
	
	int limit=1;
	
	 public XLUtility(String path) {	
		this.path=path;	
	}
	
	//Get Row Count from Excel
	public int getRowCount(String sheetName)
	{
		try {
				fis = new FileInputStream(path);			
				wb = new XSSFWorkbook(fis);
			} 
		catch (Exception e) {
			//System.out.println("Unable to read File...");
			System.out.println(e.getMessage());
		} 
		
		sh = wb.getSheet(sheetName);		
		int rowCount = sh.getLastRowNum();
		
		try {
			wb.close();			
			fis.close();
		} catch (IOException e) {
			e.printStackTrace();
		}	
		return rowCount;
	}
	
	//Get column count from excel
	public int getCellCount(String sheetName, int rowNum)
	{
		try {
			fis = new FileInputStream(path);			
			wb = new XSSFWorkbook(fis);
		} catch (Exception e) {
			System.out.println("Unable to get the File...");
		}
		
		sh = wb.getSheet(sheetName);
		row = sh.getRow(rowNum);
		int cellCount = row.getLastCellNum();
		
		try {
			wb.close();
			fis.close();
		} catch (IOException e) {
			e.printStackTrace();
		}	
		return cellCount;
	}
	
	//Get Any type of data from excel
	public Object getAnyCellData(String sheetName, int rownum, int colnum)
	{
		try {
			fis = new FileInputStream(path);	
			wb = new XSSFWorkbook(fis);
		} catch (Exception e) {
			System.out.println("Unable to get the File...");
		} 
		
		sh = wb.getSheet(sheetName);	
		row = sh.getRow(rownum);
		coll = row.getCell(colnum);
		Object data = "";
		
		switch(coll.getCellType())
		{
		case STRING: 
			return coll.getStringCellValue();
		case NUMERIC: 
			return coll.getNumericCellValue();
		case BOOLEAN:
			return coll.getBooleanCellValue();
		default:
			break;
		}
		
		try {
			wb.close();
			fis.close();
		} catch (IOException e) {
			e.printStackTrace();
		}	
		return data;
	}
	
	//Get String Cell data
	public String getStringCellData(String sheetName,int romNum,int colNum)
	{
		try {
			fis = new FileInputStream(path);	
			wb = new XSSFWorkbook(fis);
		} catch (Exception e) {
			System.out.println("Unable to get String Data from getStringCellData method...");
		} 
		
		sh = wb.getSheet(sheetName);		
		row = sh.getRow(romNum);
		coll = row.getCell(colNum);	
		String data= coll.getStringCellValue();
		
		try {
			wb.close();
			fis.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return data;
	}
	
	//Get Numeric Cell data
	public int getNumericData(String sheetName,int rowNum, int colNum)
	{
		try {
			fis = new FileInputStream(path);
			wb = new XSSFWorkbook(fis);
		} catch (Exception e) {
			System.out.println("Unable to get String Data from getNumericData method...");
		} 
		sh = wb.getSheet(sheetName);
		row = sh.getRow(rowNum);
		coll = row.getCell(colNum);	
		int data = (int)coll.getNumericCellValue();
		
		try {
			wb.close();
			fis.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return data;
	}
	
	//Get Boolean Cell data
	public boolean getBooleanData(String sheetName,int rowNum,int colNum)
	{
		try {
			fis = new FileInputStream(path);
			wb = new XSSFWorkbook(fis);
		} catch (Exception e) {
			System.out.println("Unable to get String Data from getNumericData method...");
		} 
		sh = wb.getSheet(sheetName);
		row = sh.getRow(rowNum);
		coll = row.getCell(colNum);
		boolean data = coll.getBooleanCellValue();
		
		try {
			wb.close();
			fis.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return data;
	}
	
	//Write data to excel file
	public void setCellData(String sheetName,int rownum,int colnum,String data) throws IOException
	{
		File xlfile=new File(path);
		if(!xlfile.exists())    // If file not exists then create new file
		{
			wb=new XSSFWorkbook();
			fout=new FileOutputStream(path);
			wb.write(fout);
		}
				
		fis=new FileInputStream(path);
		wb=new XSSFWorkbook(fis);
			
		if(wb.getSheetIndex(sheetName)==-1) // If sheet not exists then create new Sheet
			wb.createSheet(sheetName);
		
		sh=wb.getSheet(sheetName);
					
		if(sh.getRow(rownum)==null)   // If row not exists then create new Row
			sh.createRow(rownum);
		row=sh.getRow(rownum);
		
		coll=row.createCell(colnum);
		coll.setCellValue(data);
		fout=new FileOutputStream(path);
		wb.write(fout);		
		wb.close();
		fis.close();
		fout.close();
	}
}