package com.jbkoffline.qa.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.jbkoffline.qa.util.TestUtil;
import com.jbkoffline.qa.util.WebEventListener;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

public class TestBase {
	
	public static WebDriver driver;
	public static Properties prop;
	public static EventFiringWebDriver e_driver;
	public static WebEventListener eventListener;
	public static Logger log;
	
	public static ExtentReports extent;
	 public static ExtentTest logger;

	
	public TestBase() {
		
		log= Logger.getLogger("TestBase");
		 PropertyConfigurator.configure("log4j.properties");
		
		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream("E:\\jbk_work\\HybridFrameworkAdminLTE\\src\\main\\java\\com\\jbkoffline\\qa\\config\\config.properties");
			prop.load(ip);				
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}
	 
	
public static void initialization() {
			 
	String browserName = prop.getProperty("browser");
	
	if (browserName.equals("chrome")) {
		log.info("******************************Launching the Chrome******************************");
		System.setProperty("webdriver.chrome.driver", "E:\\java\\chromedriver.exe");
		driver = new ChromeDriver();
	} 
	else if (browserName.equals("FF"))
	{
		System.setProperty("webdriver.gecko.driver", "E:\\java\\Selenium Software\\geckodriver.exe");
		driver = new FirefoxDriver();	
	}	
	
	e_driver = new EventFiringWebDriver(driver);
	// Now create object of EventListerHandler to register it with EventFiringWebDriver
	eventListener = new WebEventListener();
	e_driver.register(eventListener);
	driver = e_driver;
	
	
//	extent = new ExtentReports (System.getProperty("user.dir") +"/test-output/JBkExtentReport.html", true);
//	 extent
//	                .addSystemInfo("Host Name", "Swapnil")
//	                .addSystemInfo("Environment", "Automation Testing")
//	                .addSystemInfo("User Name", "swapnildhakate");
//	                extent.loadConfig(new File(System.getProperty("C:\\\\Maven Projects\\\\HybridFrameworkAdminLTE\\\\extent-config.xml")+"\\extent-config.xml"));
	
	
	
	
	
	log.info("****************************Maximize the Windows*********************************");
	driver.manage().window().maximize();
	
	log.info("****************************Delete all Cookies**************************************");
	driver.manage().deleteAllCookies();
	
	log.info("****************************Page load timeout**************************************");
	driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
	
	log.info("****************************Implicit Wait********************************************");
	driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
	driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.MINUTES);
	
	log.info("*****************************Opening URL*******************************************");
	driver.get(prop.getProperty("url"));
	Boolean b=driver.equals(browserName);
	System.out.println(b); //true or false
	
	WebDriver driver= new ChromeDriver();
	
	}
}