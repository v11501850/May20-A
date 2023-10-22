package testNgsauceDemo;


import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestResult;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import Pages.AddtocartPage;
import Pages.ClickrequestDemoPage;
import Pages.EnterTheDetailsPage;
import Pages.HomePage;
import Pages.LoginPage;
import Pages.LogoutPage;

import Pages.SelectProductPage;
import base.Browser;
import utility.Utility;

public class VerifyCheckoutPage extends Browser{
	public WebDriver driver;
	private LoginPage loginPage;
	private SelectProductPage selectProductPage;
	private EnterTheDetailsPage entertheDetailsPage;
	private AddtocartPage addtocartPage;
	private String testId ;
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
	    System.out.println("Before Class"); 	
	}
	@BeforeClass
	public void creatingPOMObject()
	{
		 loginPage= new LoginPage(driver);
		 selectProductPage = new SelectProductPage(driver);
		 addtocartPage = new AddtocartPage(driver);
         entertheDetailsPage = new EnterTheDetailsPage(driver);


	}
	
	@BeforeMethod
	@DataProvider(name="test1Data")
	public void openLoginPage() throws IOException, InterruptedException
	{
		driver.get("https:\\www.saucedemo.com");
		String userName = Utility.getDataFromExcelSheet( "C:\\Users\\lenovo\\eclipse-workspace\\MavenEbay\\src\\test\\resources\\DataResources\\PojectTestData.xlsx","Data1", 1,  0);
    
		loginPage.enterUsername(userName);
		String password = Utility.getDataFromExcelSheet( "C:\\Users\\lenovo\\eclipse-workspace\\MavenEbay\\src\\test\\resources\\DataResources\\PojectTestData.xlsx","Data1", 1,  1);
       
		loginPage.enterPassword(password);
		loginPage.clickonLoginButton();
		
		System.out.println("Before Method");
	}
	
	
 	
  
	
	@Test
	public void verifyCartcontainer() throws InterruptedException
	{
		testId = "T101";
		selectProductPage.clickonSelect1Product();
		addtocartPage.clickonaddtocart();
		addtocartPage.clickonCartcontainer();
		addtocartPage.clickonCheckout();
		entertheDetailsPage.enterFirstname();
		entertheDetailsPage.enterLastname();
		entertheDetailsPage.enterZipcode();
		entertheDetailsPage.clickContinue();
		entertheDetailsPage.clickFinish();
		
		System.out.println("Test1");
	}
	@Test
	public void VerifyMenuTab()
	{
		testId ="T102";
		HomePage homePage = new HomePage(driver);
		homePage.clickonMenu();
		homePage.clickonabout();
		ClickrequestDemoPage clickrequestdemo = new ClickrequestDemoPage(driver);
		clickrequestdemo.clickonrequestDemo(driver);
		System.out.println("Test2");
	}
	@Test  
	public void test3()
	{
		testId = "T201";
		System.out.println("Test3");
	}
	@Test
	public void test4()
	{
		testId ="T202";
		System.out.println("Test4");
	}

	@AfterMethod
	
		public void captureScreen(ITestResult result) throws InterruptedException, IOException
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
		File  dest=new File("C:\\Users\\lenovo\\eclipse-workspace\\MavenEbay\\test-output\\FailedTestScreenShot\\" + t +".png");			
		
		FileHandler.copy(src, dest);
			
		
		//Utility.captureScreenshot(testId);
	}
	else
	{
		System.out.println("test case Pass");
	}
					
					
	     }

	@AfterClass
	public void afterclass()
	{
		LogoutPage logoutPage = new LogoutPage(driver);
		logoutPage.clickMenuTab();
		logoutPage.clickonLogout();
		System.out.println("After Method");
	    driver.quit();
		System.out.println("After Class");
	}
	@AfterTest
	public void afterTest()
	{
		System.out.println("After Test");
		System.gc();
	}


}



