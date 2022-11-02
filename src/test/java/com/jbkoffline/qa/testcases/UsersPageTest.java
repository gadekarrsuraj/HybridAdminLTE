package com.jbkoffline.qa.testcases;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.jbkoffline.qa.base.TestBase;
import com.jbkoffline.qa.pages.HomePage;
import com.jbkoffline.qa.pages.LoginPage;
import com.jbkoffline.qa.pages.UsersPage;
import com.jbkoffline.qa.util.TestUtil;

public class UsersPageTest extends TestBase{
	
	LoginPage loginPage;
	HomePage homePage;
	TestUtil testUtil;
	UsersPage usersPage;
	
	public UsersPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		initialization();
		testUtil = new TestUtil();
		usersPage = new UsersPage();
		loginPage = new LoginPage();
		homePage = loginPage.login(prop.getProperty("email"), prop.getProperty("password"));	
		usersPage	= homePage.clickOnUsersLink();
	}
	
	@Test(priority=1)
	public void verifyUsersPageLabelTest() {
		log.info("Verifying Users Page Title :>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		Assert.assertTrue(usersPage.verifyUsersLabel(),"users label missing on the page");
	}
	
	@DataProvider
	public Object[][] getAddUserData(){
		Object data[][] = TestUtil.getTestData("user");
		return data;
	}
	
	
	@Test(priority=2, dataProvider="getAddUserData")
	public void validateAddNewUsersTest(String Username, String Mobile, String Email, String State, String Password) throws InterruptedException {
		
		log.info("Entering New Users Details :>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
		
		homePage.clickOnAddUserLink();
	//	driver.findElement(By.xpath("//input[@id=\"Male\"]")).click();
		usersPage.addNewUser(Username, Mobile, Email,State,Password);
			
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