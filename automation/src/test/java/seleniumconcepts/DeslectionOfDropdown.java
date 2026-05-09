package seleniumconcepts;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.chrome.ChromeDriver;

public class DeslectionOfDropdown {
    static WebDriver driver;
	public static void main(String[] args) {
		driver=new ChromeDriver();
        driver.get("https://html.com/attributes/select-multiple/");
        
		WebElement ele=driver.findElement(By.tagName("select"));
		
		Select slt=new Select(ele);
		slt.selectByValue("Greater");
		slt.selectByVisibleText("Lesser flamingo");
		slt.selectByIndex(2);
		
		slt.deselectByValue("Greater");
		slt.deselectByVisibleText("Lesser flamingo");
	}

}
