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
	OptionsManager optionmanger;
	WebDriver driver;
	Properties prop;
	public static String highlight;
	public static ThreadLocal<WebDriver> tlDriver=new ThreadLocal<>();
	
	/**
	 * This method is used to initialize the driver on the basis of given browsername
	 * @param browserName
	 * @return it returns the driver value
	 */
	
	public WebDriver initDriver(Properties prop) {
		String browserName=prop.getProperty("browser");
		System.out.println("Browser name is : "+browserName);
		highlight=prop.getProperty("highlight");
		optionmanger=new OptionsManager(prop);
		
		switch(browserName.trim().toLowerCase()){
		case "chrome":
			tlDriver.set(new ChromeDriver(optionmanger.getChromeOptions()));
			//driver=new ChromeDriver(optionmanger.getChromeOptions());
			break;
		case "firefox":
			tlDriver.set(new FirefoxDriver(optionmanger.getFirefoxOptions()));
			//driver=new FirefoxDriver(optionmanger.getFirefoxOptions());
			break;
		case "edge":
			tlDriver.set(new EdgeDriver(optionmanger.getEdgeOptions()));
			//driver=new EdgeDriver(optionmanger.getEdgeOptions());
			break;
		case "safari":
			tlDriver.set(new SafariDriver());
			//driver=new SafariDriver();
			break;
		default :
			System.out.println("=====Invalid Browser====="+browserName);
			throw new BrowserException("=====Invalid Browser=====");
		}
		getDriver().manage().window().maximize();
		getDriver().manage().deleteAllCookies();
		getDriver().get(prop.getProperty("url"));
		return getDriver();
	}
	/**
	 * this will return local copy of driver for a specific thread
	 */
	public static WebDriver getDriver() {
		return tlDriver.get();
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
