package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import Resources.Base;

public class LoginPage
{
	WebDriver driver;
	private By email = By.cssSelector("input[id='user_email']");
	private By password =  By.cssSelector("input[id='user_password']");
	private By login =  By.cssSelector("[value='Log In']");
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public WebElement getEmail() {
		return driver.findElement(email);
	}

	public WebElement getPassword() {
		return driver.findElement(password);
	}

	public WebElement getLogin() {
		return driver.findElement(login);
	}
}