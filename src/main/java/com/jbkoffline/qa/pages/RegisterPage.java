package com.jbkoffline.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.jbkoffline.qa.base.TestBase;

public class RegisterPage extends TestBase{
		
	@FindBy(xpath="//input[@name=\"name\"]")
	WebElement Name;
	
	@FindBy(xpath="//input[@name=\"mobile\"]")
	WebElement Mobile;
	
	@FindBy(xpath="//input[@name=\"email\"]")
	WebElement Email;
	
	@FindBy(xpath="//input[@name=\"password\"]")
	WebElement Password;
	
	@FindBy(xpath="//button[@type=\"submit\"]")
	WebElement Submit;
	
	public RegisterPage() {
		PageFactory.initElements(driver, this);		
	}
	
	public String validateRegisterPageTitle() {
		return driver.getTitle();
	}
		
	public void RegisterUser(String FName, String Number, String EmailId, String pwd) {
					
		Name.sendKeys(FName);
		Mobile.sendKeys(Number);
		Email.sendKeys(EmailId);
		Password.sendKeys(pwd);
		Submit.click();
	}
}
