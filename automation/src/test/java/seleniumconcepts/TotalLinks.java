package seleniumconcepts;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TotalLinks {

	public static void main(String[] args) {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/register");
		List<WebElement> links=driver.findElements(By.tagName("a"));
		System.out.println("total links are :"+links.size());
		for(WebElement link:links) {
			
			String ln=link.getText();
			if(ln.length() !=0 ) {
				System.out.println(ln);
			}
			
		}
		
		
		
	}

}
