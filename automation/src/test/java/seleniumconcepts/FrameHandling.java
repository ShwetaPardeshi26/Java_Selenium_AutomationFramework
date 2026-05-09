package seleniumconcepts;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.chrome.ChromeDriver;

public class FrameHandling {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver=new ChromeDriver();
		driver.get("https://classic.crmpro.com/");
	    Thread.sleep(3000);
	    driver.findElement(By.name("username")).sendKeys("apiautomation");
	    driver.findElement(By.name("password")).sendKeys("Selenium@12345");
	    driver.findElement(By.xpath("//input[@type='submit']")).click();
	    Thread.sleep(3000);
	    driver.switchTo().frame("mainpanel");
	    WebElement ele=driver.findElement(By.linkText("CONTACTS"));
	    Actions act=new Actions(driver);
	    act.moveToElement(ele).perform();
	    Thread.sleep(3000);
	    driver.findElement(By.linkText("New Contact")).click();
	    Thread.sleep(3000);
	    driver.findElement(By.name("first_name")).sendKeys("naveen automation");
	    
		

	}

}
