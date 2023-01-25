package com.tutorialsninja.qa.Page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage 
{
	WebDriver driver;
	@FindBy(id="input-firstname")
	WebElement firstName;
	
	@FindBy(xpath="//*[@id=\"input-lastname\"]")
	WebElement lastName;
	
	@FindBy(id="input-email")
	WebElement email;
	
	@FindBy(id="input-telephone")
	WebElement telephone;
	
	@FindBy(id="input-password")
	WebElement password;
	
	@FindBy(id="input-confirm")
	WebElement confirmPassword;
	
	@FindBy(xpath="//div[@class='form-group']/div/label[1]/input")
	WebElement subscribeButton;
	
	@FindBy(xpath="//input[@type='checkbox']")
	WebElement privacypolicyButton;
	
	@FindBy(xpath="//input[@class='btn btn-primary']")
	WebElement continueButton;
	
	//warning webelements when we dont provide any details
	
	@FindBy(xpath="(//div[@class='text-danger'])[1]")
	WebElement FirstNamemustbebetween1and32characters;
	
	@FindBy(xpath="(//div[@class='text-danger'])[2]")
	WebElement LastNamemustbebetween1and32characters;
	
	@FindBy(xpath="(//div[@class='text-danger'])[3]")
	WebElement EMailAddressdoesnotappeartobevalid;
	
	@FindBy(xpath="(//div[@class='text-danger'])[4]")
	WebElement Telephonemustbebetween3and32characters;
	
	@FindBy(xpath="(//div[@class='text-danger'])[5]")
	WebElement Passwordmustbebetween4and20characters;
	
	
	
	public RegisterPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	/*public void enterFirstName(String FirstName)
	{
		firstName.sendKeys(FirstName);
		
	}
	public void enterLastName(String LastName)
	{
		lastName.sendKeys(LastName);
	}
	public void enterEmail(String Email)
	{
		email.sendKeys(Email);
	}
	public void enterTelephone(String TelephoneNumber)
	{
		telephone.sendKeys(TelephoneNumber);
	}
	public void enterPassword(String PassWord)
	{
		password.sendKeys(PassWord);
	}
	public void enterConfirmPassword(String ConfirmPassword)
	{
		confirmPassword.sendKeys(ConfirmPassword);
	}
	public void clickonPrivacypolicyButton()
	{
		privacypolicyButton.click();
	}*/
	public void clickonContinueButton()
	{
		continueButton.click();
		
	}
	public AccountSuccess navigatetoAccountSuccessFromRegisterPage(String FirstName, String LastName,String Email,String TelephoneNumber,String PassWord,String ConfirmPassword) 
	{
		firstName.sendKeys(FirstName);
		lastName.sendKeys(LastName);
		email.sendKeys(Email);
		telephone.sendKeys(TelephoneNumber);
		password.sendKeys(PassWord);
		confirmPassword.sendKeys(ConfirmPassword);
		privacypolicyButton.click();
		continueButton.click();
		return new AccountSuccess(driver);
	}public AccountSuccess navigatetoAccountSuccessFromRegisterPagewithallfield(String FirstName, String LastName,String Email,String TelephoneNumber,String PassWord,String ConfirmPassword) 
	{
		firstName.sendKeys(FirstName);
		lastName.sendKeys(LastName);
		email.sendKeys(Email);
		telephone.sendKeys(TelephoneNumber);
		password.sendKeys(PassWord);
		confirmPassword.sendKeys(ConfirmPassword);
		subscribeButton.click();
		privacypolicyButton.click();
		continueButton.click();
		return new AccountSuccess(driver);
	}
	
		
	//Warning msg Actions
	/*public String WarningforFirstName()
	{
		String warfirstname = FirstNamemustbebetween1and32characters.getText();
		return warfirstname;
	}
	public String WarningforLastName()
	{
		String warlastname = LastNamemustbebetween1and32characters.getText();
		return warlastname;
	}
	public String WarningforEmail()
	{
		String waremail = EMailAddressdoesnotappeartobevalid.getText();
		return waremail;
	}
	public String WarningforTelephone()
	{
		String warTelephone = Telephonemustbebetween3and32characters.getText();
		return warTelephone;
	}
	public String Warningforpassword()
	{
		String warPassword = Passwordmustbebetween4and20characters.getText();
		return warPassword;
		
	}*/
	public boolean warningmessageStatusWithoutfillAnyDetails(String expectedfirstname, String expectedlastname,String expectedemail,String expectedtelephone,String expectedpassword)
	{
		//String actualfirstname = FirstNamemustbebetween1and32characters.getText();
		boolean firstnamewarningstatus=FirstNamemustbebetween1and32characters.getText().contains(expectedfirstname);
		
		//String actuallastname = LastNamemustbebetween1and32characters.getText();
		boolean lastnamewarningstatus=LastNamemustbebetween1and32characters.getText().contains(expectedlastname);
		
		//String actualemail = EMailAddressdoesnotappeartobevalid.getText();
		boolean emailwarningstatus=EMailAddressdoesnotappeartobevalid.getText().contains(expectedemail);
		
		//String actualTelephone = Telephonemustbebetween3and32characters.getText();
		boolean telephonewarningstatus=Telephonemustbebetween3and32characters.getText().contains(expectedtelephone);
		
		//String actualPassword = Passwordmustbebetween4and20characters.getText();
		boolean passwordwarningstatus=Passwordmustbebetween4and20characters.getText().contains(expectedpassword);

		return firstnamewarningstatus && lastnamewarningstatus && emailwarningstatus && telephonewarningstatus && passwordwarningstatus;
	}
	
	

}
