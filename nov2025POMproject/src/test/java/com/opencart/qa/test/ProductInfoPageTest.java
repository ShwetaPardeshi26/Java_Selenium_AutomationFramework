package com.opencart.qa.test;

import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class ProductInfoPageTest extends BaseTest {
	
	@BeforeClass
	public void ProductInfoPageSetUp() {
		homepage =loginpage.doLogin(prop.getProperty("username").trim(),prop.getProperty("password").trim());
	}
	
	@DataProvider(name="ProductTestData")
	public Object[][] productTestData(){
		return new Object[][] {
			{"macbook","MacBook"},
			{"macbook","MacBook Air"},
			{"macbook","MacBook Pro"},
			{"imac","iMac"},
			{"canon","Canon EOS 5D"}
		};
		
	}
	
	@Test(dataProvider="ProductTestData")
	public void productHeaderTest(String searchKey,String productName) {
		resultpage = homepage.doSearch(searchKey);
		productinfopage=resultpage.selectProduct(productName);
		System.out.println("searchKey : "+searchKey+" : productName : "+productName);
		Assert.assertEquals(productinfopage.getHeaderText(),productName);
	}
	
	@DataProvider(name="ProductImagesTestData")
	public Object[][] productImagesTestData(){
		return new Object[][] {
			{"samsung","Samsung SyncMaster 941BW",1},
			{"macbook","MacBook Air",4},
			{"macbook","MacBook Pro",4},
			{"imac","iMac",3},
			{"canon","Canon EOS 5D",3}
		};
		
	}
	
	
	@Test(dataProvider="ProductImagesTestData")
	public void imageCountTest(String searchKey,String productName,int imageCount) {
		resultpage = homepage.doSearch(searchKey);
		productinfopage=resultpage.selectProduct(productName);
		Assert.assertEquals(productinfopage.getImagesCount(),imageCount);
	}
	//Product Code: Product 18
//	Reward Points: 800
//	Availability: Out Of Stock
	
	@Test
	public void productInfoTest() {
		resultpage = homepage.doSearch("macbook");
		productinfopage=resultpage.selectProduct("MacBook Pro");
		Map<String,String> productInfoData= productinfopage.getProductInfoData();
		
		SoftAssert softassert=new SoftAssert();
		
		softassert.assertEquals(productInfoData.get("productname"),"MacBook Pro" );
		softassert.assertEquals(productInfoData.get("imageCount"),"4" );
		softassert.assertEquals(productInfoData.get("Brand"),"Apple" );
		softassert.assertEquals(productInfoData.get("Product Code"),"Product 18" );
		softassert.assertEquals(productInfoData.get("Reward Points"),"800" );
		softassert.assertEquals(productInfoData.get("Availability"),"Out Of Stock" );
		softassert.assertEquals(productInfoData.get("productPrice"),"$2,000.00" );
		softassert.assertEquals(productInfoData.get("productExTaxPrice"),"$2,000.00" );
		softassert.assertAll();
		
	
	}

}
