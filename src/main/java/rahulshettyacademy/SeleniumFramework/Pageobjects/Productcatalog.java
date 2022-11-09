package rahulshettyacademy.SeleniumFramework.Pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import raulshettyacademy.SeleniumFramework.Abstractcomponents.Abstractcomponents;

public class Productcatalog  extends Abstractcomponents{

	
WebDriver driver;
	
	public Productcatalog(WebDriver driver) 
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	By productsBy= By.cssSelector("mb-3");
	By addtocartbutton = By.cssSelector(".card-body button:last-of-type");
	By toastcontainer= By.cssSelector("#toast-container");
	
	@FindBy(css=".mb-3")
	List<WebElement> products;
	@FindBy(css=".ng-animating")
	WebElement animatingbutton;
	@FindBy(css="[routerlink*='cart']")
	WebElement cartbutton;
	
	
	/*public List<WebElement> getproductlist()
	{
		Waitforelementtoappear(productsBy);
		return products;
	}*/
	
	public WebElement selectproductname(String productName)
	{
		WebElement prod =	products.stream().filter(product->
		product.findElement(By.cssSelector("b")).getText().equals(productName)).findFirst().orElse(null);
		return prod;
	}
	
	public void addtocart(String productName) throws InterruptedException
	{
		WebElement prod=selectproductname( productName);
		prod.findElement(addtocartbutton).click();
		Waitforelementtoappear(toastcontainer);
		Waitforelementtodisappear(animatingbutton);
		cartbutton.click();
	}
	
	
}
