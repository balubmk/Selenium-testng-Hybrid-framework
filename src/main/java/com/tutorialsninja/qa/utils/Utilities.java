package com.tutorialsninja.qa.utils;

import java.io.*;
import java.util.Date;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

//import java.sql.Date;//  dont import from this

public class Utilities {

	public static final int implicit_wait_time=20;
	public static final int page_load_waittime=15;

	public static String generateEmailwithTimeStamp()
	{
		Date date=new Date();
		String timestamp=date.toString().replace(" ","_").replace(":","_");
		return "luis.marshall"+timestamp+"@example.com";
	}
	
	
	public static Object[][] gettestdatafromexcelfile(String sheetname) throws IOException
	{
		File excelfile=new File(System.getProperty("user.dir")+"\\src\\main\\java\\com\\tutorialsninja\\qa\\testdata\\tutorialsninjaexcel.xlsx");
		
		FileInputStream fisExcel=new FileInputStream(excelfile);
		XSSFWorkbook workbook=new XSSFWorkbook(fisExcel);
		
		XSSFSheet sheet=workbook.getSheet(sheetname);
		
		int rows=sheet.getLastRowNum();
		int cols=sheet.getRow(0).getLastCellNum();
		
		Object[][] data=new Object[rows][cols];
		for(int i=0; i<rows; i++)
		{
			XSSFRow row=sheet.getRow(i+1);
			for(int j=0; j<cols; j++)
			{
				XSSFCell cell=row.getCell(j);
				CellType celltype=cell.getCellType();
				
				switch(celltype)
				{
					case STRING:
					data[i][j]=cell.getStringCellValue();
					break;
					case NUMERIC:
				    data[i][j]=Integer.toString((int)cell.getNumericCellValue());//getnumericcellvalue returns boolean so 1st convert to int then integer to string
					break;
					case BOOLEAN:
					data[i][j]=cell.getBooleanCellValue();
					break;
				default:
					break;
				}
			}
		}
		
		try {
			workbook.close();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		return data;
		
	}
	public static String captureScreenshot(WebDriver driver, String testname) 
	{
		File srcScreenshot=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String destinationScreenshotPath=System.getProperty("user.dir")+"\\Screenshots\\"+testname+".png";
		try {
			FileHandler.copy(srcScreenshot,new File(destinationScreenshotPath));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return destinationScreenshotPath;
		//note: we are returning path to call this in MyListener class
	}

}
