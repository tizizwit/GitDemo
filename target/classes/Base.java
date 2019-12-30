package Resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class Base {

	public WebDriver driver;
	public Properties prop = new Properties();
	
	public void initializeDriver() throws IOException {

		FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "/src/main/java/Resources/data.properties");
		prop.load(fis);
		
		String browserName;
		
		if (System.getProperty("browser")==null) {
			browserName = prop.getProperty("browser");
		}
		
		else {
			browserName = System.getProperty("browser");   // execution comes from Jenkins
		} 

		// firefox
		if (browserName.contains("firefox")) {

			System.setProperty("webdriver.gecko.driver", "/usr/lib/firefox/geckodriver");
			FirefoxOptions firefoxOptions = new FirefoxOptions();

			if (browserName.contains("headless")) {
				firefoxOptions.addArguments("--headless");   //-- headless browser for Jenkins execution
			}

			driver=new FirefoxDriver(firefoxOptions);
			
		}
		
		// chrome
		if (browserName.contains("chrome")) {

			System.setProperty("webdriver.chrome.driver", "/usr/bin/chromedriver");

			ChromeOptions chromeOptions = new ChromeOptions();

			if (browserName.contains("headless")) {
				chromeOptions.addArguments("--headless");   //-- headless browser for Jenkins execution
			}

			driver=new ChromeDriver(chromeOptions);
		}

		// IE
		if (browserName.equalsIgnoreCase("ie")) {
			
		}
		
		driver.manage().timeouts().implicitlyWait(Long.parseLong(prop.getProperty("implicitlytimeout")), TimeUnit.SECONDS);

	}

	public void takeScreenshot(WebDriver webdriver,String fileWithPath) throws WebDriverException, IOException {
		TakesScreenshot screenshotFile = ((TakesScreenshot)webdriver);
		FileUtils.copyFile(screenshotFile.getScreenshotAs(OutputType.FILE), new File(fileWithPath));
	}

}
