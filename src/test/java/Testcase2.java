import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

import Generics.ApachiPOIReadingWriting;
import Generics.BrowserSetup;
import Generics.ExtentReport;
import Generics.ScreenShot;
import POMPages.BasicPage;
import POMPages.BusSelectPage;
import POMPages.PilgrimagesPage;

public class Testcase2 {

	private WebDriver driver;
	//String journeydate = "21";
	//String month = "Apr";
	private ExtentReports extent;
	private ExtentReport extentReport;
	private ExtentTest test;
	private BrowserSetup browserSetup = new BrowserSetup();
	private ScreenShot screenShot;
	private BasicPage basicPage;
	private PilgrimagesPage pilgrimagesPage;
    private BusSelectPage busSelectPage;
    private ApachiPOIReadingWriting apachiPOIReadingWriting = new ApachiPOIReadingWriting();
	String[][] maininputValues =  apachiPOIReadingWriting.getExcelContent("C:\\Users\\AmbavarapuSatyabrahm\\Desktop\\RedBus\\TestCase2\\InputData.xlsx");
	
   
    
    @BeforeMethod
    public void browserSetup() throws InterruptedException
    {
    	extent = extentReport.getInstance();   
		test = extent.startTest("Booking Bus ticket in Red Bus Application for PILGRIMAGES "); 
		screenShot = new ScreenShot(driver);
    	driver = browserSetup.openBrowser("CHROME");
		basicPage = new BasicPage(driver,test);
		busSelectPage = new BusSelectPage(driver,test);
		pilgrimagesPage = new PilgrimagesPage(driver, test);
		driver.get("https://www.redbus.in");		
		Thread.sleep(2000);
		//System.out.println(maininputValues[1][2]);
		//System.out.println(maininputValues[1][3]);
    }
	
	@Test
	public void busBooking() throws InterruptedException
	{
		basicPage.clickOnPilgrimagesLink();
		Thread.sleep(4000);
		pilgrimagesPage.clickOnTravelPlace(maininputValues[1][0], maininputValues[1][1]);
		
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
