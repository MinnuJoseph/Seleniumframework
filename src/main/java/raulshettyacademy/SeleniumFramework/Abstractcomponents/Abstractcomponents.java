package raulshettyacademy.SeleniumFramework.Abstractcomponents;

import java.time.Duration;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Abstractcomponents {

WebDriver driver;

	
	public Abstractcomponents(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void Waitforelementtoappear(By findBy)
	{
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));;
		
	//	wait.until((Function<? super WebDriver, V>) ExpectedConditions.visibilityOfElementLocated(findBy));
		wait.until(ExpectedConditions.visibilityOfElementLocated(findBy));
	}
	
	public void Waitforelementtodisappear(WebElement we) throws InterruptedException
	{
		//Thread.sleep(1000);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));;
		wait.until(ExpectedConditions.invisibilityOf(we));
	}
	public void waitForWebElementToAppear(WebElement findBy) {

		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOf(findBy));

	}
	
}

