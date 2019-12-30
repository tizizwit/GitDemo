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

public class HomePageTest extends Base {

	private static Logger log = LogManager.getLogger();
	String url;
	LandingPage landing;
	
	@BeforeTest
	public void initialize() throws IOException {
		
		initializeDriver();
		log.info("Driver is initialized ...");
		
		url = prop.getProperty("url"); 
		
	}
	
	@Test (priority=1)
	public void BasePageNavigation() {
	
		driver.get(url);

		log.info("Navigated to home page ...");

		landing = new LandingPage(driver);
	
	}
	
	@Test (priority=2)
	public void validateHeader() {

		Assert.assertEquals(landing.getHeader().getText(), "AN ACADEMY TO LEARN EVERYTHING ABOUT TESTING");
		
	}

	@Test (priority=3)
	public void validateTitle() {

		Assert.assertEquals(landing.getTitle().getText().toUpperCase(), "FEATURED COURSES");
		log.info("Title is correct ...");

//		AssertJUnit.assertTrue(landing.getTitle().getText().toUpperCase().equals("FEATURED COURSES"), "Title does not exist");
		
	}

	@AfterTest
	public void tearDown() throws InterruptedException {
		
		driver.close();
		driver=null;
		
	}
	
}
