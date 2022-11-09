package raulshettyacademy.SeleniumFramework;

import org.testng.annotations.Test;

import rahulshettyacademy.SeleniumFramework.Pageobjects.Cartpage;
import rahulshettyacademy.SeleniumFramework.Pageobjects.Landingpage;
import rahulshettyacademy.SeleniumFramework.Pageobjects.Productcatalog;

import org.testng.AssertJUnit;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

/*import rahulshettyacademy.TestComponents.BaseTest;
import rahulshettyacademy.TestComponents.Retry;
import rahulshettyacademy.pageobjects.CartPage;
import rahulshettyacademy.pageobjects.CheckoutPage;
import rahulshettyacademy.pageobjects.ConfirmationPage;
import rahulshettyacademy.pageobjects.ProductCatalogue;*/

public class ErrorValidationstest extends BaseTest {

	@Test(groups= {"ErrorHandling"})
	public void LoginErrorValidation() throws IOException, InterruptedException {

		//Landingpage lp=new Landingpage(driver);
		lp.Login("anshika@gmail.com", "Iamki000");
		Assert.assertEquals("Incorrect email or password.", lp.getErrorMessage());

	}
	

	@Test
	public void ProductErrorValidation() throws IOException, InterruptedException
	{

		String productName = "ZARA COAT 3";
		Landingpage lp=new Landingpage(driver);
		lp.Login("rahulshetty@gmail.com", "Iamking@000");
		Productcatalog pc=new Productcatalog(driver);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".mb-3")));
		List<WebElement> products = driver.findElements(By.cssSelector(".mb-3"));
		pc.addtocart(productName);
		Cartpage cartPage = new Cartpage(driver);
		cartPage.cardbuttonclick();
		Boolean match=cartPage.Cartproductlist("ZARA COAT 33");
		Assert.assertFalse(match);
		
	

	}

	
	

}
