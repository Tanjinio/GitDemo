package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
	
	public WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		this.driver=driver;
	}
	
	By email=By.cssSelector("input[name='user[email]']");
	By password=By.xpath("//input[@id='user_password']");
	By submit=By.xpath("//*[@type='submit']");
	By home=By.xpath("//ul[@class='nav navbar-nav navbar-right']/li[1]");
	
	public WebElement EnterEmail() {
		return driver.findElement(email);
	}
    
	public WebElement EnterPass() {
		return driver.findElement(password);
	}
	
	public WebElement ClickLOgin() {
		return driver.findElement(submit);
	}
	public WebElement ClickHome() {
		return driver.findElement(home);
	}
}
