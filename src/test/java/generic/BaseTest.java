package generic;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

public class BaseTest implements AutoConstant
{
	public static WebDriver driver;
	@BeforeSuite
	public void suiteExecutionStart()
	{
		Reporter.log("execution started at suite tag level",true);
	}
	@BeforeTest
	public void testExecutionStart()
	{
		Reporter.log("execution started at test tag level",true);
	}
	@BeforeClass
	public void setup() throws IOException
	{
		Reporter.log("execution started at class1 tag level",true);
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));
		FileInputStream fis=new FileInputStream(properties_path);
		Properties properties=new Properties();
		properties.load(fis);
		driver.get(properties.getProperty("url"));
		Reporter.log("execution started at class2 tag level",true);
	}
	@AfterClass
	public void teardown()
	{
		driver.quit(); 
	}
	@AfterTest
	public void testExecutionComplete()
	{
		Reporter.log("execution completed at test tag level",true);
	}
	@AfterSuite
	public void suiteExecutionComplete()
	{
		Reporter.log("execution completed at suite tag level",true);
	}
}
