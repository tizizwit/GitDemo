package Academy;

import org.testng.annotations.Test;
import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import Resources.Base;
import pageObjects.LandingPage;
import pageObjects.LoginPage;

public class LoginPageTest extends Base {

	private static Logger log = LogManager.getLogger();
	String url;
	LandingPage landing;
	
	@BeforeTest
	public void initialize() throws IOException {
		
		initializeDriver();
		log.info("Driver is initialized ...");
		
		url = prop.getProperty("url"); 
		
	}
	
	public void BasePageNavigation() {
	
		driver.get(url);

		log.info("Navigated to home page ...");

		landing = new LandingPage(driver);
	
	}
	
	@Test(priority = 4, dataProvider="getData")
	public void LoginPageNavigation(String username, String password) {
	
		BasePageNavigation();
		landing.getLogin().click();
		LoginPage lp = new LoginPage(driver);
		lp.getEmail().sendKeys(username);
		lp.getPassword().sendKeys(password);
		lp.getLogin().click();

	}

	@DataProvider
	public Object[][] getData() {

//		Object[][] data = new Object[2][2];

		Object[][] data = new Object[1][2];
		data[0][0] = "amsvrid@gmail.com";
		data[0][1] = "123456";

//		data[1][0] = "tizizwit@gmail.com";
//		data[1][1] = "123456";
	
		return data;
	}
	
	@AfterTest
	public void tearDown() throws InterruptedException {
		
		driver.close();
		driver=null;
		
	}
	
}
