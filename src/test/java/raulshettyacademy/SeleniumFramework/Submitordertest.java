package raulshettyacademy.SeleniumFramework;

import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import rahulshettyacademy.SeleniumFramework.Pageobjects.Cartpage;
import rahulshettyacademy.SeleniumFramework.Pageobjects.Checkoutpage;
import rahulshettyacademy.SeleniumFramework.Pageobjects.ConfirmationPage;
import rahulshettyacademy.SeleniumFramework.Pageobjects.Landingpage;
import rahulshettyacademy.SeleniumFramework.Pageobjects.Productcatalog;




public class Submitordertest  extends BaseTest
{
	@Test
	public void SubmitOrder() throws IOException
	{
		String productName="ZARA COAT 3";
		Landingpage lp=Launch();
		lp.Login("anshika@gmail.com", "Iamking@000");
		Productcatalog pc=new Productcatalog(driver);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".mb-3")));
		List<WebElement> products = driver.findElements(By.cssSelector(".mb-3"));
	//	List<WebElement> products=pc.getproductlist();
		System.out.println(products.size());
		//WebElement prod =	pc.selectproductname(productName);
		try {
			pc.addtocart(productName);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Cartpage cp=new Cartpage(driver);
		Boolean match=cp.Cartproductlist(productName);
        Assert.assertTrue(match);
        cp.goToCheckout();
	    Checkoutpage check = new Checkoutpage(driver);
	    check.selectcountry("India");
	    check.submit();
	    ConfirmationPage confirm=new ConfirmationPage(driver);
	    String confirmMessage = confirm.confirmation();
	    Assert.assertTrue(confirmMessage.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
	    
	
	
	}

}
