package seleniumconcepts;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class DropDownHandling {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		driver.get("https://orangehrm.com/contact-sales");
		By countryDrp=By.name("Country");
		WebElement ele= driver.findElement(countryDrp);
		Select country=new Select(ele);
//		country.selectByValue("Monaco");
//		Thread.sleep(5000);
//		country.selectByValue("Aruba");
//		Thread.sleep(5000);
//		country.selectByIndex(15);
		country.getOptions();
		
		
	    ElementUtil eu=new ElementUtil(driver);
//		eu.dropdownHandlingByValue(countryDrp,"Morocco");
//		eu.dropdownHandlingByIndex(countryDrp, 15);
//		eu.dropdownHandlingByVisibleText(countryDrp, "Mali");
//		System.out.println(eu.getDropdownOptionCount(countryDrp));
//		
//		List<String> optionList=eu.dropdownOptionsTextList(countryDrp);
//		System.out.println(optionList);
//     
//		List<WebElement> countryElementList=eu.getDropdownOptionList(countryDrp);
//		 for(WebElement countryEle:countryElementList){
//		    if(countryEle.getText().equalsIgnoreCase("India")) {
//		    	countryEle.click();
//		    	break;
//		   
//		  }		
//		
//		eu.selectOptionFromDropdownList(countryDrp,"pakistan");
		List<String> expectedList=new ArrayList<String>();
		expectedList.add("India");
		expectedList.add("Brazil");
		expectedList.add("Austria");
		System.out.println(expectedList);
		
		if(eu.getDropdownOptionList(countryDrp).containsAll(expectedList)) {
			System.out.println("these countries are present");
		}else {
			System.out.println("these countries are not present");
		}
		
		
		

	}
	
	
	
}

