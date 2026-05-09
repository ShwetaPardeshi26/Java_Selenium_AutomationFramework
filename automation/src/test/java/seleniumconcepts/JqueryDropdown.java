package seleniumconcepts;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class JqueryDropdown {
	 static WebDriver driver;
public static void main(String[] args) {
     driver=new ChromeDriver();
     driver.get("https://www.jqueryscript.net/demo/Drop-Down-Combo-Tree/");
     
     By multiSelectDrp=By.id("justAnInputBox");
     By dropDownChoices=By.xpath("(//div[@class='comboTreeDropDownContainer'])[1]//li/span[@class='comboTreeItemTitle']");
     
     ElementUtil eu=new ElementUtil(driver);
     
     eu.doClick(multiSelectDrp);
     //eu.selectChoicesFromMultiSelectDropdown(dropDownChoices, "ALL");
    // eu.selectChoicesFromMultiSelectDropdown(dropDownChoices,"choice 4","choice 6 2 1","choice 5","choice 6 2");
     eu.selectChoicesFromMultiSelectDropdown(dropDownChoices,"choice 4");
     
     //     List<WebElement> drpChoiceList=eu.getElements(dropDownChoices);
//     for(WebElement drpChoice:drpChoiceList) {
//    	if(drpChoice.getText().equalsIgnoreCase("choice 4") || drpChoice.getText().equalsIgnoreCase("choice 6 2 1") ||  drpChoice.getText().equalsIgnoreCase(",")) {
//    		drpChoice.click();
//    	}
//     }
     
     
}
//public static void selectChoicesFromMultiSelectDropdown(By locator, String choice) {
// List<WebElement> drpChoiceList=eu.getElements(locator);
//   for(WebElement drpChoice:drpChoiceList) {
//	   String drpChoiceText=drpChoice.getText();
//	   if(drpChoiceText.trim().equals(choice)) {
//		   drpChoice.click();
//		   break;
//	   }
//   }
//}
}
