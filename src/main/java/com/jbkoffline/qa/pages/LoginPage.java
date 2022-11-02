package com.jbkoffline.qa.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.jbkoffline.qa.base.TestBase;

public class LoginPage extends TestBase{
	
	
	
		
	@FindBy(id="email")
	WebElement email;
	
	@FindBy(id="password")
	WebElement password;
	
	@FindBy(xpath="//button[@id=\"submit\"]")
	WebElement signInBtn;
	
	@FindBy(css="button#submit")
	WebElement CSS_signInBtn;
	
	@FindBy(xpath="//a[@href=\"pages/examples/register.html\"]")
	WebElement RegisterLink;
	
	@FindBy(xpath="html/body/div[1]/div[1]/a")
	WebElement urlLogo;
	
	
	
	public LoginPage() {		
		PageFactory.initElements(driver, this);		
	}
	
	
	
		public String validateLoginPageTitle() {
		log.info("Verifying the Login Page Title :>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		return driver.getTitle()	;
		
	}

	public boolean validateUrlLogo(){
		log.info("Verifying the URL Logo :>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		return urlLogo.isDisplayed();
	}
	
	public RegisterPage clickOnRegisterLink() {
		RegisterLink.click();
		return new RegisterPage();
	}
	
	public HomePage login(String un, String pwd) {
		log.info("Entering Username And Password :>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		email.sendKeys(un);
		password.sendKeys(pwd);
		
		//loginBtn.click();
    	JavascriptExecutor js = (JavascriptExecutor)driver;
    	js.executeScript("arguments[0].click();", signInBtn);
		return new HomePage();
	}		
}
