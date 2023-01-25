package com.tutorialsninja.qa.listeners;
import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.tutorialsninja.qa.utils.ExtentReporter;
import com.tutorialsninja.qa.utils.Utilities;

public class MyListener implements ITestListener{
	ExtentReports extentreport;
	ExtentTest extentTest;


	public void onStart(ITestContext context) 
	{
		 extentreport = ExtentReporter.generateExtentReprot();
	}

	@Override
	public void onTestStart(ITestResult result) 
	{
		//String testname = result.getName();
		String testname = result.getName();
		extentTest = extentreport.createTest(testname);
		extentTest.log(Status.PASS, testname+"started executing");
		
	}

	@Override
	public void onTestSuccess(ITestResult result) 
	{
		String	testname = result.getName();
		extentTest.log(Status.INFO, testname+" got successfully executed");
		
	}

	@Override
	public void onTestFailure(ITestResult result) 
	{
		String testname = result.getName();
		WebDriver driver = null;
		
		
			try {
				driver=(WebDriver)result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
	            //above line is for writing logs into extent report		
			} catch (IllegalArgumentException | IllegalAccessException | NoSuchFieldException | SecurityException e) 
			{
				e.printStackTrace();
			}
			/*File srcScreenshot=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			String destinationScreenshotPath=System.getProperty("user.dir")+"Screenshots"+testname+"png";
			try {
				FileHandler.copy(srcScreenshot,new File(destinationScreenshotPath));
			} catch (IOException e) {
				e.printStackTrace();
			}*/
			//the above codes r meant to capture screenshot which is 
			//pasted or separted in creating method in utilities class calling here
			String destinationScreenshotPath=Utilities.captureScreenshot(driver, testname);
			//note :above line, is calling scrennchot method and it returns destinationscreenshotpath string so type it
			extentTest.addScreenCaptureFromPath(destinationScreenshotPath);
			extentTest.log(Status.INFO, result.getThrowable());
			extentTest.log(Status.FAIL, testname+" got failed");
			
			//the above codes r meant to capture screenshot which is 
			//pasted or separted in creating method in utilities class calling here
			
	}

	@Override
	public void onTestSkipped(ITestResult result) 
	{
		String testname = result.getName();
		extentTest.log(Status.INFO, result.getThrowable());
		extentTest.log(Status.SKIP, testname+" got skipped");
		
	}

	@Override
	public void onFinish(ITestContext context) 
	{
		extentreport.flush();
		//System.out.println("Finished executing project tests ");
		//below codes are meant to open extentreport automatically once tests r executed
		String pathofExtentReport=System.getProperty("user.dir")+"\\test-output\\ExtentReport\\extentReport.html";
		File extentReport=new File(pathofExtentReport);
		try {
			Desktop.getDesktop().browse(extentReport.toURI());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
