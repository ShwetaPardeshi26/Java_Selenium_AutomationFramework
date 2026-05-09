package seleniumconcepts;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.chrome.ChromeDriver;
public class FrameHandle {

	public static void main(String[] args) {
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.londonfreelance.org/courses/frames/index.html");
		//driver.switchTo().frame(2);//index
		//driver.switchTo().frame("main");//id or name)
		driver.switchTo().frame(driver.findElement(By.xpath("//frame[@src='top.html']")));
		System.out.println(driver.findElement(By.tagName("h2")).getText());

	}

}
