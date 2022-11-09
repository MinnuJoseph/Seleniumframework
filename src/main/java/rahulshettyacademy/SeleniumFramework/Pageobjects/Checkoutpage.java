package rahulshettyacademy.SeleniumFramework.Pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import raulshettyacademy.SeleniumFramework.Abstractcomponents.Abstractcomponents;

public class Checkoutpage extends Abstractcomponents {

	
WebDriver driver;
	
	public Checkoutpage(WebDriver driver) 
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "(//button[contains(@class,'ta-item')])[2]")
	private WebElement selectCountry;
	
	@FindBy(css = ".action__submit")
	 private WebElement submit;
	
	@FindBy(css = "[placeholder='Select Country']")
	private WebElement country;
	
	By results= By.cssSelector(".ta-results");
	
	public void selectcountry(String countryname)
	{
	Actions a = new Actions(driver);
	a.sendKeys(country, countryname).build().perform();
	Waitforelementtoappear(results);
	selectCountry.click();
	}
	
	public void submit()
	{
		submit.click();
	}
	
}
