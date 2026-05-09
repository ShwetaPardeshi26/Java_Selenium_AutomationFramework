package seleniumconcepts;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class MouseOperation {
	static WebDriver driver;
	public static void main(String[] args) {
		driver= new ChromeDriver();
		driver.get("https://www.spicejet.com/");
		By parentLocator=By.xpath("//div[text()='Add-ons']");
		By childLocattor=By.xpath("//div[text()='Visa Services']");
		
		ElementUtil eu=new ElementUtil(driver);
		eu.handleMenu(parentLocator, childLocattor);
		
//		WebElement parentLoc=driver.findElement(By.xpath("//div[text()='Add-ons']"));
//		Actions act=new Actions(driver);
//		act.moveToElement(parentLoc).perform();
//		WebElement childLoc=driver.findElement(By.xpath("//div[text()='Visa Services']"));
//		
//		childLoc.click();
		
		
		

	}
	public static WebElement getElement(By locator) {
		return driver.findElement(locator);
	}
	
	public static void handleMenu(By parentLocator,By childLocator) {
		Actions act=new Actions(driver);
		act.moveToElement(getElement(parentLocator)).perform();
		getElement(childLocator).click();
	}

}
