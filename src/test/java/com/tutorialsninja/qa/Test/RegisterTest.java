package com.tutorialsninja.qa.Test;

import org.openqa.selenium.WebDriver;

import org.testng.Assert;
import org.testng.annotations.*;

import com.tutorialsninja.qa.Base.BaseClass;
import com.tutorialsninja.qa.Page.AccountSuccess;
import com.tutorialsninja.qa.Page.HomePage;
import com.tutorialsninja.qa.Page.RegisterPage;
import com.tutorialsninja.qa.utils.Utilities;

public class RegisterTest extends BaseClass 
{
	public WebDriver driver;
	HomePage homepage;
	RegisterPage registerpage;
	AccountSuccess accountsuccess;
	public RegisterTest()
	{
		super();
	}
	@BeforeMethod
	public void setup()
	{
		driver=initialBrowserandOpenApplicationUrl(prop.getProperty("browser"));
		homepage=new HomePage(driver);
	  //homepage.clickonMyAccount();
      //homepage.ClickOnRegister();
		homepage.navigatetoRegisterPage();
	}
	@AfterMethod
	public void teardown()
	{
		driver.quit();
	}
	@Test(priority=1)
	public void verifyRegisterAccountWithMandatoryFields()
	{
		registerpage=new RegisterPage(driver);
		accountsuccess=registerpage.navigatetoAccountSuccessFromRegisterPage(testdataprop.getProperty("firstname"), testdataprop.getProperty("firstname"), Utilities.generateEmailwithTimeStamp(), testdataprop.getProperty("telephone"), prop.getProperty("validpassword"), prop.getProperty("validpassword"));
		/*registerpage.enterFirstName(testdataprop.getProperty("firstname"));
		registerpage.enterLastName(testdataprop.getProperty("lastname"));
		registerpage.enterEmail(Utilities.generateEmailwithTimeStamp());
		registerpage.enterTelephone(testdataprop.getProperty("telephone"));
		registerpage.enterPassword(prop.getProperty("validpassword"));
		registerpage.enterConfirmPassword(prop.getProperty("validpassword"));
		registerpage.clickonPrivacypolicyButton();
		registerpage.clickonContinueButton();*/
		Assert.assertTrue(accountsuccess.RegisterAccountSuccess().contains(testdataprop.getProperty("expectedresult")));
	}
	@Test(priority=2)
	public void verifyRegisterAccountWithAllFields()
	{
		registerpage=new RegisterPage(driver);
		/*registerpage.enterFirstName(testdataprop.getProperty("firstname"));
		registerpage.enterLastName(testdataprop.getProperty("lastname"));
		registerpage.enterEmail(Utilities.generateEmailwithTimeStamp());
		registerpage.enterTelephone(testdataprop.getProperty("telephone"));
		registerpage.enterPassword(prop.getProperty("validpassword"));
		registerpage.enterConfirmPassword(prop.getProperty("validpassword"));*/
		accountsuccess = registerpage.navigatetoAccountSuccessFromRegisterPagewithallfield(testdataprop.getProperty("firstname"), testdataprop.getProperty("firstname"), Utilities.generateEmailwithTimeStamp(), testdataprop.getProperty("telephone"), prop.getProperty("validpassword"), prop.getProperty("validpassword"));
	    //registerpage.clickonPrivacypolicyButton();
		//registerpage.clickonContinueButton();
		
		accountsuccess=new AccountSuccess(driver);
		Assert.assertTrue(accountsuccess.RegisterAccountSuccess().contains(testdataprop.getProperty("expectedresult")));
	}
	@Test(priority=3)
	public void verifyRegisterAccountwithoutprovidingdetails()
	{
		registerpage=new RegisterPage(driver);
		registerpage.clickonContinueButton();
		Assert.assertTrue(registerpage.warningmessageStatusWithoutfillAnyDetails(testdataprop.getProperty("firstnamewarning"), testdataprop.getProperty("lastnamewarning"), testdataprop.getProperty("emailwarning"), testdataprop.getProperty("telephonewarning"), testdataprop.getProperty("passwordwarning")));
		/*Assert.assertTrue(registerpage.WarningforFirstName().contains(testdataprop.getProperty("firstnamewarning")));
		Assert.assertTrue(registerpage.WarningforLastName().contains(testdataprop.getProperty("lastnamewarning")));
		Assert.assertTrue(registerpage.WarningforEmail().contains(testdataprop.getProperty("emailwarning")));
		Assert.assertTrue(registerpage.WarningforTelephone().contains(testdataprop.getProperty("telephonewarning")));
		Assert.assertTrue(registerpage.Warningforpassword().contains(testdataprop.getProperty("passwordwarning")));*/
	}
}