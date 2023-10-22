package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddtocartPage {
	@FindBy (xpath="//button[@id='add-to-cart-sauce-labs-backpack']")
    private WebElement Clickonaddtocart;
	@FindBy (xpath = "//div[@id='shopping_cart_container']")
	private WebElement ClickonCartcontainer;
	@FindBy (xpath="//button[@id='checkout']")
	private WebElement ClickonCheckout;
	
	
	  public AddtocartPage(WebDriver driver)
    {
    	PageFactory.initElements(driver, this);
    }
	  public void clickonaddtocart()
	  {
	       Clickonaddtocart.click();
	  }
	  public void clickonCartcontainer()
	  {
		  ClickonCartcontainer.click();
	  }
	  public void clickonCheckout()
	  {
		  ClickonCheckout.click();
	  }
}
