package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {

	public WebDriver driver;
	//this.driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

	By email=By.cssSelector("input[class='form-control input-hg']");
	By password=By.xpath("//input[@type='password']");
	By login=By.xpath("//input[@name='commit']");
	By forgotpwd=By.linkText("Forgot Password?");
	
	public LoginPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver=driver;
	}

	
	public WebElement getEmail()
	{
		return driver.findElement(email);
	}
	
	public WebElement getPassword()
	{
		return driver.findElement(password);
		
	}
	
	public WebElement getLogin()
	{
		return driver.findElement(login);
	}
	
	public ForgotPassword forgotPassword()
	{
		driver.findElement(forgotpwd).click();
		ForgotPassword fp=new ForgotPassword(driver);
		return fp;
	}
}
