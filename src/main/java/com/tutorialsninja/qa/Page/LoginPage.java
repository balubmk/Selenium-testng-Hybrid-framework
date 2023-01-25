package com.tutorialsninja.qa.Page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage 
{
	WebDriver driver;
	
	@FindBy(id="input-email")
	private WebElement EnterEmail;
	
	@FindBy(xpath="//input[@name='password']")
	private WebElement EnterPassword;
	
	@FindBy(xpath="//input[@value='Login']")
	private WebElement ClickLoginButton;
	
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void enterEmail(String emailText)
	{
		EnterEmail.sendKeys(emailText);
	}
	public void enterPassword(String passwordText)
	{
		EnterPassword.sendKeys(passwordText);
	}
	public void clickLoginButton()
	{
		ClickLoginButton.click();
	}
	public AccountPage login(String emailText, String passwordText)
	{
		EnterEmail.sendKeys(emailText);
		EnterPassword.sendKeys(passwordText);
		ClickLoginButton.click();
		return new AccountPage(driver);
	}

}
