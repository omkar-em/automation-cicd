package com.onecomics.testcases;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.onecomics.base.BaseClass;
import com.onecomics.webpages.LandingPage;
import com.onecomics.webpages.LoginPage;

public class LoginPageTest extends BaseClass{
	
	LoginPage loginpage;
	
	@BeforeMethod
	public void initialSetup() {
		loginpage = new LoginPage();		
	}
	
	@Test
	public void verifyLoginPage() throws InterruptedException {
		loginpage.login("kunal.anarse@eminds.ai", "Test@1234");
	}

}
