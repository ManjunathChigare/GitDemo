package E2Eproject;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import org.testng.annotations.Test;

import pageObjects.LandingPage;

import resources.base;

public class validationNavbar extends base {
	
	public WebDriver driver;// to run the tests in parellel
	public static Logger log = LogManager.getLogger(base.class.getName());

	@BeforeTest
	public void initial() throws IOException {
		driver = intializeDriver();
		driver.get(prop.getProperty("url"));
	}

	@Test
	public void navigationBar() throws IOException {

		LandingPage l = new LandingPage(driver);
		Assert.assertTrue(l.navbar().isDisplayed());
		log.info("navbar is displaying");

	}

	@AfterTest
	public void Last() {
		driver.close();
	}

}
