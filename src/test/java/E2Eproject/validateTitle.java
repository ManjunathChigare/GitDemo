package E2Eproject;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;



import pageObjects.LandingPage;
import resources.base;

//@Listeners(E2Eproject.Listener.class)
public class validateTitle extends base {
	public WebDriver driver;// to run the tests in parellel
	public static Logger log=LogManager.getLogger(base.class.getName());
	@BeforeTest
	public void initial() throws IOException {
		driver = intializeDriver();
		driver.get(prop.getProperty("url"));
	}

	@Test
	public void validation() throws IOException {
		
		LandingPage l = new LandingPage(driver);
		Assert.assertEquals(l.title().getText(), "FEATURED COURSES");
		log.info("title is displaying");
		// l.title().getText()
		System.out.println("project 1");
		System.out.println("project 2");

	}

	@AfterTest
	public void Last() {
		driver.close();
	}
	


}
