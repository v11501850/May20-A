package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EnterTheDetailsPage {
	@FindBy (xpath="//input[@id='first-name']")
    private WebElement EnterFirstname;
	@FindBy (xpath = "//input[@id='last-name']")
	private WebElement EnterLastname;
	@FindBy (xpath="//input[@id='postal-code']")
	private WebElement EnterZipcode;
	@FindBy (xpath="//input[@id='continue']")
	private WebElement Clickcontinue;
	@FindBy (xpath="//button[@id='finish']")
	private WebElement ClickFinish;

	  public EnterTheDetailsPage(WebDriver driver)
    {
    	PageFactory.initElements(driver, this);
    }
	  public void enterFirstname()
	  {
	       EnterFirstname.sendKeys("jon");
	  }
	  public void enterLastname()
	  {
		  EnterLastname.sendKeys("deo");
	  }
	  public void enterZipcode()
	  {
		  EnterZipcode.sendKeys("410004");
	  }
	  public void clickContinue()
	  {
		  Clickcontinue.click();
	  }
	  public void clickFinish()
	  {
		  ClickFinish.click();
	  }
}
