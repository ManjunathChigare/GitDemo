package E2Eproject;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.ForgotPassword;
import pageObjects.LandingPage;
import pageObjects.LoginPage;
import resources.base;

public class Homepage extends base {
	public WebDriver driver;// to run the tests in parellel
	public static Logger log=LogManager.getLogger(base.class.getName());
	
	@BeforeMethod
	public void initial() throws IOException {
		driver = intializeDriver();
		driver.get(prop.getProperty("url"));
	}

	@Test(dataProvider = "getData")
	public void homepagenavigation(String Username, String Password) throws IOException, InterruptedException {

		LandingPage l = new LandingPage(driver);
//l.login.click();
		LoginPage Lp=l.login();
		//LoginPage Lp = new LoginPage(driver);
		Lp.UserName().sendKeys(Username);
		Lp.Password().sendKeys(Password);
		Lp.Login().click();
		log.info("restricted user is logged in successfully");
		//Lp.Login().click();
		ForgotPassword fp=Lp.ForgotPassword();
		fp.UserName().sendKeys("abcd");
		fp.SendMeInstruction().click();
		

	}

	@DataProvider
	public Object[][] getData() {
		// row stands for how many different data types test contains
		// coloumns stands for values for each test
		Object[][] data = new Object[2][2];
		data[0][0] = "abcedd@gmail.com";
		data[0][1] = "123456@sdd";
		data[1][0] = "abgcd@gmail.com";
		data[1][1] = "123466788";
		return data;

	}

	@AfterMethod
	public void Last() {
		driver.close();
	}

}
