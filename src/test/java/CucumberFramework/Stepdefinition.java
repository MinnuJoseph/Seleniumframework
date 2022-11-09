package CucumberFramework;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import rahulshettyacademy.SeleniumFramework.Pageobjects.Cartpage;
import rahulshettyacademy.SeleniumFramework.Pageobjects.Checkoutpage;
import rahulshettyacademy.SeleniumFramework.Pageobjects.ConfirmationPage;
import rahulshettyacademy.SeleniumFramework.Pageobjects.Landingpage;
import rahulshettyacademy.SeleniumFramework.Pageobjects.Productcatalog;
import raulshettyacademy.SeleniumFramework.BaseTest;

public class Stepdefinition extends BaseTest{
	public Landingpage lp;
    @Given("^Landed on Ecommercewebsite$")
    public void landed_on_ecommercewebsite() throws IOException 
    {
    	 lp=Launch();
		
    }
    
    @Given("^Logged in with (.+) and (.+)$")
    public void logged_in_with_and(String username, String password)  {
    	lp.Login(username, password);
    	
    }

    @When("^Adding the (.+) to cart$")
    public void adding_the_to_cart(String productname)  {
    	Productcatalog pc=new Productcatalog(driver);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".mb-3")));
		List<WebElement> products = driver.findElements(By.cssSelector(".mb-3"));
	//	List<WebElement> products=pc.getproductlist();
		System.out.println(products.size());
		//WebElement prod =	pc.selectproductname(productName);
		try {
			pc.addtocart(productname);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
    }
    
    @And("^Checkout (.+) and submit the order$")
    public void checkout_and_submit_the_order(String productname)  {
    	Cartpage cp=new Cartpage(driver);
		Boolean match=cp.Cartproductlist(productname);
        Assert.assertTrue(match);
        cp.goToCheckout();
    	Checkoutpage check = new Checkoutpage(driver);
	    check.selectcountry("India");
	    check.submit();
    }


    @Then("^verify confirmation message displayed$")
    public void verify_confirmation_message_displayed() {
    	ConfirmationPage confirm=new ConfirmationPage(driver);
	    String confirmMessage = confirm.confirmation();
	    Assert.assertTrue(confirmMessage.equalsIgnoreCase("THANKYOU FOR THE ORDER."));
	    driver.close();
    }
    
    @Then("^Verify \"([^\"]*)\" is displayed$")
    public void verify_something_is_displayed(String strArg1) 
    {
    	Assert.assertEquals(strArg1, lp.getErrorMessage());
    	driver.close();
    }

   
}