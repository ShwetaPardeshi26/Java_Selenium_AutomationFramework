package com.opencart.qa.test;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.opencart.qa.factory.DriverFactory;
import com.opencart.qa.pages.HomePage;
import com.opencart.qa.pages.LoginPage;
import com.opencart.qa.pages.ProductInfoPage;
import com.opencart.qa.pages.ResultPage;

public class BaseTest {
   WebDriver driver;
   DriverFactory df;
   Properties prop;
   protected LoginPage loginpage;
   protected HomePage homepage;
   protected ResultPage resultpage;
   protected ProductInfoPage productinfopage;
   
   @Parameters({"browser"})
   @BeforeTest
   public void setup(@Optional("chrome") String browserName) {
	   df=new DriverFactory();
	   prop=df.initProp();
	   if(browserName != null) {//browser name is coming from xml file
		   prop.setProperty("browser",browserName );
		   }
	   driver=df.initDriver(prop);
	   loginpage=new LoginPage(driver);
	  
   }
   @AfterTest
    public void tearDown() {
	   driver.quit();
   }
   
   
}
