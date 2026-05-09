package seleniumconcepts;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class JavascriptExecutorConcept {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.get("https://classic.crmpro.com/");
		 //driver.get("https://www.amazon.in/");
		JavascriptUtil ut = new JavascriptUtil(driver);
//		String title=ut.getTitleByJS();
//		System.out.println(title);
//		
//		String url=ut.getURLByJS();
//		System.out.println(url);
//		
//		ut.generateAlert("Hello testing");
//		
//		ut.refreshBrowserByJS();
		// ut.navigateToSpecificPage("3");

//		String pageText=ut.getPageInnerText();
//		System.out.println(pageText);

//		if(pageText.contains("Alerts & Reminders")) {
//			System.out.println("pass");
//		}else {
//			System.out.println("fail");
//		}
		// highlighting webelement
		// WebElement element=driver.findElement(By.xpath("//input[@type='submit']"));
		// ut.flash(element);
		// ut.drawBorder(element);
//		ut.scrollPageDown();
//		Thread.sleep(500);
//		ut.scrollPageUp();

		// ut.scrollPageDown("600");
		
		WebElement loginBtn=driver.findElement(By.linkText("Customers"));
		ut.clickElementByJS(loginBtn);
	}
}
