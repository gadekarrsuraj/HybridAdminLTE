package com.jbkoffline.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.jbkoffline.qa.base.TestBase;

public class OperatorsPage extends TestBase {
	
	@FindBy(xpath="//span[contains(text(),'Operators')]")
	WebElement Operators;
	
	@FindBy(xpath="//a[@href=\"logout.html\"]")
	WebElement LogoutLink;
	
	public OperatorsPage() {
		PageFactory.initElements(driver, this);
	}
	
	public void clickOnOperators() {
		
		Operators.click();		
	}
	
	public LoginPage clickOnLogoutBtn() {
		log.info("Click On the Logout Button  :>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		LogoutLink.click();
		return new LoginPage();
	}
	
}
