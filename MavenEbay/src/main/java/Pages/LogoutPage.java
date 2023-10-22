package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogoutPage {
	@FindBy (xpath="//button[@id='react-burger-menu-btn']")
    private WebElement ClickMenuTab;
	@FindBy (xpath = "//a[@id='logout_sidebar_link']")
	private WebElement ClickonLogout;
	
	
	  public LogoutPage(WebDriver driver)
    {
    	PageFactory.initElements(driver, this);
    }
	  public void clickMenuTab()
	  {
	      ClickMenuTab.click();
	  }
	  public void clickonLogout()
	  {
		  ClickonLogout.click();
	  }
	 
}
