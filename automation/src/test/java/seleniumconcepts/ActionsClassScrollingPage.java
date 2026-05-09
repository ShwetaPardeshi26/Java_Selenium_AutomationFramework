package seleniumconcepts;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.chrome.ChromeDriver;

public class ActionsClassScrollingPage {
	    static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {
		driver=new ChromeDriver();
		
		driver.get("https://www.amazon.in/");
		Thread.sleep(5000);
		Actions act=new Actions(driver);
		//partial scrolling
//		act.sendKeys(Keys.PAGE_DOWN).perform();
//		Thread.sleep(3000);
//		act.sendKeys(Keys.PAGE_UP).perform();
		
		//scroll to the footer of the page
//		act.sendKeys(Keys.CONTROL).sendKeys(Keys.END).perform();
//		Thread.sleep(5000);
//		act.sendKeys(Keys.CONTROL).sendKeys(Keys.HOME).perform();
		
		//scrool to paerticular element
		act.scrollToElement(driver.findElement(By.linkText("Careers"))).pause(3000)
		.click(driver.findElement(By.linkText("Help"))).perform();
		
		
		
	}

}
