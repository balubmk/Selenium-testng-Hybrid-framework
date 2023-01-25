package com.tutorialsninja.qa.Test;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import com.tutorialsninja.qa.Base.BaseClass;
import com.tutorialsninja.qa.Page.SearchPage;

public class SearchTest extends BaseClass {

	public WebDriver driver;
	SearchPage searchpage;
	@BeforeMethod
	public void setup()
	{
		driver=initialBrowserandOpenApplicationUrl(prop.getProperty("browser"));
	}
	@AfterMethod
	public void TearDown()
	{
		driver.quit();
	}
	@Test(priority=1)
	public void enterproductnameinsearchbox()
	{
		searchpage=new SearchPage(driver);
		searchpage.productFound("HP");
		Assert.assertTrue(searchpage.hpproductstatus());
	}
	@Test(priority=2)
	public void enterproductnamebutnotfound()
	{
		searchpage=new SearchPage(driver);
		searchpage.productFound("Honda");

		Assert.assertTrue(searchpage.hondaproductstatus());
	}
	
}
