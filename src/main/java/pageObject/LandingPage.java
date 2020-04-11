package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage {
	
	public WebDriver driver;
	By login=By.cssSelector("a[href*='sign_in']");
	By title=By.xpath("//div[@class='text-center']");
	By navbar=By.cssSelector("ul.nav.navbar-nav.navbar-right");
	By header=By.cssSelector("div[class*='video-banner'] h3");
	
	
	public LandingPage(WebDriver driver) {
		this.driver=driver;
	}


	public WebElement LogIn() {
		return driver.findElement(login);
	}

	public WebElement GetTitle() {
		return driver.findElement(title);
	}
	
	public WebElement GetNavBar() {
		return driver.findElement(navbar);
	}
	public WebElement getHeader() {
		return driver.findElement(header);
	}
}
