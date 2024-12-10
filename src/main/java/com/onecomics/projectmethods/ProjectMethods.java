package com.onecomics.projectmethods;

import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.Reporter;

import com.onecomics.base.BaseClass;

public class ProjectMethods extends BaseClass{
	
	public void clickElement (WebElement element) throws InterruptedException {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].setAttribute('style', 'border: 2px solid red;');", element);
		((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
		Thread.sleep(1000);
		element.click();
	}
	
	public WebDriver getDriver() {
		return driver;
	}
	
	public boolean waitUntilTextIsPresent(String validationText) {
		int searchFlag=0;
		int attemptCount = 1;
		int maxAttempts = 11;
		int sleepInterval = 1000;
			Reporter.log("Searching for := "+ validationText,true);	
		if (isTitleTextPresentCaseInsenstive(validationText)) {
			System.out.println("Page Title for " + validationText + " is true");
			Reporter.log("Page Title for " + validationText + " is true");
			searchFlag=1;
		} else {
				
			foundIt:
			while (attemptCount <= maxAttempts ) {
				if (isPageSourceTextPresentCaseInsensitive(validationText)) {
					Reporter.log("Page Source for " + validationText + " is true",true);
					searchFlag=1;
					break foundIt;
				} else {					
					try {
						Thread.sleep(sleepInterval);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				attemptCount++;
			}		
		}	
		if (searchFlag==0) {
			Reporter.log("Page Source for " + validationText + " is not found",true);
			Assert.assertTrue(false);
		}
		return (attemptCount <= maxAttempts) ? true : false;
	}
	
	public boolean isTitleTextPresentCaseInsenstive(String value) {
		return getDriver().getTitle().toLowerCase().contains(value.toLowerCase());
	}
	
	public boolean isPageSourceTextPresentCaseInsensitive(String value) {
		return getDriver().getPageSource().toLowerCase().contains(value.toLowerCase());
	}
	
	public void sendKeys (WebElement element, String text) throws InterruptedException {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].setAttribute('style', 'border: 2px solid red;');", element);
		Thread.sleep(1000);
		element.sendKeys(text);
	}
	
	public void checkPageIsReady() throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		// Initially below if condition will check ready state of page.
		if (js.executeScript("return document.readyState").toString().equals("complete")) {
			Thread.sleep(500);
			System.out.println("Page loaded.");
			return;
		}
		// This loop will iterate for 120 times to check If page Is ready after
		// every 1second.
		// We can replace the value 120 if we need to increase or decrease wait
		// time.
		for (int i = 0; i < 240; i++) {
			try {
				Thread.sleep(5000);
				System.out.println("Waiting for page to load");
			} catch (InterruptedException e) {
			}
			// To check page ready state.
			if (js.executeScript("return document.readyState").toString().equals("complete")) {
				break;
			}
		}
	}
	
	public boolean validateBrowser2(String winHandleBefore, String validateContent) throws InterruptedException {
		checkPageIsReady();
		driver.getWindowHandles();

		Set<String> allHandles = driver.getWindowHandles();
		for (String currentHandle : allHandles) {
			if (!currentHandle.equals(winHandleBefore)) {
				driver.switchTo().window(currentHandle);
				System.out.println(driver.switchTo().window(currentHandle).getTitle());
				Assert.assertTrue(waitUntilTextIsPresent(validateContent));
				Reporter.log("Displayed message : " + validateContent + " successfully",true);
				break;
			}
		}
		driver.close();
		driver.switchTo().window(winHandleBefore);
		return false;
	}
	
	public void navigateBack() throws InterruptedException {
		driver.navigate().back();
		checkPageIsReady();
	}
	
	public boolean validateNewWindow(WebElement element, String winHandleBefore, String validateContent) throws InterruptedException {
		checkPageIsReady();
		driver.getWindowHandles();
		
		 Actions action = new Actions(driver);
		 action.keyDown(Keys.CONTROL).moveToElement(element).click().perform();

		Set<String> allHandles = driver.getWindowHandles();
		for (String currentHandle : allHandles) {
			if (!currentHandle.equals(winHandleBefore)) {
				driver.switchTo().window(currentHandle);
				System.out.println(driver.switchTo().window(currentHandle).getTitle());
				Assert.assertTrue(waitUntilTextIsPresent(validateContent));
				Reporter.log("Displayed message : " + validateContent + " successfully",true);
				break;
			}
		}
		driver.close();
		driver.switchTo().window(winHandleBefore);
		return false;
	}
	
}