package com.onecomics.webpages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.onecomics.projectmethods.ProjectMethods;

public class LandingPage extends ProjectMethods {
		
	 public LandingPage() {
		 PageFactory.initElements(driver, this);
	 }
	 
	 String winHandleBefore = null;
	 
	 @FindBy(xpath = "//select[@id=\"localization\"]")
	 public static WebElement languageTranslation;
	 
	 @FindBy(xpath = "//span[@class=\"font-barlow-condensed\"]")
	 public static WebElement moreInfo;
	 
	 @FindBy(xpath = "//span[normalize-space()=\"Back to Top\"]")
	 public static WebElement topPageNavigation;
	 
	 @FindBy(xpath = "//option[@value=\"th\"]")
	 public static WebElement thaiLanguage;
	 
	 @FindBy(xpath = "//option[@value=\"en\"]")
	 public static WebElement englishLanguage;
	 
	 @FindBy(xpath = "//button[@class=\"cursor-pointer AppBar_hamburgerButton__9qk_m\"]")
	 public static WebElement hamburgerMenu;
	 
	 @FindBy(xpath = "//a[normalize-space()=\"ABOUT ONE CHAMPIONSHIP\"]")
	 public static WebElement aboutOneChampionship;
	 
	 @FindBy(xpath = "//a[normalize-space()=\"ABOUT SUI\"]")
	 public static WebElement aboutSUI;
	 
	 @FindBy(xpath = "//a[normalize-space()=\"ABOUT WALRUS\"]")
	 public static WebElement aboutWalrus;
	 
	 @FindBy(xpath = "//div[normalize-space()=\"NEED SUPPORT?\"]")
	 public static WebElement needSupport;
	 
	 @FindBy(xpath = "//a[normalize-space()=\"TERMS & CONDITIONS\"]")
	 public static WebElement termsAndConditions;
	 
	 @FindBy(xpath = "//a[normalize-space()=\"PRIVACY POLICY\"]")
	 public static WebElement privacyPolicy;
	 
	 public void landingPageNavigations() throws InterruptedException {	 
		 Assert.assertTrue(waitUntilTextIsPresent("Rodtang - Iron Will")); 
		 Assert.assertTrue(waitUntilTextIsPresent("More About ONE Comics"));
		 clickElement(moreInfo);
		 clickElement(topPageNavigation);
		 clickElement(languageTranslation);
		 clickElement(thaiLanguage);
		 clickElement(englishLanguage);
		 Thread.sleep(2000);
	 }
	 
	 public void hamburgerMenuNavigations() throws InterruptedException {
		 winHandleBefore = driver.getWindowHandle();

		 clickElement(hamburgerMenu);		 
		 validateNewWindow(aboutOneChampionship, winHandleBefore, "Aiming to showcase");
		 clickElement(hamburgerMenu);
		 validateNewWindow(aboutSUI, winHandleBefore, "Build Beyond");
		 clickElement(hamburgerMenu);
		 validateNewWindow(aboutWalrus, winHandleBefore, "Announcing Testnet");
		 clickElement(hamburgerMenu);
		 validateNewWindow(needSupport, winHandleBefore, "");
		 clickElement(hamburgerMenu);
		 validateNewWindow(termsAndConditions, winHandleBefore, "Terms and Conditions");
		 clickElement(hamburgerMenu);
		 validateNewWindow(privacyPolicy, winHandleBefore, "PRIVACY POLICY");
	 }

}

