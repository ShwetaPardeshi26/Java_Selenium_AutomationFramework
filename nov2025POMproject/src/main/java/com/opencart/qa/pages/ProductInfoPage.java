package com.opencart.qa.pages;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.opencart.qa.utils.AppConstants;
import com.opencart.qa.utils.ElementUtil;

public class ProductInfoPage {
	
	WebDriver driver;
	ElementUtil eleUtil;
	Map<String,String> productMap;
	
	public ProductInfoPage(WebDriver driver) {
		this.driver=driver;
		eleUtil= new ElementUtil(driver);
	}
	
	private final By header=By.cssSelector("div#content h1");
	private final By images=By.cssSelector("ul.thumbnails>li img");
	private final By quantity=By.id("input-quantity");
	private final By addToCart=By.id("button-cart");
	private final By productMetadata=By.xpath("(//div[@id='content']//ul[@class='list-unstyled'])[1]/li");
	private final By priceMetadata=By.xpath("(//div[@id='content']//ul[@class='list-unstyled'])[2]/li");
	
	
	public String getHeaderText() {
		String headerText=eleUtil.doGetElementText(header);
		return headerText;
	}
	
	public int getImagesCount() {
		int imageCount=eleUtil.waitForAllElementsVisible(images, AppConstants.MEDIUM_TIME_OUT).size();
		System.out.println("total image count for image : "+getHeaderText()+" :  "+imageCount);
		return imageCount;
	}
//	Brand: Apple
//	Product Code: Product 18
//	Reward Points: 800
//	Availability: Out Of Stock
	
	private void getProductMetadata() {
		List<WebElement> productMetadataList=driver.findElements(productMetadata);
		
		
		for(WebElement ele:productMetadataList) {
			String[] data=ele.getText().split(":");
			String productKey=data[0].trim();
			String productValue=data[1].trim();
			productMap.put(productKey, productValue);
		}
		System.out.println(productMap);
	}
	
//	$2,000.00
//	Ex Tax: $2,000.00
	private void getProductPrize() {
		List<WebElement> priceList = driver.findElements(priceMetadata);
		String productPrice=priceList.get(0).getText().trim();
		String productExTaxPrice  =  priceList.get(1).getText().split(":")[1].trim();
		productMap.put("productPrice", productPrice) ;
		productMap.put("productExTaxPrice", productExTaxPrice);
		
	}
	
	public Map<String, String> getProductInfoData() {
		//productMap=new HashMap<String,String>();
		//productMap=new LinkedHashMap<String,String>();
		productMap=new TreeMap<String,String>();
		productMap.put("productname", getHeaderText());
		productMap.put("imageCount",String.valueOf(getImagesCount()));
		getProductMetadata();
		getProductPrize();
		System.out.println("product information : \n"+productMap);
		return productMap;
	}

	
	

}
