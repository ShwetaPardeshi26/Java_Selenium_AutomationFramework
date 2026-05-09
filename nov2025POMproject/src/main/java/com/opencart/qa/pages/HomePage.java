package com.opencart.qa.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.opencart.qa.utils.AppConstants;
import com.opencart.qa.utils.ElementUtil;

public class HomePage{
	// Initialize driver and ele util
			private WebDriver driver;
			private ElementUtil eleUtil;
			
		// page class constructor
			public HomePage(WebDriver driver) {
				this.driver = driver;
				eleUtil = new ElementUtil(driver);
			}
			
		// Private and final by locators
			private final By LogoutLink=By.linkText("Logout");
			private final By headers=By.cssSelector("div#content h2");
			private final By searchField=By.name("search");
			private final By searchIcon=By.cssSelector(".btn.btn-default.btn-lg");
			
		// Public page actions/methods
			public String getHomePageTitle() {
				String actTitle = eleUtil.waitForTitleContains(AppConstants.HOME_PAGE_TITLE, AppConstants.SHORT_TIME_OUT);
				System.out.println("Title of Home page is :" + actTitle);
				return actTitle;
			}
			public boolean isLogoutLinkVisible() {
				return eleUtil.isElementDisplayed(LogoutLink);
			}
			
			public List<String> getHomePageHeaders() {
				List<WebElement> headersList=eleUtil.waitForAllElementsPresence(headers, AppConstants.SHORT_TIME_OUT);
				List<String> headerValueList=new ArrayList();
				for(WebElement header:headersList) {
					String headerTextString=header.getText();
					headerValueList.add(headerTextString);
				}
				System.out.println(headerValueList);
				return headerValueList;
			}
			
			public ResultPage doSearch(String searchKey) {
				System.out.println("search key is :"+searchKey);
				eleUtil.doSendKeys(searchField, searchKey, AppConstants.SHORT_TIME_OUT);
				eleUtil.doClick(searchIcon);
				return new ResultPage(driver);
			}
			
}
