package seleniumconcepts;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class JavascriptUtil {
	private WebDriver driver;

	public JavascriptUtil(WebDriver driver) {
		this.driver = driver;
	}

	public String getTitleByJS() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		return js.executeScript("return document.title").toString();
	}

	public String getURLByJS() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		return js.executeScript("return document.URL").toString();
	}

	public void refreshBrowserByJS() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("history.go(0)");
	}

	public void navigateToBackPage() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("history.go(-1)");
	}

	public void navigateToForwaqrdPage() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("history.go(1)");
	}

	public void navigateToSpecificPage(String pageNumber) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("history.go('" + pageNumber + "')");
	}

	public void generateAlert(String message) throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("alert('" + message + "')");
		Thread.sleep(3000);
		driver.switchTo().alert().accept();
	}

	public String getPageInnerText() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		return js.executeScript("return document.documentElement.innerText;").toString();
	}
//for highlighting element
	public void flash(WebElement element) {
		String bgcolor = element.getCssValue("backgroundColor");
		for (int i = 0; i < 100; i++) {
			changeColor("rgb(0,200,0)", element);
			changeColor(bgcolor, element);
		}

	}

	private void changeColor(String color, WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].style.backgroundColor = '" + color + "'", element);
		try {
			Thread.sleep(30);
		} catch (InterruptedException e) {

		}
	}
	//for drawing border
	public void drawBorder(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].style.border='3px solid red'", element);
	}
	//scrolling of page
	
		public void scrollPageDown() {
		    JavascriptExecutor js = (JavascriptExecutor) driver;
		    js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
		}

		public void scrollPageUp() {
		    JavascriptExecutor js = (JavascriptExecutor) driver;
		    js.executeScript("window.scrollTo(document.body.scrollHeight, 0)");
		}

		public void scrollPageDown(int height) {
		    JavascriptExecutor js = (JavascriptExecutor) driver;
		    js.executeScript("window.scrollTo(0, '"+height+"')");
		}

		public void scrollIntoView(WebElement element) {
		    JavascriptExecutor js = (JavascriptExecutor) driver;
		    js.executeScript("arguments[0].scrollIntoView(true));", element);
		}
		//click method
		public void clickElementByJS(WebElement element) {
		    JavascriptExecutor js = (JavascriptExecutor) driver;
		    js.executeScript("arguments[0].click();", element);
		}
		
}
