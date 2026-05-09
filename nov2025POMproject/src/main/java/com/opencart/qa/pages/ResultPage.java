package com.opencart.qa.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.opencart.qa.utils.AppConstants;
import com.opencart.qa.utils.ElementUtil;

public class ResultPage {
	// Initialize driver and ele util
	private WebDriver driver;
	private ElementUtil eleUtil;
	
	// page class constructor
	public ResultPage(WebDriver driver){
		this.driver=driver;
		eleUtil=new ElementUtil(driver);
	}
	//private and final locators
	private final By products=By.cssSelector("div.product-thumb");
	
   
	//public action method
	public int getSearchResultCount() {
		int resultsCount= eleUtil.waitForAllElementsVisible(products, AppConstants.MEDIUM_TIME_OUT).size();
		System.out.println("Total number of products after search :"+resultsCount);
		return resultsCount;
	}
	
	public ProductInfoPage selectProduct(String productName) {
		System.out.println("product name is : "+productName);
		eleUtil.doClick(By.linkText(productName));
		return new ProductInfoPage(driver);
	}

	
	
}
