package testclass;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class DemoTestng {
	@BeforeClass
	public void beforeClass()
    {
	    System.out.println("Before Class"); 	
	}
	@BeforeMethod
	public void beforemethod()
	{
		System.out.println("Before Method");
	}
	@Test(timeOut=1000)
	public void test1() throws InterruptedException
	{
		Thread.sleep(500);
		System.out.println("Test1");
	}
	@Test
	public void test2()
	{
		
		System.out.println("Test2");
		String expectedURL="https://www.facebook.com";
		String actualURL="https://www.facebook.com";
		String expectedTitle="Facebook - log in or sign up";
		String actualTitle = "Facebook - log in or sign up";
		
		Assert.assertEquals(actualTitle, expectedTitle,"Facebook homepage title not match");
		System.out.println("Step 1");
		Assert.assertEquals(actualURL, expectedURL);
		System.out.println("Step 2");
	
	}
	@Test
	public void test3()
	{
		System.out.println("Test3");
		String expectedURL="https://www.facebook.com";
		String actualURL="https://www.facebook.com";
		String expectedTitle="Facebook - log in or sign up";
		String actualTitle = "Facebook - log in or sign up";
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(actualTitle, expectedTitle,"Facebook homepage title not match");
		System.out.println("Step 1");
		Assert.assertEquals(actualURL, expectedURL);
		System.out.println("Step 2");
		softAssert.assertAll();
	
	}
	@Test
	public void test4()
	{
		System.out.println("Test4");
	}

	@AfterMethod
	public void afterMethod()
	{
		System.out.println("After Method");
	}
	@AfterClass
	public void afterClass()
	{
		System.out.println("After Class");
	}


}
