package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	public WebDriver driver;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	private By username = By.id("user_email");
	private By password = By.id("user_password");
	private By Login = By.xpath("//input[@type='submit']");
	private By ForgotPassword = By.cssSelector("a[href*='password/new']");

	public WebElement UserName() {
		return driver.findElement(username);
	}

	public WebElement Password() {
		return driver.findElement(password);
	}

	public WebElement Login() {
		return driver.findElement(Login);
	}

	public ForgotPassword ForgotPassword() {
		driver.findElement(ForgotPassword).click();
		return new ForgotPassword(driver);

	}

}
