package com.tutorialsninja.qa.Page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage 
{

	WebDriver driver;
	
	//Objects
	@FindBy(xpath="//*[@id=\"top-links\"]/ul/li[2]/a")
	private WebElement clickonMyAccount;
	
	@FindBy(xpath="//*[@id=\"top-links\"]/ul/li[2]/ul/li[2]/a")
	private WebElement clickonLogin;
	
	@FindBy(xpath="//*[@id=\"account-login\"]/div[1]/i")
	private WebElement InvalidCredentials;
	
	@FindBy(linkText="Register")
	private WebElement clickonResgister;
	
	//constructor
	public HomePage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	//Actions
	/*public void clickonMyAccount() 
	{
		clickonMyAccount.click();
	}
	public void selectLoginOption()
	{
		clickonLogin.click();
	}*/
	//above code is optimized
	public LoginPage navigatetoLoginPage()
	{
		clickonMyAccount.click();
		clickonLogin.click();
		return new LoginPage(driver);
	}
	/*public void ClickOnRegister()
	{
		clickonResgister.click();
	}*/

	public AccountSuccess navigatetoRegisterPage()
	{
		clickonMyAccount.click();
		clickonResgister.click();
		return new AccountSuccess(driver);
		
	}
	
	
	public boolean noMatchforEmailandPassword()
	{
		boolean WarningnoMatchforEmailandPassword = InvalidCredentials.isDisplayed();
		return WarningnoMatchforEmailandPassword;
	}
	
}
