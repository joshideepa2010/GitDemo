package Resources;

import java.io.File;
import java.io.FileInputStream;
//import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;


public class Base {

	public WebDriver driver;
	public Properties prop;
	
public WebDriver initializeDriver() throws IOException{
	
	
prop=new Properties();
FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\Resources\\Browserdata.properties");
//FileInputStream fis=new FileInputStream("C:\\Selenium\\E2EProject\\src\\main\\java\\Resources\\Browserdata.properties");


prop.load(fis);
//String browserName=System.getProperty("browser");//for Maven
String browserName=prop.getProperty("browser");//for java
System.out.println(browserName);
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                             
if(browserName.contains("chrome")) {
	//this path is not generic,it is hard coded with the path from the system
	//System.setProperty("webdriver.chrome.driver","C:\\Selenium\\driver\\Chrome8339\\chromedriver.exe");
	
	//both the below steps are right,we can choose either of them to fetch
	System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"\\src\\main\\java\\Resources\\chromedriver.exe");
	//System.setProperty("webdriver.chrome.driver",new File(System.getProperty("user.dir")+"\\src\\main\\java\\Resources\\chromedriver.exe").getAbsolutePath());
   
	ChromeOptions options=new ChromeOptions();
	if(browserName.contains("headless"))
	{
	options.addArguments("headless");
	}
	driver=new ChromeDriver(options);
	 //this.driver=new ChromeDriver();--trial step
}

else if(browserName.equals("firefox")) {
	System.setProperty("webdriver.gecko.driver","C:\\Selenium\\driver\\Firefox\\geckodriver-v0.26.0-win64\\geckodriver.exe");
	driver=new FirefoxDriver();
}

else if(browserName.equals("IE")) {
	System.setProperty("webdriver.ie.driver","C:\\Selenium\\driver\\IE\\IEDriverServer.exe");
	driver=new InternetExplorerDriver();
}

driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
return driver;
}

public String getScreenShotPath(String testCaseName,WebDriver driver) throws IOException
{
	TakesScreenshot ts=(TakesScreenshot)driver;
	File source=ts.getScreenshotAs(OutputType.FILE);
	String destfile=System.getProperty("user.dir")+"\\reports\\"+testCaseName+".png";
    FileUtils.copyFile(source,new File(destfile));
    return destfile;

}

	}

	

