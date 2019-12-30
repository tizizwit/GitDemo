package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import Resources.Base;

public class LandingPage
{
	WebDriver driver;
	private By signin = By.cssSelector("a[href*='sign_in']");
	private By title = By.className("text-center");
	private By header = By.cssSelector("div[class*='video-banner'] h3");

	public LandingPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public WebElement getLogin() {
		return driver.findElement(signin);
	}

	public WebElement getTitle() {
		return driver.findElement(title);
	}

	public WebElement getHeader() {
		return driver.findElement(header);
	}
}
