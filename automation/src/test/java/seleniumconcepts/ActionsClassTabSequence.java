package seleniumconcepts;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.chrome.ChromeDriver;

public class ActionsClassTabSequence {
	    static WebDriver driver;
	public static void main(String[] args) {
		driver=new ChromeDriver();
		
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/register");
		WebElement firstName=driver.findElement(By.id("input-firstname"));
		
		Actions act=new Actions(driver);
		act.sendKeys(firstName, "Aditya")
		.sendKeys(Keys.TAB)
		.pause(500)
		.sendKeys("Sharma")
		.sendKeys(Keys.TAB)
		.pause(500)
		.sendKeys("adityasharma@gmail.com")
		.sendKeys(Keys.TAB)
		.pause(500)
		.sendKeys("9087563456")
		.sendKeys(Keys.TAB)
		.pause(500)
		.sendKeys("sharma@123")
		.sendKeys(Keys.TAB)
		.pause(500)
		.sendKeys("sharma@123")
		.sendKeys(Keys.TAB)
		.pause(500)
		.sendKeys(Keys.TAB)
		.pause(500)
		.sendKeys(Keys.TAB)
		.pause(500)
		.sendKeys(Keys.SPACE)
		.pause(500)
		.sendKeys(Keys.ENTER)
		.perform();
		
		
	}

}
