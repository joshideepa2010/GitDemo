package Academy;


import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
//import org.apache.logging.log4j.core.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import Resources.Base;
import pageobjects.LandingPage;

public class ValidateNavBar extends Base{
	public WebDriver driver;

	public static Logger log=LogManager.getLogger(Base.class.getName());

//private WebDriver driver;no need as we are inheriting from Base class
@BeforeTest
public void initialize() throws IOException, InterruptedException
{
	driver=initializeDriver();
	driver.get(prop.getProperty("url"));
	Thread.sleep(5000);
}


@Test
public void basePageNavigation() throws IOException, InterruptedException
{

	Thread.sleep(5000);
	driver=initializeDriver();
	driver.get(prop.getProperty("url"));
	//driver.get("http://www.qaclickacademy.com/");
	LandingPage lap=new LandingPage(driver);
	Assert.assertTrue(lap.getnavBar().isDisplayed());
	log.info("Navigation Bar is displayed");
	
}

@AfterTest
public void tearDown()
{
	driver.close();
}

}
