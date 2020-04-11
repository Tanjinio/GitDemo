package Academy;
//import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
//import org.openqa.selenium.logging.Logs;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import org.testng.annotations.Test;

import pageObject.LandingPage;
//import pageObject.LoginPage;
import resourses.Base;

public class ValidateText extends Base {
	
	public static Logger log = LogManager.getLogger(Base.class.getName());
	LandingPage lp;
	
	
	@BeforeTest
	public void innitialize() throws IOException {
		driver = InitializeDriver();
		driver.get(prop.getProperty("url"));

	}

	@Test
	public void basePage() throws IOException {
		
		log.info("Navigated to home page");

		lp = new LandingPage(driver);
		System.out.println(lp.GetTitle().getText());
		log.info("got the text");
		Assert.assertTrue(lp.GetNavBar().isDisplayed());
		log.info("nav bar is displayed");

		Assert.assertEquals(lp.GetTitle().getText(), "FEATURED COURSES");
		log.info("successfully validated text");
		log.info(lp.GetTitle().getText());
	}
	@Test
	public void HeaderValidation() throws IOException {
		lp = new LandingPage(driver);
		Assert.assertEquals(lp.getHeader().getText(), "AN ACADEMY TO LEARN EVERYTHING ABOUT TESTING");
		log.info(lp.getHeader().getText());
	}

	@AfterTest
	public void teardown() {
		driver.close();
		driver = null;
	}

}
