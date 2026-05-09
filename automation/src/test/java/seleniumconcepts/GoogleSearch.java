package seleniumconcepts;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class GoogleSearch {
     static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {
		driver=new ChromeDriver();
		
		driver.get("https://www.google.com/");
		By googleSearchEle=By.name("q");
		By autosuggestValues=By.xpath("//div[@class='wM6W7d']/span");
		
		ElementUtil eu=new ElementUtil(driver);
		eu.doSendKeys(googleSearchEle,"selenium");
		Thread.sleep(5000);
		eu.autoSuggestDropdown(autosuggestValues, "maven dependency");
		
		
//		List<WebElement> autoSuggestWebElements=eu.getElements(autosuggestValues);
//		System.out.println(autoSuggestWebElements.size());
//		
//		for(WebElement autoSuggestEle:autoSuggestWebElements) {
//			
//			String autoSuggestText=autoSuggestEle.getText();
//			if(autoSuggestText.length()!=0) {
//				System.out.println(autoSuggestText);
//				if(autoSuggestText.contains("java")) {
//					autoSuggestEle.click();
//					break;
//				}
//			}
//			
//		}
		

	}
	
	
	}


