package seleniumconcepts;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.chrome.ChromeDriver;

public class AlertHandling {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver=new ChromeDriver();
		driver.get("https://the-internet.herokuapp.com/javascript_alerts");
		
		//Normal Popup
//		driver.findElement(By.xpath("//button[text()='Click for JS Alert']")).click();
//		Thread.sleep(3000);
//		driver.switchTo().alert().accept();
		
		//confirmation popup
//		driver.findElement(By.xpath("//button[text()='Click for JS Confirm']")).click();
//		Thread.sleep(3000);
		//driver.switchTo().alert().accept();
		//driver.switchTo().alert().dismiss();
//		Alert alt=driver.switchTo().alert();
//		System.out.println(alt.getText());
//		alt.accept();
		
		//Prmpt popup
		driver.findElement(By.xpath("//button[text()='Click for JS Prompt']")).click();
		Alert alt=driver.switchTo().alert();
		Thread.sleep(3000);
		alt.sendKeys("automation");
		System.out.println(alt.getText());
		alt.accept();
		//alt.dismiss();

	}

}
