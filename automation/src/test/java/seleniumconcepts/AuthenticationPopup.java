package seleniumconcepts;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.chrome.ChromeDriver;

public class AuthenticationPopup {

	public static void main(String[] args) {
	WebDriver driver=new ChromeDriver();
	String username="admin";
	String password="admin";
    driver.get("https://"+username+":"+password+"@"+"the-internet.herokuapp.com/basic_auth");
    
	}

}
