package com.jbkoffline.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.jbkoffline.qa.base.TestBase;

public class UsersPage extends TestBase{

	@FindBy(xpath="//h1[contains(text(),'Users')]")
	WebElement usersLabel;
	
	@FindBy(xpath="\"//table[@class='table table-hover']\"")
	WebElement userTable;
	
	@FindBy(id="username")
	WebElement Username;
	
	@FindBy(id="mobile")
	WebElement Mobile;
	
	@FindBy(id="email")
	WebElement Email;
	
	@FindBy(xpath="//input[@value=\"Male\"]")
	 WebElement Gender;
	
	@FindBy(xpath="//input[@id='password']")
	WebElement Password;
	
	@FindBy(xpath="//button[@type=\"submit\"]")
	WebElement Submit;
		
	public UsersPage() {
		PageFactory.initElements(driver, this);
	}
	
	public boolean verifyUsersLabel() {
		return usersLabel.isDisplayed();
	}
	
	/*public boolean getTableData() {
		
		WebElement Table = driver.findElement(By.xpath("//table[@class='table table-hover']"));
		List<WebElement> tr = Table.findElements(By.tagName("tr"));
		System.out.println("total no of rows " + tr.size());
		for (WebElement row : tr) {
			List<WebElement> td = row.findElements(By.tagName("td"));
			for (WebElement col : td) {
				System.out.println(col.getText());
			}

		return userTable.isDisplayed();
	}
		return false;
*/	

	public void addNewUser(String Uname, String MobNumber,String emailId,String SelectState,String Pwd) {
		
		Username.sendKeys(Uname);
		Mobile.sendKeys(MobNumber);
		Email.sendKeys(emailId);
		Gender.click();		
		Select select = new Select(driver.findElement(By.xpath("//select[@class=\"form-control\"]")));
		select.selectByVisibleText(SelectState);
		
		Password.sendKeys(Pwd);
		Submit.click();
		
	}
	
}
