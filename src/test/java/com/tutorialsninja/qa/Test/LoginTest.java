package com.tutorialsninja.qa.Test;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import com.tutorialsninja.qa.Base.BaseClass;
import com.tutorialsninja.qa.Page.AccountPage;
import com.tutorialsninja.qa.Page.HomePage;
import com.tutorialsninja.qa.Page.LoginPage;
import com.tutorialsninja.qa.utils.Utilities;

public class LoginTest extends BaseClass
{
	public WebDriver driver;
	HomePage homepage;
	LoginPage loginpage;
	
	public LoginTest()
	{
		super();
	}
	@BeforeMethod
	public void setup()
	{
		driver=initialBrowserandOpenApplicationUrl(prop.getProperty("browser"));
		homepage=new HomePage(driver);
		homepage.navigatetoLoginPage();
	}
	@AfterMethod
	public void teardown()
	{
		driver.quit();
	}
	@Test(priority=1,dataProvider="dataprovider")
	public void verifyMyLoginwithvalidcredentials(String email,String password) 
	{
		loginpage=new LoginPage(driver);
		/*loginpage.enterEmail(email);
		loginpage.enterPassword(password);
		loginpage.clickLoginButton();*/
		//above code reduced by below one line code
		loginpage.login(email, password);
		AccountPage accountpage=new AccountPage(driver);
		Assert.assertTrue(accountpage.getdisplaystatusEdityouraccountinformation());
	}
	@DataProvider(name="dataprovider")
	public Object[][] setupdataprovider() throws IOException 
	{
		Object[][] data=Utilities.gettestdatafromexcelfile(testdataprop.getProperty("sheetname"));
		return data;	
	}
	@Test(priority=2)
	public void verifyMyLoginwithInvalidcredentials()
	{
		loginpage=new LoginPage(driver);
		/*loginpage.enterEmail(Utilities.generateEmailwithTimeStamp());
		loginpage.enterPassword(testdataprop.getProperty("invalidpassword"));
		loginpage.clickLoginButton();*/
		loginpage.login(Utilities.generateEmailwithTimeStamp(), testdataprop.getProperty("invalidpassword"));
		homepage=new HomePage(driver);
		Assert.assertEquals(homepage.noMatchforEmailandPassword(), true);
		//Assert.assertTrue(homepage.noMatchforEmailandPassword());
	}
	
	@Test(priority=3)
	public void verifyloginwithinvlalidEmailandvalidpassword()
	{
		loginpage=new LoginPage(driver);
		loginpage.login(Utilities.generateEmailwithTimeStamp(), prop.getProperty("validpassword"));
		homepage=new HomePage(driver);
		//String expected=" Warning: No match for E-Mail Address and/or Password.";
		Assert.assertEquals(homepage.noMatchforEmailandPassword(), true);
		//Assert.assertTrue(homepage.noMatchforEmailandPassword().contains(expected));
		
	}
	@Test(priority=4)
	public void verifyloginwithValidEmailandinvalidpassword()
	{
		loginpage=new LoginPage(driver);
		loginpage.login(prop.getProperty("validemail"), testdataprop.getProperty("invalidpassword"));
		
		homepage=new HomePage(driver);
		//String expected=" Warning: No match for E-Mail Address and/or Password.";
		Assert.assertEquals(homepage.noMatchforEmailandPassword(), true);
		//Assert.assertTrue(homepage.noMatchforEmailandPassword().contains(expected));
	}
	@Test(priority=5)
	public void verifyLoginWithoutCredentials()
	{
		loginpage=new LoginPage(driver);
		loginpage.clickLoginButton();
		
		homepage=new HomePage(driver);
		//String expected=" Warning: No match for E-Mail Address and/or Password.";
		Assert.assertEquals(homepage.noMatchforEmailandPassword(), true);
		//Assert.assertTrue(homepage.noMatchforEmailandPassword().contains(expected));


	}
}
