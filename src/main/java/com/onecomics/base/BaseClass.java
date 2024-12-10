package com.onecomics.base;

import java.io.FileInputStream;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;


import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	
	public static Properties prop;
	public static WebDriver driver;
	
	@BeforeSuite
	public void loadConfig() {
		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream (System.getProperty("user.dir") + "/configuration/config.properties");
			prop.load(ip);
		}
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		catch (IOException e) {
			e.printStackTrace();
		}		
	}
	
	public static void launchApp() {
		String browserName = prop.getProperty("browser");
		try {				
		if (browserName.contains("Chrome")){
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--headless", "--disable-gpu");
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver(options);
		}
		else if (browserName.contains("FireFox")){
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}
		else if (browserName.contains("IE")){
			WebDriverManager.iedriver().setup();
			driver = new InternetExplorerDriver();
		}
		
		driver.get(prop.getProperty("url"));
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		}
		catch (WebDriverException e) {
			System.err.println("WebDriverException");
	            throw new RuntimeException();
		}
	}
	
	@BeforeSuite
	public void setup() {
		launchApp();
	}
	
	@AfterSuite
	public void tearDown() {
		driver.quit();
	}

}
