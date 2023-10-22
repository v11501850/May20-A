package utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;

public class Utility {
		 private static TakesScreenshot driver;
	public static String getDataFromExcelSheet(String filepath ,String sheetName,int row, int cell) throws IOException
	    {
			InputStream file=new FileInputStream(filepath);
		
			Workbook workbook=WorkbookFactory.create(file);
	    	Sheet sheet=workbook.getSheet(sheetName);
	    	String data=sheet.getRow(row).getCell(cell).getStringCellValue();
	    	
	    	try
	    	{
	    		String celldata1 = sheet.getRow(row).getCell(cell).getStringCellValue();
	    	
	    		
	    		//System.out.println(celldata1);
	    	}
	    	
	    	catch(IllegalStateException refe)
	    	{
	    		
	    		double celldata=sheet.getRow(row).getCell(cell).getNumericCellValue();
	    	
	    	
	    		String convdata=Double.toString(celldata);
	    		//System.out.println(convdata);
	    	}
	    	 catch(NullPointerException refe)
   	 {
		      System.out.println("cell is empty");
	          }
	    	System.out.println(data);
	    file.close(); 
	      return data;
	    }	 
	public static void captureScreenshot(String testId) throws InterruptedException, IOException
	{
		 TakesScreenshot ts=(TakesScreenshot)driver;
		Date date=new Date();
		SimpleDateFormat  sdf=new SimpleDateFormat("dd-MM-yyyy hh mm ss");
		String formattedDate=sdf.format(date);
	
		String f=formattedDate;
		
	   int testid=Integer.parseInt(testId);
		
			String t="Test - "+ testid +"." +f;
		System.out.println(t);
			File src=ts.getScreenshotAs(OutputType.FILE);
	File  dest=new File("C:\\Users\\lenovo\\eclipse-workspace\\MavenEbay\\test-output\\FailedTestScreenShot\\" + t +".png");	//File dest=new File("C:\\Users\\lenovo\\Documents\\Automation\\New folder\\ " + s +".jpeg");		
	
	FileHandler.copy(src, dest);
		
	
		
		
	 }

}
