package Pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	@FindBy (xpath="//input[@id='user-name']")
    private WebElement Enterusername;
	@FindBy (xpath = "//input[@id='password']")
	private WebElement Enterpassword;
	@FindBy (xpath="//input[@id='login-button']")
	private WebElement ClickonLoginButton;
	
	
	  public LoginPage(WebDriver driver)
    {
    	PageFactory.initElements(driver, this);
    }
	  public void enterUsername(String userName)
	  {
	       Enterusername.sendKeys(userName);
	  }
	  public void enterPassword(String password)
	  {
		  Enterpassword.sendKeys(password);
	  }
	  public void clickonLoginButton()
	  {
		  ClickonLoginButton.click();
	  }
	
}
