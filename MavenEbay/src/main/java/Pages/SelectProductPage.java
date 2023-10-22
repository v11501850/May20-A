package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SelectProductPage {
@FindBy (xpath="//a[@id='item_4_title_link']")
private WebElement ClickonSelect1Paroduct;
public SelectProductPage(WebDriver driver)
{
	PageFactory.initElements(driver, this);
}
  public void clickonSelect1Product()
  {
	  ClickonSelect1Paroduct.click();
  }
}
