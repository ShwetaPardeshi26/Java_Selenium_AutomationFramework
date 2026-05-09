package seleniumconcepts;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.chrome.ChromeDriver;

public class ActionsClassSendkeysWithPause {
	    static WebDriver driver;
	public static void main(String[] args) {
		driver=new ChromeDriver();
		
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/register");
        By firstName=By.id("input-firstname");
		Actions act=new Actions(driver);
		
		String value="Naveen Automation";	
		ElementUtil eu=new ElementUtil(driver);
		eu.sendkeysWithPause(firstName,value,500);
		
//		char[] val=value.toCharArray();
//		for(char v:val) {
//			act.sendKeys(firstName, String.valueOf(v)).pause(500).perform();
//		}
//		
//		}
//	public static WebElement getElement(By locator) {
//		return driver.findElement(locator);
//		
//	}
	
//	public static void sendkeysWithPause(By locator, String value,int pauseTime) {
//		Actions act=new Actions(driver);
//		char[] arr=value.toCharArray();
//		
//		for(char a:arr) {
//			act.sendKeys(getElement(locator),String.valueOf(a)).pause(pauseTime).perform();
//		}
//	}

	}
}
