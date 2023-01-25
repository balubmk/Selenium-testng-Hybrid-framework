package com.tutorialsninja.qa.Base;

import java.io.*;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.tutorialsninja.qa.utils.Utilities;

public class BaseClass {
	WebDriver driver;
	public Properties prop;
	public Properties testdataprop;
	public BaseClass()
	{
		prop=new Properties();
		File propfile=new File(System.getProperty("user.dir")+"\\src\\main\\java\\com\\tutorialsninja\\qa\\config\\config.properties");
		
		try {
			FileInputStream fis=new FileInputStream(propfile);
			prop.load(fis);
		} catch (IOException e) {
			e.printStackTrace();
		}
		testdataprop = new Properties();
		File testdatafile=new File(System.getProperty("user.dir")+"\\src\\main\\java\\com\\tutorialsninja\\qa\\testdata\\testdata.properties");
		try {
			FileInputStream	fis= new FileInputStream(testdatafile);
			testdataprop.load(fis);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public WebDriver initialBrowserandOpenApplicationUrl(String BrowserName)
	{
		if(BrowserName.equals("chrome"))
		{
			driver=new ChromeDriver();
		}else if(BrowserName.equals("firefox"))
		{
			driver=new FirefoxDriver();
		}
	
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Utilities.implicit_wait_time));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(Utilities.page_load_waittime));
		driver.get(prop.getProperty("url"));
		return driver;
	}
}
