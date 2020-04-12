package Academy;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObject.LoginPage;
import resourses.Base;

public class Clickonlink extends Base {
	@BeforeTest
	public void innitialize() throws IOException {
		driver=InitializeDriver();
	}
	public static Logger log = LogManager.getLogger(Base.class.getName());
	@Test
	public void clicklink() throws IOException {
		
		driver.get(prop.getProperty("url"));
		LoginPage lpg=new LoginPage(driver);
		
		lpg.ClickHome().click();
		log.info("clicked on link from manish eclipse");
	}
	@AfterTest()
	public void teardown() {
		driver.close();
		driver=null;
	}
	
	
}
