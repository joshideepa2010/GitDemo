package Academy;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import Resources.Base;
import pageobjects.ForgotPassword;
import pageobjects.LandingPage;
import pageobjects.LoginPage;

public class HomePage extends Base{
	public WebDriver driver;

	public static Logger log=LogManager.getLogger(Base.class.getName());

//private WebDriver driver;no need as we are inheriting from Base class
	
	@BeforeTest
	public void initialise() throws IOException, InterruptedException
	{
		driver=initializeDriver();
		
		
	}

@Test(dataProvider="getData")	
public void basePageNavigation(String username,String password,String text) throws IOException, InterruptedException
{

	driver.get(prop.getProperty("url"));
	System.out.println(driver.getTitle());
	this.driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	//Thread.sleep(3000);
	LandingPage lap=new LandingPage(driver);
	//lap.getLogin().click();
	LoginPage lop=lap.getLogin();
	
	Thread.sleep(3000);
	lop.getEmail().sendKeys(username);
    lop.getPassword().sendKeys(password);
    //System.out.println(text);
    log.info(text);
    
    lop.getLogin().click();
    
 ForgotPassword fp=lop.forgotPassword();
   fp.email().sendKeys("xxxxx");
   fp.sendInstructions().click();
   
	
}

@AfterTest
public void tearDown()
{
	driver.close();
}

@DataProvider
public Object[][] getData() throws InterruptedException
{
	//row---number of different data(restricted and nonrestricted)
	//column---number of values(attributes) we pass:username,pwd,text
	Object[][] data=new Object[2][3];
	//1st row
	data[0][0]="nonrestricted@gmail.com";
	data[0][1]="1234";
	data[0][2]="nonrestrictedmember";
	//2nd row
	//Thread.sleep(3000);
	data[1][0]="restricted@gmail.com";
	data[1][1]="4321";
	data[1][2]="restrictedmember";
	
	return data;
	
	}
}
