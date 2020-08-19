package Academy;


//import static org.testng.Assert.assertEquals;
import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import Resources.Base;
import pageobjects.LandingPage;

public class ValidationPage extends Base{
	public WebDriver driver;

	public static Logger log = LogManager.getLogger(Base.class.getName());

//private WebDriver driver;no need as we are inheriting from Base class
@BeforeTest
public void initialise() throws IOException, InterruptedException
{
	driver=initializeDriver();
	log.info("Driver is initialized");
	driver.get(prop.getProperty("url"));
	log.info("Navigated to HomePage");
	Thread.sleep(5000);
}

@Test
public void basePageNavigation() throws IOException, InterruptedException
{
	Thread.sleep(5000);
	LandingPage lap=new LandingPage(driver);
	//assertEquals(lap.getTitle().getText(),"FEATURED COURSES");
	//compared text from browser with the actual value
	//assertEquals(lap.getTitle().getText(),"FEATUED COURSES");
	Assert.assertEquals(lap.getTitle().getText(),"FEATURED COURSES");
	log.info("Successfully Validated Text message");
	
}

@AfterTest
public void tearDown()
{
	driver.close();
}



}
