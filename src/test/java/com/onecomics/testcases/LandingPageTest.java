package com.onecomics.testcases;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.onecomics.base.BaseClass;
import com.onecomics.webpages.LandingPage;

public class LandingPageTest extends BaseClass{
	
	LandingPage landingpage;
	
	@BeforeMethod
	public void initialSetup() {
		landingpage = new LandingPage();		
	}
	
	@Test (priority = 1)
	public void verifyLandingPageNavigations() throws InterruptedException {
		landingpage.landingPageNavigations();
	}
	
	@Test (priority = 2)
	public void verifyHamburgerMenuNavigations() throws InterruptedException {
		landingpage.hamburgerMenuNavigations();
	}

}
