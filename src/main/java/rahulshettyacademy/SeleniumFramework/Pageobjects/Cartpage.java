package rahulshettyacademy.SeleniumFramework.Pageobjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import raulshettyacademy.SeleniumFramework.Abstractcomponents.Abstractcomponents;

public class Cartpage extends Abstractcomponents{

WebDriver driver;
	
	public Cartpage(WebDriver driver) 
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css=".cartSection h3")
	List<WebElement> cartProducts;
	
	@FindBy(css=".totalRow button")
	WebElement checkoutbutton;
	
	@FindBy(css = "[routerlink*='cart']")
	WebElement cartHeader;
	
	
	public Boolean Cartproductlist(String productName)
	{
		Boolean match = cartProducts.stream().anyMatch(cartProduct-> cartProduct.getText().equalsIgnoreCase(productName));
		return match;
		
	}
	
	public void goToCheckout() 
	{
		checkoutbutton.click();
	}
	public void cardbuttonclick()
	{
		cartHeader.click();
	}
}
