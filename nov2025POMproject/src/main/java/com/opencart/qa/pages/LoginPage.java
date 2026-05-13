package com.opencart.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.opencart.qa.utils.AppConstants;
import com.opencart.qa.utils.ElementUtil;

public class LoginPage {
	// Initialize driver and ele util
	private WebDriver driver;
	private ElementUtil eleUtil;

	// page class constructor
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		eleUtil = new ElementUtil(driver);
	}

	// Private and final by locators
	private final By emailId = By.id("input-email");
	private final By password = By.id("input-password");
	private final By loginBtn = By.xpath("//input[@type='submit']");
	private final By forgotPswLink = By.linkText("Forgotten Password");
	private final By registerLink=By.linkText("Register");
    
	// Public page actions/methods
	public String getLoginPageTitle() {
		String actTitle = eleUtil.waitForTitleContains(AppConstants.LOGIN_PAGE_TITLE, AppConstants.SHORT_TIME_OUT);
		System.out.println("Title of page is :" + actTitle);
		return actTitle;
	}

	public String getLoginPageURL() {
			String actURL=eleUtil.waitForURLContains(AppConstants.LOGIN_PAGE_URL,AppConstants.SHORT_TIME_OUT);
			System.out.println("URL of page is :"+actURL);
			return actURL;
		}
	public boolean isForgotPwdLinkExist() {
		return eleUtil.waitForElementVisible(forgotPswLink,AppConstants.MEDIUM_TIME_OUT).isDisplayed();
	}
	public HomePage doLogin(String userName,String pwd) {
		System.out.println("Application credentials are :"+userName+ " : "+pwd);
		eleUtil.doSendKeys(emailId,userName,AppConstants.MEDIUM_TIME_OUT);
		eleUtil.doSendKeys(password, pwd);
		eleUtil.doClick(loginBtn);	
		return new HomePage(driver);
	}
	
	public RegisterPage navigateToRegisterationPage() {
		eleUtil.waitForElementReadyAndclickbale(registerLink, AppConstants.LONG_TIME_OUT);
		return new RegisterPage(driver);
	}
}
