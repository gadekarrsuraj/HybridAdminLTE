package com.jbkoffline.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.jbkoffline.qa.base.TestBase;
import com.jbkoffline.qa.pages.HomePage;
import com.jbkoffline.qa.pages.LoginPage;
import com.jbkoffline.qa.pages.UsersPage;
import com.jbkoffline.qa.util.TestUtil;

public class HomePageTest extends TestBase{
	
	LoginPage loginPage;
	HomePage homePage;
	TestUtil testUtil;
	UsersPage usersPage;
	
	public HomePageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		initialization();
		testUtil = new TestUtil();
		usersPage = new UsersPage();
		loginPage = new LoginPage();
		homePage = loginPage.login(prop.getProperty("email"), prop.getProperty("password"));	
	}
	
	@Test(priority=1)
	public void verifyHomePageTitleTest() {
		String homePageTitle = homePage.verifyHomePageTitle();
		Assert.assertEquals(homePageTitle, "AdminLTE 2 | Dashboard");
	}
	
	@Test(priority=2)
	public void verifyUsersLinkTest() {
		homePage.clickOnUsersLink();
	}
	
	@Test(priority=3)
	public void verifyOperatorsLinkTest() {
		homePage.clickOnOperatorsLink();
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit(); 
	}
	
	@Test(priority=3)
	public void verifyOperatorsLinkTest1() {
		//homePage.payment();
	}
	
}
