package seleniumconcepts;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.chrome.ChromeDriver;

public class FileUpload {
public static void main(String[] args) {
	WebDriver driver=new ChromeDriver();
	driver.get("https://practice.expandtesting.com/upload");
	
	driver.findElement(By.id("fileInput")).sendKeys("D://IMP docs//Software Testing Studio//New folder//file1.txt");
	String fileName=driver.findElement(By.name("file")).getText();

	
}
}
