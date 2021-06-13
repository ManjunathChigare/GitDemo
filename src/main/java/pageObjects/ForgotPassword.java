package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class ForgotPassword {

	public WebDriver driver;

	public ForgotPassword(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	private By Email = By.id("user_email");
	private By SendMeInstruction = By.xpath("//input[@type='submit']");
	// By ForgotPassword=By.cssSelector("a[href*='password/new']");

	public WebElement UserName() {
		return driver.findElement(Email);
	}

	public WebElement SendMeInstruction() {
		return driver.findElement(SendMeInstruction);
	}

}
