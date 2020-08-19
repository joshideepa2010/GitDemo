package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage {

	public WebDriver driver;
	
	By signin=By.xpath("//div[@class='tools']//li[4]//a[1]");
	//By signin=By.xpath("//span[contains(text(),'Login')]");
	  
	By title=By.cssSelector("#content > div > div > h2");
	By navbar=By.cssSelector("ul[class='nav navbar-nav navbar-right']");
	
	
	public LandingPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
	}

	public LoginPage getLogin()
	{
		//return driver.findElement(signin);
		driver.findElement(signin).click();//directmethod instead of creating obj
		LoginPage lop=new LoginPage(driver);
		return lop;
	}
	
	public WebElement getTitle()
	{
		return driver.findElement(title);
	}
	
	public WebElement getnavBar()
	{
		return driver.findElement(navbar);
	}
	
}
