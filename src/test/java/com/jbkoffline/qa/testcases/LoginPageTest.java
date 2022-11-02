package com.jbkoffline.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.jbkoffline.qa.base.TestBase;
import com.jbkoffline.qa.pages.HomePage;
import com.jbkoffline.qa.pages.LoginPage;

public class LoginPageTest extends TestBase {
	LoginPage loginPage;
	HomePage homePage;
	
	
	public LoginPageTest() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		initialization();
		loginPage = new LoginPage();
		log.info("***********************************Opening Browser*********************************");
			
	}
	
	@Test(priority=1)
	public void loginPageTitleTest() {
		
		String title = loginPage.validateLoginPageTitle();
		Assert.assertEquals(title, "AdminLTE 2 | Log in");		
	}
	
	@Test(priority=2)
	public void urlLogoTest() {
		
		boolean flag = loginPage.validateUrlLogo();
		Assert.assertTrue(flag);				
	}
	
	@Test(priority=3)
	public void loginTest() {
		
		homePage = loginPage.login(prop.getProperty("email"), prop.getProperty("password"));
	}
			
	@AfterMethod
	public void tearDown() {
		log.info("***********************************Closing Browser*********************************");
		driver.quit();
	}
}
