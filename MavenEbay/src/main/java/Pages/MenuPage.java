package Pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MenuPage {

	@FindBy (xpath="(//span[text()='Products'])[1]")
    private WebElement product;
	@FindBy (xpath="(//a[@href='/products/mobile-testing'])[1]")
	private WebElement SauceMobile;
	
	
	  public MenuPage(WebDriver driver)
    {
    	PageFactory.initElements(driver, this);
    }
	  public void clickonseectMenu(WebDriver driver)
	  {
		 
		Actions act = new Actions(driver);
		 WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(10));
		  wait.until(ExpectedConditions.elementToBeClickable(product));

		  act.moveToElement(product).perform();
		  driver.switchTo().frame(1);
		
	  }
	  public void clickonSauceMobile(WebDriver driver)
	  {
		  SauceMobile.click();
	  }
}

