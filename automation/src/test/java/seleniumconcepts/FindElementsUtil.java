package seleniumconcepts;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FindElementsUtil {
	static WebDriver driver;
	public static void main(String[] args) {
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		driver.get("https://orangehrm.com/contact-sales");
		By links=By.tagName("a");
		By images=By.tagName("img");
		By countryOptions=By.xpath("//select[@name='Country']/option");

		System.out.println(getElements(links));
		int totalLinks=getElementCount(links);
		System.out.println("count is :"+totalLinks);
		List<String> textList=dropdownOptionsTextList(countryOptions);
		System.out.println(textList);
	}
	
	public static List<String> dropdownOptionsTextList(By locator) {
		List<WebElement> list=getElements(locator);
		int totalOpts=getElements(locator).size();
		List<String> textList=new ArrayList<String>();
		for(WebElement l:list) {
			String text=l.getText();
			textList.add(text);
		}
		return textList;
	}
	
    public static int  getElementCount(By locator) {
    	return getElements(locator).size();
    }
	public static List<WebElement> getElements(By locator) {
		return driver.findElements(locator);
	}

}
