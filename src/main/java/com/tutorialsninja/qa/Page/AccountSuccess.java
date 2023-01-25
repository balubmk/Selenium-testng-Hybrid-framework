package com.tutorialsninja.qa.Page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountSuccess {

	WebDriver driver;
	@FindBy(xpath="//div[@class='col-sm-9']/h1")
	WebElement Accountsuccesspage;
	
	public AccountSuccess(WebDriver driver) 
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	public String RegisterAccountSuccess()
	{
		String accountsuccess=Accountsuccesspage.getText();
		return accountsuccess;
	}
	
}
