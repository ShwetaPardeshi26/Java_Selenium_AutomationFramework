package com.opencart.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.opencart.qa.utils.AppConstants;
import com.opencart.qa.utils.ElementUtil;
import com.opencart.qa.utils.JavascriptUtil;
import com.opencart.qa.utils.StringUtils;

public class RegisterPage {

	private WebDriver driver;
	private ElementUtil eleUtil;
	
	public RegisterPage(WebDriver driver) {
		this.driver=driver;
		eleUtil = new ElementUtil(driver);
	}
	
    private final By firstName=By.id("input-firstname");
    private final By lastName= By.id("input-lastname");
    private final By email=By.id("input-email");
    private final By telephone=By.id("input-telephone");
    
    private final By password=By.id("input-password");
    private final By confirmPassword =By.id("input-confirm");
    	
    private final By subscribeYes=By.xpath("(//label[@class='radio-inline'])[position()=1]/input[@type='radio']");
    private final By subscribeNo=By.xpath("(//label[@class='radio-inline'])[position()=2]/input[@type='radio']");
    
    private final By agreeCheckbox=By.xpath("//input[@type='checkbox']");
    private final By continueButton=By.xpath("//input[@type='submit']");
    private final By succMessage=By.xpath("//div[@id='content']/h1");
    private final By logoutLink=By.xpath("(//a[text()='Logout'])[2]");
    private final By registerLink=By.xpath("(//a[text()='Register'])[2]");
    
    public boolean userRegisteration(String firstName,String lastName,String telephone,
    	String password,String subscribe) throws InterruptedException {
    	eleUtil.waitForElementVisible(this.firstName,AppConstants.LONG_TIME_OUT).sendKeys(firstName);
    	eleUtil.doSendKeys(this.lastName,lastName);
    	eleUtil.doSendKeys(this.email, StringUtils.getRandomEmailId());
    	eleUtil.doSendKeys(this.telephone, telephone);
    	eleUtil.doSendKeys(this.password, password);
    	eleUtil.doSendKeys(this.confirmPassword, password);
    	if(subscribe.equalsIgnoreCase("yes")) {
    		eleUtil.doClick(subscribeYes);
    	}else {
    		eleUtil.doClick(subscribeNo);
    	}
    	eleUtil.doClick(agreeCheckbox);
    	eleUtil.doClick(continueButton);
    	String successMsg=eleUtil.waitForElementVisible(succMessage, AppConstants.MEDIUM_TIME_OUT).getText();
    	if(successMsg.contains(AppConstants.REGISTRATION_SUCCESS_MESSAGE)) {
    		eleUtil.doClick(logoutLink);
    		eleUtil.doClick(registerLink);
    		return true;
    	}
    		return false;
    	
    	
    } 
    
    
}
