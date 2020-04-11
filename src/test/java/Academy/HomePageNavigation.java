package Academy;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObject.LandingPage;
import pageObject.LoginPage;
import resourses.Base;

public class HomePageNavigation extends Base {
	public static Logger log = LogManager.getLogger(Base.class.getName());

	@BeforeTest
	public void innitialize() throws IOException {
		driver = InitializeDriver();

	}

	@Test(dataProvider = "getData")
	public void basePageNavigation(String username, String password) throws IOException {
		driver.get(prop.getProperty("url"));
		LandingPage lp = new LandingPage(driver);
		lp.LogIn().click();
		LoginPage lg = new LoginPage(driver);
		lg.EnterEmail().sendKeys(username);
		lg.EnterPass().sendKeys(password);
		lg.ClickLOgin().click();
		log.info(username + password);
		log.info(password);
	}

	@AfterTest
	public void teardown() {
		driver.close();
		driver = null;
	}

	@DataProvider
	public Object[][] getData() {
		Object[][] data = new Object[2][2];
		data[0][0] = "abc@gmail.com";
		data[0][1] = "1234";
		data[1][0] = "mno@gmail.com";
		data[1][1] = "6789";
		return data;

	}

}
