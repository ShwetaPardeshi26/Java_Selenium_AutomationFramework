package seleniumconcepts;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class getAttributeConcepts {


		static WebDriver driver;
		public static void main(String[] args) {
			driver=new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
			
			driver.get("https://orangehrm.com/contact-sales");
//			String attValu=driver.findElement(By.xpath("//input[@name='FullName']")).getAttribute("placeholder");
//            System.out.println(attValu);
//            driver.findElement(By.xpath("//input[@name='FullName']")).sendKeys("shweta");
//            String attValue=driver.findElement(By.xpath("//input[@name='FullName']")).getAttribute("value");
//            System.out.println(attValue);
            
            By firstName=By.xpath("//input[@name='FullName']");
            ElementUtil eu=new ElementUtil(driver);
            eu.doSendKeys(firstName,"shweta");
            String attrValue=eu.getElementAttribute(firstName,"value");
            System.out.println(attrValue);
	}
        
}
