package com.opencart.qa.utils;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.opencart.qa.factory.DriverFactory;

//parallel execution will not be possible with static
public class ElementUtil {
	private WebDriver driver;
	private Actions act;
	private JavascriptUtil jsUtil;

	public ElementUtil(WebDriver driver) {
		this.driver = driver;
		act = new Actions(driver);
		jsUtil=new JavascriptUtil(driver);
	}

	public WebElement getElement(By locator) {
		WebElement element=driver.findElement(locator);
		if(Boolean.parseBoolean(DriverFactory.highlight)){
			jsUtil.flash(element);
		}
		return element;
	}
	
	public WebElement getElement(By locator,long timeout) {
		try {
		return driver.findElement(locator);
		}catch(NoSuchElementException e){
			System.out.println("Element is not found using :"+locator);
				e.printStackTrace();
				return waitForElementVisible(locator,timeout);
		}
	}
	public void doClear(By locator) {
		getElement(locator).clear();
	}

	public void doSendKeys(By locator, String value) {
		doClear(locator);
		getElement(locator).sendKeys(value);
	}
	public void doSendKeys(By locator, String value,long timeout) {
		doClear(locator);
		getElement(locator,timeout).sendKeys(value);
	}

	public String doGetElementText(By locator) {
		return getElement(locator).getText();
	}

	public String getElementAttribute(By locator, String attrName) {
		return getElement(locator).getAttribute(attrName);
	}

	public void doClick(By locator) {
		getElement(locator).click();
	}

	public boolean isElementDisplayed(By locator) {
		try {
			return getElement(locator).isDisplayed();
		} catch (NoSuchElementException e) {
			System.out.println("Not able to find elemnet with locator :" + locator);
			e.printStackTrace();
			return false;
		}

	}

	public List<String> dropdownOptionsTextList(By locator) {
		List<WebElement> list = getElements(locator);
		int totalOpts = getElements(locator).size();
		List<String> textList = new ArrayList<String>();
		for (WebElement l : list) {
			String text = l.getText();
			textList.add(text);
		}
		return textList;
	}

	public int getElementCount(By locator) {
		return getElements(locator).size();
	}

	public List<WebElement> getElements(By locator) {
		return driver.findElements(locator);
	}

	// *****************************Select Class Utils************************//
	private Select getSelect(By locator) {
		return new Select(getElement(locator));

	}

	public void dropdownHandlingByIndex(By locator, int index) {
		getSelect(locator).selectByIndex(index);
	}

	public void dropdownHandlingByVisibleText(By locator, String visibleText) {
		getSelect(locator).selectByVisibleText(visibleText);
	}

	public void dropdownHandlingByValue(By locator, String value) {
		getSelect(locator).selectByVisibleText(value);
	}

	public List<WebElement> getDropdownOptionList(By locator) {
		return getSelect(locator).getOptions();
	}

	public int getDropdownOptionCount(By locator) {
		return getDropdownOptionList(locator).size();
	}

	public List<String> getDropdownOptionText(By locator) {
		List<WebElement> optionList = getDropdownOptionList(locator);
		List<String> optionTextList = new ArrayList<String>();
		for (WebElement option : optionList) {
			String text = option.getText();
			optionTextList.add(text);
		}
		return optionTextList;
	}

	public void selectOptionFromDropdownList(By locator, String value) {
		List<WebElement> drpEleList = getDropdownOptionList(locator);
		for (WebElement drpEle : drpEleList) {
			if (drpEle.getText().equalsIgnoreCase(value)) {
				drpEle.click();
				break;
			}
		}
	}

	// *******************MultiSelectDropdowmn**********************//
	/**
	 * This method is able to handle 3 testcases TC 1: Single selection EX. Choice 2
	 * TC 2: Multi selection EX: "choice 2","choice 6 2","choice 2" TC 3: All choice
	 * selection EX: Enter "all" as a choice
	 */

	public void selectChoicesFromMultiSelectDropdown(By locator, String... choiceValue) {
		List<WebElement> drpChoiceList = getElements(locator);

		if (choiceValue[0].trim().toLowerCase().contains("all")) {
			for (WebElement ele : drpChoiceList) {
				ele.click();
			}
		} else {
			for (WebElement drpChoice : drpChoiceList) {
				String drpChoiceText = drpChoice.getText();

				for (String choice : choiceValue) {
					if (drpChoiceText.trim().equals(choice)) {
						drpChoice.click();
						break;
					}
				}
			}
		}
	}

