package seleniumconcepts;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class HeadlessConcept {
	//headless : no browser, advantages :speed is better,does not block other work
	//headless can not be possible for safari browser

	public static void main(String[] args) {
		ChromeOptions co=new ChromeOptions();
		//co.addArguments("--headless");
		//co.addArguments("--incognito");
		
		List<String> optList=new ArrayList<String>();
		optList.add("--headless");
		optList.add("--incognito");
		co.addArguments(optList);
		
		
//		FirefoxOptions fo=new FirefoxOptions();
//		fo.addArguments("--headless");
// 		fo.addArguments("--incognito");
//		
//      EdgeOptions eo=new EdgeOptions();
//		eo.addArguments("--headless");
//		eo.addArguments("--InPrivate");
		
		WebDriver driver=new ChromeDriver(co);
        driver.get("https://www.google.com");
        driver.getCurrentUrl();
        System.out.println(driver.getTitle());
        
	}

}
