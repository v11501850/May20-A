package testNgsauceDemo;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import Pages.AddtocartPage;
import Pages.EnterTheDetailsPage;
import Pages.HomePage;
import Pages.LoginPage;
import Pages.LogoutPage;
import Pages.MenuPage;
import Pages.SelectProductPage;
import base.Browser;
import utility.Utility;

public class VerifyAddtocart extends Browser {
	private WebDriver driver;
	private String testId;
	private LoginPage loginPage;
	private HomePage homePage;
	private MenuPage menuPage;
	private  SelectProductPage  selectProductPage;
	private AddtocartPage addtocartPage;
	static ExtentTest test;
	static ExtentHtmlReporter reporter;
	
		@Parameters("browser")
		@BeforeTest
		public void lanchBrowser(String browserName)
	    {
			reporter = new  ExtentHtmlReporter("C:\\Users\\lenovo\\eclipse-workspace\\MavenEbay\\test-output\\ExtendReport//Extent.html");
			ExtentReports extent = new ExtentReports();
			extent.attachReporter(reporter);
			
	if(browserName.equals("Chrome")){
			driver = launchChrome() ;
	}
	if(browserName.equals("Firefox"))
	{		
		driver = launchFirefox() ;
	}
	driver.manage().window().maximize();
	     driver.manage().timeouts().implicitlyWait(Duration.ofMillis(2000));
		
	    	
	}
		@BeforeClass
		public void creatingPOMObjects()
		{
			 loginPage= new LoginPage(driver);
			 homePage= new HomePage(driver);
			 menuPage = new MenuPage(driver);
		      selectProductPage = new SelectProductPage(driver);
			 addtocartPage = new AddtocartPage(driver);

		}
	@BeforeMethod
	public void clickLoginPage() throws IOException
	{
	//	driver.get(Confic.env);
		driver.get("https:\\www.saucedemo.com");

		String userName = Utility.getDataFromExcelSheet( "C:\\Users\\lenovo\\eclipse-workspace\\MavenEbay\\src\\test\\resources\\DataResources\\PojectTestData.xlsx","Data1", 2,  0);

		loginPage.enterUsername(userName);
		String password = Utility.getDataFromExcelSheet( "C:\\Users\\lenovo\\eclipse-workspace\\MavenEbay\\src\\test\\resources\\DataResources\\PojectTestData.xlsx","Data1", 2,  1);

		loginPage.enterPassword(password);
	
		loginPage.clickonLoginButton();
		 

		
	}
	@Test 
	public void verifyMenuTab() throws InterruptedException, IOException
	{
	     testId = "T901";
		clickLoginPage();
		homePage.clickonMenu();
		homePage.clickonabout();
		
		menuPage.clickonseectMenu(driver);
	
		menuPage.clickonSauceMobile(driver);
	
		
	}
	@Test
	public void ClickAddtocartButton()
	{
		testId = "T902";
		selectProductPage.clickonSelect1Product();
		addtocartPage.clickonaddtocart();
		addtocartPage.clickonCartcontainer();
		
		
	}
	@Test
	public void test3 ()
	{
		testId = "T903";
		System.out.println("Test3");
	}
	

	@AfterMethod
	public void logoutFromApplication(ITestResult result ) throws InterruptedException, IOException
	{
			if(ITestResult.FAILURE == result.getStatus())
		{
				Date date=new Date();
				SimpleDateFormat  sdf=new SimpleDateFormat("dd-MM-yyyy hh mm ss");
				String formattedDate=sdf.format(date);
			
				String f=formattedDate;
				
			  // int testid=Integer.parseInt(testId);
				
					String t="Test - "+ testId +" " +f;
				System.out.println(t);
				TakesScreenshot ts=(TakesScreenshot)driver;
					File src=ts.getScreenshotAs(OutputType.FILE);
			File  dest=new File("C:\\Users\\lenovo\\eclipse-workspace\\MavenEbay\\test-output\\FailedTestScreenShot\\" + t +".png");	//File dest=new File("C:\\Users\\lenovo\\Documents\\Automation\\New folder\\ " + s +".jpeg");		
			
			FileHandler.copy(src, dest);
				
			
			//Utility.captureScreenshot(testId);
		}
		else
		{
			System.out.println("test case Pass");
		}
		
		
	}
	@AfterClass
	public void afterClass()
	{
		LogoutPage logoutPage = new LogoutPage(driver);
		logoutPage.clickMenuTab();
		logoutPage.clickonLogout();
	
		driver.quit();
		
	}
	@AfterTest
	public void afterTest()
	{
		System.out.println("After Test");
		System.gc();
	}



}

