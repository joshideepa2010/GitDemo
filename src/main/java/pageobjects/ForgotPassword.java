package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ForgotPassword {
	
	public WebDriver driver;
	
	By email=By.xpath("//input[@id='user_email']");
	By sendins=By.cssSelector("input[name='commit']");
	
	public ForgotPassword(WebDriver driver) {
		
		this.driver=driver;
	}
	
	
	public WebElement email() {
		
		return driver.findElement(email);
}
	
	public WebElement sendInstructions() {
		
		return driver.findElement(sendins);
		
	}
}
