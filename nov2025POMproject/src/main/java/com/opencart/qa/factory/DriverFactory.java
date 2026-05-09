package com.opencart.qa.factory;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import com.opencart.qa.exceptions.BrowserException;

public class DriverFactory {
	
	WebDriver driver;
	Properties prop;
	public static String highlight;
	/**
	 * This method is used to initialize the driver on the basis of given browsername
	 * @param browserName
	 * @return it returns the driver value
	 */
	
	public WebDriver initDriver(Properties prop) {
		String browserName=prop.getProperty("browser");
		System.out.println("Browser name is : "+browserName);
		
		highlight=prop.getProperty("highlight");
		
		switch(browserName.trim().toLowerCase()){
		case "chrome":
			driver=new ChromeDriver();
			break;
		case "firefox":
			driver=new FirefoxDriver();
			break;
		case "edge":
			driver=new EdgeDriver();
			break;
		case "safari":
			driver=new SafariDriver();
			break;
		default :
			System.out.println("=====Invalid Browser====="+browserName);
			throw new BrowserException("=====Invalid Browser=====");
		}
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get(prop.getProperty("url"));
		return driver;
	}
	/**This method is used to initialize properties file
	 * @return it returns properties class cobject which is having all the properties (key-value pair)
	 */
	
	public Properties initProp() {
		try {
			FileInputStream fis=new FileInputStream("./src/test/resources/config/config.properties");
			prop=new Properties();
			prop.load(fis);
		} catch (FileNotFoundException e) {
		   e.printStackTrace();
		}catch(IOException e) {
			e.printStackTrace();
		}
		return prop;
	}
	

}
