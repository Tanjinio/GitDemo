package resourses;

import java.io.File;
import java.io.FileInputStream;
//import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
//import org.apache.logging.log4j.core.util.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
//import org.openqa.selenium.io.FileHandler;

public class Base {
	public static WebDriver driver = null; //static will help you to maintain only one copy in entire framework//
	public Properties prop;

	public WebDriver InitializeDriver() throws IOException {
		prop= new Properties();
		//System.getProperty("user.dir")
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\resourses\\data.properties");
		prop.load(fis);
		//mvn test -Dbrowser=Chrome
		String browserName=System.getProperty("browser");//To give browser name through Maven//
		//String browserName=prop.getProperty("Browser"); //To give browser name through TestNg//
		if(browserName.contains("Chrome")) {
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\src\\main\\java\\resourses\\chromedriver.exe");
			ChromeOptions options=new ChromeOptions();
			if(browserName.contains("headless")) {
			   options.addArguments("headless","user-agent=mrbean");
			}
	driver = new ChromeDriver(options);
		}

		  else if(browserName.contains("Firefox")) {
			  System.setProperty("webdriver.gecko.driver", "C:\\SeleniumDriver\\geckodriver-v0.26.0-win64\\geckodriver.exe");
				driver = new FirefoxDriver();
				
		}
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver;
	}
 
	public void getScreenshot(String result) throws IOException {
		File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File("C:\\Users\\User\\"+result+"Screenshots.png"));
	}
}
