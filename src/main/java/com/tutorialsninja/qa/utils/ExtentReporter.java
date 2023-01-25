package com.tutorialsninja.qa.utils;

import java.io.*;
import java.util.Properties;
import com.aventstack.extentreports.*;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReporter 
{
	public static ExtentReports generateExtentReprot()
	{
	ExtentReports extentreports=new ExtentReports();
	File extentreportfile=new File(System.getProperty("user.dir")+"\\test-output\\ExtentReport\\extentReport.html");
	ExtentSparkReporter spakReporter=new ExtentSparkReporter(extentreportfile);
	
	spakReporter.config().setTheme(Theme.DARK);
	spakReporter.config().setReportName("Tutorialsninja Test Automation Results");
	spakReporter.config().setDocumentTitle("Tutorialsninja Automation Report");
	spakReporter.config().setTimeStampFormat("dd/MM/yyyy hh:mm:ss");
	
	
	extentreports.attachReporter(spakReporter);
	
	Properties configProp=new Properties();
	File configPropFile=new File(System.getProperty("user.dir")+"src\\main\\java\\com\\tutorialsninja\\qa\\config\\config.properties");
	
	try {
	FileInputStream fisConfigProp=new FileInputStream(configPropFile);
	configProp.load(fisConfigProp);
	}catch(Throwable e)
	{
		e.printStackTrace();
	}
	
	extentreports.setSystemInfo("Application url", configProp.getProperty("url"));
	extentreports.setSystemInfo("Browsername", configProp.getProperty("browser"));
	extentreports.setSystemInfo("Email", configProp.getProperty("validemail"));
	extentreports.setSystemInfo("password", configProp.getProperty("validpassword"));
	extentreports.setSystemInfo("Operating system", System.getProperty("os.name"));
	extentreports.setSystemInfo("Username", System.getProperty("user.name"));
	extentreports.setSystemInfo("JavaVersion", System.getProperty("java.version"));
	
	return extentreports;
	
	
	
	}
}
