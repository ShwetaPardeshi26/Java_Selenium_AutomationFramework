package seleniumconcepts;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BigbasketMoveToElement {
   static WebDriver driver;
	public static void main(String[] args) throws InterruptedException {
		driver =new ChromeDriver();
		driver.get("https://www.bigbasket.com/?utm_source=google&utm_medium=cpc&utm_campaign=Brand-PAN-Jan25&gad_source=1&gad_campaignid=22175835974&gbraid=0AAAAA91V9opq2PgwxhRHc94MW0V7EJEOE&gclid=CjwKCAjwnN3OBhA8EiwAfpTYerH2kMjfm6wW4e64GpQ6L2QIroHJFybdC82xzUorbh01FD3Eg4P6vhoCq8IQAvD_BwE");
		
		By shopByCategory=By.xpath("//button[@id='headlessui-menu-button-:Ramkj6:']");
		By foodCourt=By.linkText("Food Court");
		By coldBeverages=By.linkText("Cold Beverages");
		By icedTea=By.linkText("Iced Tea");
		
		ElementUtil eu=new ElementUtil(driver);
		eu.handleMenu(shopByCategory, foodCourt, coldBeverages, icedTea);

}
}
