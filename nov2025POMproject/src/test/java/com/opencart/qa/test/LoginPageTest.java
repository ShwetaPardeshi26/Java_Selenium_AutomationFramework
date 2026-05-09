package com.opencart.qa.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.opencart.qa.pages.HomePage;
import com.opencart.qa.utils.AppConstants;

public class LoginPageTest extends BaseTest{
     @Test
     public void LoginPageTitleTest() {
    	Assert.assertEquals(loginpage.getLoginPageTitle(), AppConstants.LOGIN_PAGE_TITLE);
     }
     @Test
     public void LoginPageURLTest() {
       Assert.assertTrue(loginpage.getLoginPageURL().contains(AppConstants.LOGIN_PAGE_URL));
     }
     @Test
     public void forwardPwdLinkExitTest() {
    	Assert.assertTrue(loginpage.isForgotPwdLinkExist());
     }
     @Test(priority=Integer.MAX_VALUE)
     public void loginTest() {
    	 homepage =loginpage.doLogin(prop.getProperty("username").trim(),prop.getProperty("password").trim());
    	 Assert.assertEquals(homepage.getHomePageTitle(), AppConstants.HOME_PAGE_TITLE);
     }
}
