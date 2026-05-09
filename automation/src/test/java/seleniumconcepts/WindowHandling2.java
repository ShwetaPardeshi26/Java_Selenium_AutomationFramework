package seleniumconcepts;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.chrome.ChromeDriver;

public class WindowHandling2 {

	public static void main(String[] args) throws InterruptedException {
	WebDriver driver=new ChromeDriver();
    driver.get("https://orangehrm.com/contact-sales");
    String parentId=driver.getWindowHandle();
    //driver.switchTo().newWindow(WindowType.TAB);
    driver.switchTo().newWindow(WindowType.WINDOW);
    driver.get("https://www.google.com");
    System.out.println(driver.getTitle());
    Thread.sleep(3000);
    driver.close();
    driver.switchTo().window(parentId);
    System.out.println(driver.getTitle());
    
    }

}
