package com.tutorialsninja.qa.Page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchPage 
{
	WebDriver driver;
	
	@FindBy(xpath="//input[@name='search']")
	private WebElement search;
	
	@FindBy(linkText="HP LP3065")
	private WebElement Hp;
	
	@FindBy(xpath="//button[@class='btn btn-default btn-lg']")
	private WebElement clickonsearchbutton;
	
	@FindBy(xpath="//p[contains(text(),'There is no product that matches the search criter')]")
	private WebElement notfoundproductHonda;
	
	public SearchPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	public void productFound(String productName)
	{
		search.sendKeys(productName);
		clickonsearchbutton.click();			
	}
	public void productNotFound(String productName)
	{
		search.sendKeys(productName);
		clickonsearchbutton.click();		
	}
	public boolean hpproductstatus()
	{
		boolean HpProductFound=Hp.isDisplayed();
		return HpProductFound;

	}
	public boolean hondaproductstatus()
	{
		boolean HondaProductFound=notfoundproductHonda.isDisplayed();
		return HondaProductFound;
	}

	
	

}
