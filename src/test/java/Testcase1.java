import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;


import Generics.ApachiPOIReadingWriting;
import Generics.BrowserSetup;
import Generics.ExtentReport;
import Generics.ScreenShot;
import POMPages.BasicPage;
import POMPages.BusSelectPage;

public class Testcase1 {

	private WebDriver driver;
	//String journeydate = "21";
	//String month = "Apr";
	private ExtentReports extent;
	private ExtentReport extentReport;
	private ExtentTest test;
	private BrowserSetup browserSetup = new BrowserSetup();
	private ScreenShot screenShot;
	private BasicPage basicPage;
    private BusSelectPage busSelectPage;
    private ApachiPOIReadingWriting apachiPOIReadingWriting = new ApachiPOIReadingWriting();
	String[][] maininputValues =  apachiPOIReadingWriting.getExcelContent("C:\\Users\\AmbavarapuSatyabrahm\\Desktop\\RedBus\\InputData.xlsx");
	
   
    
    @BeforeMethod
    public void browserSetup() 
    {
    	extent = extentReport.getInstance();   
		test = extent.startTest("Booking Bus ticket in Red Bus Application"); 
		driver = browserSetup.openBrowser("CHROME");
		basicPage = new BasicPage(driver,test);
		busSelectPage = new BusSelectPage(driver,test);
		screenShot = new ScreenShot(driver);
		driver.get("https://www.redbus.in");		
		//Thread.sleep(2000);
		//System.out.println(maininputValues[1][2]);
		//System.out.println(maininputValues[1][3]);
    }
	
	@Test
	public void busBooking() throws InterruptedException 
	{
		
		
		basicPage.enterSourceAddress(maininputValues[1][0]);
		Thread.sleep(2000);
		basicPage.enterDestinationAddress(maininputValues[1][1]);
		screenShot.captureScreenShot();
		Thread.sleep(2000);
		
		basicPage.selectCalender();
		Thread.sleep(2000)
		
		;
		basicPage.selectDate(maininputValues[1][3], maininputValues[1][2]);
		Thread.sleep(3000);	
		screenShot.captureScreenShot();
		/*
		basicPage.clickOnSearchBtn();
		Thread.sleep(3000);
		busSelectPage.clickOnLiveTrackingTickmark(maininputValues[1][4]);
		Thread.sleep(2000);
		busSelectPage.clickOnReschedulableTickmark(maininputValues[1][5]);
		Thread.sleep(2000);
		busSelectPage.clickOnDepartureTimeTickmark(maininputValues[1][6]);
		Thread.sleep(2000);
		busSelectPage.acBusSelection(maininputValues[1][8]);
		screenShot.captureScreenShot();
		
		Thread.sleep(3000);
		busSelectPage.selectHighRatingBus();
		Thread.sleep(5000);
		screenShot.captureScreenShot();
		*/
		
	}
	@AfterMethod
	public void driverTermination()
	{
		extent.endTest(test);
		extent.flush();
		extent.close();
		driver.close();
	}
	
}
