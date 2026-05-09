package seleniumconcepts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.chrome.ChromeDriver;
public class SendkeysWithCharsequence {

	public static void main(String[] args) {
		WebDriver driver=new ChromeDriver();
        driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/register");
        
        driver.findElement(By.id("input-firstname")).sendKeys("naveen","automation","lab");
        
        String emailPrefix="naveenautomation";
        StringBuilder uniqueValue=new StringBuilder("_testing");
        StringBuffer uniqueNumber=new StringBuffer("_123");
        driver.findElement(By.id("input-email")).sendKeys(emailPrefix,uniqueValue,uniqueNumber);
	}

}