	// *****************Auto Suggest DropDownn********************//

	public void autoSuggestDropdown(By locator, String suggestionValue) {
		List<WebElement> autoSuggestWebElements = getElements(locator);
		System.out.println(autoSuggestWebElements.size());

		for (WebElement autoSuggestEle : autoSuggestWebElements) {

			String autoSuggestText = autoSuggestEle.getText();
			if (autoSuggestText.length() != 0) {
				System.out.println(autoSuggestText);
				if (autoSuggestText.contains(suggestionValue)) {
					autoSuggestEle.click();
					break;
				}
			}

		}
	}

	// *************************Actions class utility********************//

	public void doActionsClick(By locator) {
		act.click(getElement(locator)).perform();
	}

	public void doActionsSendkeys(By locator, String value) {
		act.sendKeys(getElement(locator), value).perform();
	}

	/*
	 * this method is used to handle menu options upto 2 levels acception 2 params :
	 * parent locator and child locator
	 */
	public void handleMenu(By parentLocator, By childLocator) {
		act.moveToElement(getElement(parentLocator)).perform();
		doClick(childLocator);
	}

	public void handleMenu(By menu1, By menu2, By menu3, By menu4) throws InterruptedException {
		doClick(menu1);
		Thread.sleep(2000);
		act.moveToElement(getElement(menu2)).perform();
		Thread.sleep(2000);
		act.moveToElement(getElement(menu3)).perform();
		Thread.sleep(2000);
		doClick(menu4);
	}

	public void sendkeysWithPause(By locator, String value, long pauseTime) {
		char[] arr = value.toCharArray();

		for (char a : arr) {
			act.sendKeys(getElement(locator), String.valueOf(a)).pause(pauseTime).perform();
		}
	}

	// explicit wait utilities
	/**
	 * An expectation for checking that there is at least one element is present on a webpage
	 * @param locator
	 * @param timeout
	 * @return
	 */
	public List<WebElement> waitForAllElementsPresence(By locator,long timeout){
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(timeout));
		try {
		return wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator));
		}catch(TimeoutException e) {
			return Collections.EMPTY_LIST;
		}
	}
	/**
	 * An expectation for checking all elements are present on the homepage	that match the locator are visible
	 * @param locator
	 * @param timeout
	 * @return
	 */
	
	public List<WebElement> waitForAllElementsVisible(By locator,long timeout){
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(timeout));
		try {
		return wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
		}catch(TimeoutException e) {
			//e.printStackTrace();
			return Collections.EMPTY_LIST;
		}
	}
	public String waitForTitleContains(String titleValue, long timeout) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
		try {
			wait.until(ExpectedConditions.titleContains(titleValue));
			return driver.getTitle();
		} catch (TimeoutException e) {
			System.out.println(titleValue + " is not found");
			e.printStackTrace();
			return null;
		}
	}

	public String waitForTitleIs(String titleValue, long timeout) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
		try {
			wait.until(ExpectedConditions.titleIs(titleValue));
			return driver.getTitle();
		} catch (TimeoutException e) {
			System.out.println(titleValue + " is not found");
			e.printStackTrace();
			return null;
		}
	}

	private Alert waitForAlert(long timeout) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
		return wait.until(ExpectedConditions.alertIsPresent());
	}

	public String waitForURLContains(String urlValue, long timeout) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
		try {
			wait.until(ExpectedConditions.urlContains(urlValue));

		} catch (TimeoutException e) {
			System.out.println(urlValue + " is not found");
			e.printStackTrace();
		}
		return driver.getCurrentUrl();
	}

	public String waitForURLToBe(String urlValue, long timeout) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
		try {
			wait.until(ExpectedConditions.urlToBe(urlValue));
		} catch (TimeoutException e) {
			System.out.println(urlValue + " is not found");
			e.printStackTrace();
		}
		return driver.getCurrentUrl();
	}
	public WebElement  waitForElementVisible(By locator, long timeout) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
		try {
			wait.until(ExpectedConditions.visibilityOf(getElement(locator)));
		} catch (TimeoutException e) {
			System.out.println(  "element is not visible");
			e.printStackTrace();
		}
		return getElement(locator) ;
	}

}
