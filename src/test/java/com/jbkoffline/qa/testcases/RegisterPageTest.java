package com.jbkoffline.qa.testcases;

import org.openqa.selenium.Alert;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.jbkoffline.qa.base.TestBase;
import com.jbkoffline.qa.pages.LoginPage;
import com.jbkoffline.qa.pages.RegisterPage;
import com.jbkoffline.qa.util.TestUtil;

public class RegisterPageTest extends TestBase {
	LoginPage loginPage;
	RegisterPage registerPage;
	
	public RegisterPageTest() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		initialization();
		loginPage=new LoginPage();
		registerPage=loginPage.clickOnRegisterLink();		
	}
	
	@Test(priority=1)
	public void verifyRegisterPageTitleTest() {
		log.info("Verifying Register Page Title :>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		String registerPageTitle = registerPage.validateRegisterPageTitle();
		Assert.assertEquals(registerPageTitle, "AdminLTE 2 | Registration Page");
	}
	
	@DataProvider
	public Object[][] RegisterUserData(){
		Object data[][] = TestUtil.getTestData("register");
		return data;
	}
	
	@Test(priority=2 , dataProvider="RegisterUserData")
	public void EnterRegisterUserDetails(String Name, String Mobile, String Email,String Password) throws Exception {
		log.info("Entering Register User Details :>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
	registerPage.RegisterUser(Name,Mobile,Email,Password);
	
	@SuppressWarnings("unused")
	Alert alt2 = driver.switchTo().alert();
	Thread.sleep(1000);
	System.out.println(driver.switchTo().alert().getText());
	driver.switchTo().alert().accept();
}
		
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
