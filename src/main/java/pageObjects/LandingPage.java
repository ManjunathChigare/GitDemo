package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class LandingPage {

	public WebDriver driver;

	public LandingPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	private By login = By.xpath("//span[text()='Login']");
	private By navbar = By.xpath("//ul[contains(@class,'navbar-right')]");
	private By getTitle = By.xpath("(//div[@class='text-center'])/h2");

	public LoginPage login() throws InterruptedException {
		

		driver.findElement(login).click();
		LoginPage Lp = new LoginPage(driver);
		return Lp;
	}

	public WebElement navbar() {
		// TODO Auto-generated method stub
		return driver.findElement(navbar);
	}

	public WebElement title() {
		return driver.findElement(getTitle);

	}

}
