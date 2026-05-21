package com.opencart.qa.test;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.opencart.qa.utils.AppConstants;
import com.opencart.qa.utils.CsvUtil;
import com.opencart.qa.utils.ExcelUtil;

public class RegisterPageTest  extends BaseTest {
	@BeforeClass
	public void regSetUp() {
		registerpage=loginpage.navigateToRegisterationPage();
	}

	
	@DataProvider
	public Object[][] getUserRegExcelTestData(){
		return ExcelUtil.getTestData(AppConstants.REGISTER__SHEET_NAME);
	}
	
	@DataProvider
	public Object[][] getUserRegCSVTestData(){
		return CsvUtil.csvData(AppConstants.REGISTER__SHEET_NAME);
	}
	
	
	@DataProvider(name="registerTestData")
	public Object[][] registerationData() {
		return new Object[][] {
			{"gaurav","sharma","78634523546","gaurav@123","yes"},
			{"ram","sharma","90634523546","ram@123","no"},
			{"raveena","verma","9056783421","raveena@123","yes"},
			{"rani","man","78634523546","rani@123","yes"},
		};
	}
	
	@Test(dataProvider="getUserRegExcelTestData")
	public void userRegisterTest(String firstname,String lastname,String telephone,String password,String subscriber) throws InterruptedException {
	    Assert.assertTrue(registerpage.userRegisteration(firstname, lastname,telephone, password,subscriber));
	}
	

}
