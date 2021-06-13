package resources;

import java.io.File;
import java.io.FileInputStream;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.io.FileHandler;

public class base {

	public WebDriver driver;

	public static Properties prop;

	public WebDriver intializeDriver() throws IOException {
		prop = new Properties();
		// hardcoding the project path
		// FileInputStream fis = new FileInputStream("C:\\Users\\Manjunath
		// Chigare\\eclipse-workspaceNew\\E2Eproject\\src\\main\\java\\resources\\data.properties");
		// dynamic generation of project path
		FileInputStream fis = new FileInputStream(
				System.getProperty("user.dir") + "\\src\\main\\java\\resources\\data.properties");
		prop.load(fis);

		// String browser=System.getProperty("browser");// triggering from the jenkins

		String browser = prop.getProperty("browser");
		System.out.println(browser);
		if (browser.equals("chrome")) {
			// System.setProperty("webdriver.chrome.driver",
			// "C:\\Users\\Manjunath Chigare\\chromedriver_win32 (2)\\chromedriver.exe");
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")
					+ "\\src\\main\\java\\resources\\chromedriver_win32 (2)\\chromedriver.exe");

			driver = new ChromeDriver();

		} else if (browser.equals("IE")) {
			System.setProperty("webdriver.ie.driver",
					"C:\\Users\\Manjunath Chigare\\Downloads\\IEDriverServer_Win32_2.39.0\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();
		} else if (browser.equals("fireFox")) {
			System.setProperty("webdriver.gecko.driver", "C:\\Users\\Manjunath Chigare\\Documents\\geckodriver.exe");
			driver = new FirefoxDriver();
		}
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		return driver;
	}

	public String takeScreenshot(String testMethodName, WebDriver driver) throws IOException

	{
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		String destination = System.getProperty("user.dir") + "\\reports\\" + testMethodName + ".png";
		FileUtils.copyFile(source, new File(destination));
		return destination;
	}

	/*
	 * public void takeScreenshot() { String screenName= System.currentTimeMillis()+
	 * ".png"; File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	 * try { FileHandler.copy(src, new
	 * File(System.getProperty("user.dir")+"/target/Screenshots/"+screenName+"")); }
	 * catch(IOException e) { System.out.println(e.getMessage()); } }
	 */

}