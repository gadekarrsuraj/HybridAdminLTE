package com.jbkoffline.qa.testcases;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.jbkoffline.qa.base.TestBase;
import com.jbkoffline.qa.pages.HomePage;
import com.jbkoffline.qa.pages.LoginPage;
import com.jbkoffline.qa.pages.OperatorsPage;

public class OperatorsPageTest extends TestBase{
	
	LoginPage loginPage;
	HomePage homePage;
	OperatorsPage operatorsPage;
	
	public OperatorsPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		initialization();
//		testUtil = new TestUtil();
//		usersPage = new UsersPage();
		loginPage = new LoginPage();
		homePage = loginPage.login(prop.getProperty("email"), prop.getProperty("password"));	
		operatorsPage=homePage.clickOnOperatorsLink();
//		usersPage	= homePage.clickOnUsersLink();
	}
	
	@Test(priority=1)
	public void verifyOperatorsTableTest() {
		WebElement Table1 = driver.findElement(By.xpath("//div[@class='box-body table-responsive no-padding']"));
		List<WebElement> tr1 = Table1.findElements(By.tagName("tr"));
		System.out.println("total no of rows " + tr1.size());
		for (WebElement row1 : tr1) {
			List<WebElement> td1 = row1.findElements(By.tagName("td"));
			for (WebElement col1 : td1) {
				System.out.println(col1.getText());
			}
		}	
	}
	
	@Test(priority=2)
	public void LogOutTest() {
		operatorsPage.clickOnLogoutBtn();
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
}