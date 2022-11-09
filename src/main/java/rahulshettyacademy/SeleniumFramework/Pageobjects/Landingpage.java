package rahulshettyacademy.SeleniumFramework.Pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import raulshettyacademy.SeleniumFramework.Abstractcomponents.Abstractcomponents;

public class Landingpage extends Abstractcomponents {

	WebDriver driver;
	
	public Landingpage(WebDriver driver) 
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="userEmail")
	WebElement Username;
	@FindBy(id="userPassword")
	WebElement password;
	@FindBy(id="login")
	WebElement Loginbutton;
	@FindBy(css="[class*='flyInOut']")
	WebElement errorMessage;

	
	public void gotourl(String url)
	{
		driver.get(url);
	}
	public void Login(String User,String pwd)
	{
		Username.sendKeys(User);
		password.sendKeys(pwd);
		Loginbutton.click();
	}
	public String getErrorMessage()
	{
		waitForWebElementToAppear(errorMessage);
		return errorMessage.getText();
	}
}
