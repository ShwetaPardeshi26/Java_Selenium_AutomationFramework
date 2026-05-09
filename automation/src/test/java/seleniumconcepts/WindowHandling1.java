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

public class WindowHandling1 {
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver=new ChromeDriver();
		driver.get("https://orangehrm.com/contact-sales");
		String parentId=driver.getWindowHandle();
		
		driver.findElement(By.xpath("(//button[@class='CybotCookiebotDialogBodyButton'])[3]")).click();
		Thread.sleep(3000);
		 Actions act=new Actions(driver);
		 act.sendKeys(Keys.CONTROL).sendKeys(Keys.END).perform();
		 Thread.sleep(3000);
		 driver.findElement(By.xpath("(//a[contains(text(),'Contact Us')])[3]")).click();
		 
	   Set<String> windowIds= driver.getWindowHandles();
	   
	   Iterator itr=windowIds.iterator();
	   String childId = null;
	    while(itr.hasNext()) {
	    	
	    if(itr.next() != parentId) {
	    	childId=(String) itr.next();
	    	driver.switchTo().window(childId);
	    	System.out.println("Child id is : "+childId);
	    	System.out.println(driver.getTitle());
	    }
	    act.sendKeys(Keys.CONTROL).sendKeys(Keys.END).perform();
	    Thread.sleep(3000);
	    driver.findElement(By.xpath("//a[contains(@href,'youtube')]")).click();
	    Set<String> Ids=driver.getWindowHandles();
	    Iterator<String> it= Ids.iterator();
	    while (it.hasNext()) {
			if(!it.next().equals(childId)) {
				Thread.sleep(3000);
				String childMostId=it.next();
				driver.switchTo().window(childMostId);
				System.out.println("child most id : "+childMostId);
				//Thread.sleep(3000);
				System.out.println(driver.getTitle());
			}
				
		}
	    }
		 
		
		 
		
		
	}

}
