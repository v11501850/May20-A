package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ClickrequestDemoPage {
	@FindBy (xpath="(//button[text()='Request a demo'])[1]")
	private WebElement ClickonrequestDemo;
	  public ClickrequestDemoPage(WebDriver driver)
	    {
	    	PageFactory.initElements(driver, this);
	    }
		  
	  public void clickonrequestDemo(WebDriver driver)
	  {
		  Actions act = new Actions(driver);
			act.moveToElement(ClickonrequestDemo).click().build().perform();

	  }
}
