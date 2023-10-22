package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	@FindBy (xpath="//button[@id='react-burger-menu-btn']")
    private WebElement ClickonSelectMenu;
	@FindBy (xpath = "//a[@id='about_sidebar_link']")
	private WebElement Clickonabout;
	
	
	  public HomePage(WebDriver driver)
    {
    	PageFactory.initElements(driver, this);
    }
	  public void clickonMenu()
	  {
	      ClickonSelectMenu.click();
	  }
	  public void clickonabout()
	  {
		  Clickonabout.click();
	  }
	
}
