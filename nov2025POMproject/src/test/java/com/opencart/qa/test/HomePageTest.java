package com.opencart.qa.test;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.opencart.qa.utils.AppConstants;
import com.opencart.qa.utils.ElementUtil;

public class HomePageTest extends BaseTest{
	
	@BeforeClass
	public void homePageSetup() {
		 homepage =loginpage.doLogin(prop.getProperty("username").trim(),prop.getProperty("password").trim());
	}
	
	@Test
	public void homePageTitleTest() {
	  Assert.assertEquals(homepage.getHomePageTitle(),AppConstants.HOME_PAGE_TITLE);
	}
    @Test
	public void logoutLinkExistTest() {
		Assert.assertTrue(homepage.isLogoutLinkVisible());
	}
    @Test
    public void headerTest() {
    	List<String> actualHeadersList=homepage.getHomePageHeaders();
    	Assert.assertEquals(actualHeadersList, AppConstants.HEADER_HOMEPAGE_LIST);
    }
    @DataProvider
    public Object[][] searchTestDataProvider() {
    	return new Object[][] {
    			{"macbook",3},
    			{"imac",1},	
    			{"airtel",0},
    			{"canon",1},
    			{"samsung",2}
    	};
    }
    @Test(dataProvider="searchTestDataProvider")
    public void searchTest(String searchKey,int resultsCount) {
    	resultpage = homepage.doSearch(searchKey);
    	Assert.assertEquals(resultpage.getSearchResultCount(),resultsCount);
    }
    
  
    }	

