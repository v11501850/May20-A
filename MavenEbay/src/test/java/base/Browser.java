package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Browser {
	public static WebDriver launchChrome()
	{
		ChromeOptions options=new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
	WebDriver driver=new ChromeDriver(options);
		
		return driver;
		
	}
	
	public static WebDriver launchFirefox()
	{
		System.setProperty("Webdriver.chrome.driver", "src\\test\\BrowserFiles\\Firefox Installer.exe");
		WebDriver driver=new FirefoxDriver();
		
		return driver;
		
	}
	

}
