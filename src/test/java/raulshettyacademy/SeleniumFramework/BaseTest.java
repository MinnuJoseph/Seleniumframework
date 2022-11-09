package raulshettyacademy.SeleniumFramework;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import rahulshettyacademy.SeleniumFramework.Pageobjects.Landingpage;

public class BaseTest {
	public WebDriver driver;
	public Landingpage lp;
	
	public WebDriver initilizedriver() throws IOException
	{
		Properties prop=new Properties();
		FileInputStream fs=new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\rahulshettyacademy\\SeleniumFramework\\resources\\globalproperties.properties");
		prop.load(fs);
		String browsername=prop.getProperty("browser");
		if(browsername.equals("chrome"))
			{
		System.setProperty("webdriver.chrome.driver", "C:\\work\\chromedriver.exe");
		driver = new ChromeDriver();
			}
		else if(browsername.equals("firefox"))
			{
			System.setProperty("webdriver.gecko.driver", "C:\\work\\geckodriver.exe");
			//WebDrivermanager.geckodriver().setup();
		     driver = new FirefoxDriver();
			}	
		
	
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
			driver.manage().window().maximize();
			
			return driver;
		}
	
	public String getScreenshot(String testCaseName, WebDriver driver) throws IOException
	{
		TakesScreenshot ts = (TakesScreenshot)driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File file = new File(System.getProperty("user.dir") + "//reports//" + testCaseName + ".png");
		String filepath = file.getAbsolutePath();
		org.openqa.selenium.io.FileHandler.copy(source, file);
		return filepath;
		//FileUtils.copyFile(source, file);
		//return System.getProperty("user.dir") + "//reports//" + testCaseName + ".png";
		
	}
	
	@BeforeMethod(alwaysRun=true)
	public Landingpage Launch() throws IOException
	{
		WebDriver driver=initilizedriver();
		lp=new Landingpage(driver);
		lp.gotourl("https://rahulshettyacademy.com/client");
		return lp;
	}
	
	@AfterMethod(alwaysRun=true)
	public void closewindow()
	{
		driver.close();
	}
	}


