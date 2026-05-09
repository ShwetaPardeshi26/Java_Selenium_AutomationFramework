package seleniumconcepts;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.chrome.ChromeDriver;
public class WindowHandling {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver=new ChromeDriver();
		driver.get("https://orangehrm.com/contact-sales");
		String parentWindowId=driver.getWindowHandle();
		System.out.println("parentWindowId :"+parentWindowId);
		Thread.sleep(3000);
		driver.findElement(By.xpath("(//button[@class='CybotCookiebotDialogBodyButton'])[3]")).click();
		Thread.sleep(3000);
		 Actions act=new Actions(driver);
		 act.sendKeys(Keys.CONTROL).sendKeys(Keys.END).perform();
		driver.findElement(By.linkText("Contact Us"));
		driver.findElement(By.xpath("//a[contains(@href,'youtube')]")).click();
		driver.findElement(By.xpath("//a[contains(@href,'x.com')]")).click();
		driver.findElement(By.xpath("//a[contains(@href,'linkedin')]")).click();
		driver.findElement(By.xpath("//a[contains(@href,'facebook')]")).click();
		
		Set<String> windowIds=driver.getWindowHandles();
		Iterator itr=windowIds.iterator();
		
		while(itr.hasNext()) {
			String windId=(String) itr.next();
			System.out.println("window id"+windId);
			driver.switchTo().window(windId);
			System.out.println("current url is :"+driver.getCurrentUrl());
			Thread.sleep(2000);
			if(!windId.equals(parentWindowId)) {
				driver.close();
			}
			
		}
		driver.switchTo().window(parentWindowId);
		System.out.println(driver.getTitle());
		
		
		
		
		
		
		
		

	}

}
