package POMPages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class BusSelectPage {
	
	private WebDriver driver; 
	private ExtentTest test;

	public BusSelectPage(WebDriver driver,ExtentTest test) {
		this.driver = driver; 
		this.test = test;
		PageFactory.initElements(driver, this);
	}
	
	//Live Tracking 'Tick Mark' Selection
	@FindBy(xpath = "//*[@class = 'addn-filters']/li[1]/i[@class = 'icon icon-tick_single fr']")
	private WebElement liveTrackingTick;

	//Reschedulable 'Tick Mark' Selection
	@FindBy(xpath = "//*[@class = 'addn-filters']/li[2]/i[@class = 'icon icon-tick_single fr']")
	private WebElement reschedulableTick;
	
	//Departure Time selection
	@FindBy(xpath = "//*[@class = 'dept-time dt-time-filter']/li[3]/label[1]")
	private WebElement departureTimeSeletion3;
	
	//Departure Time selection
	@FindBy(xpath = "//*[@class = 'dept-time dt-time-filter']/li[4]/label[1]")
	private WebElement departureTimeSeletion4;
	//AC Bus selection
	@FindBy(xpath = "//*[@title = 'AC']/preceding-sibling::label")
	private WebElement acBusSelection;
	
	//Green Color buses checking
	@FindBy(xpath = "lh-18 rating rat-green")
	private WebElement greenColorChecking;
	
	
	
	public void clickOnLiveTrackingTickmark(String selection)
	{
		if(selection.equalsIgnoreCase("Y"))
		{
			this.liveTrackingTick.click();
			test.log(LogStatus.INFO, "Live Tracking Option selected");	
		}
		test.log(LogStatus.INFO, "Live Tracking Option not selected");	
	}
	
	public void clickOnReschedulableTickmark(String selection)
	{
		if(selection.equalsIgnoreCase("Y"))
		{
			this.reschedulableTick.click();
			test.log(LogStatus.INFO, "Bus Reschedule Option selected");	
		}
	}
	
	public void clickOnDepartureTimeTickmark(String selection)
	{
		//System.out.println("selection: " +selection);
		if(selection.equalsIgnoreCase("3"))
		{
			this.departureTimeSeletion3.click();
		}
		else if(selection.equalsIgnoreCase("4"))
		{
			this.departureTimeSeletion4.click();
		}
	}
	public void acBusSelection(String selection)
	{
		if(selection.equalsIgnoreCase("Y"))
		{
			this.acBusSelection.click();
		}
	}
	public boolean checkingGreenColor()
	{
		boolean color = false;
		try
		{
			greenColorChecking.isDisplayed();
		}
		catch(Exception e)
		{
			color = false;
		}
		return color;
	}
	public void selectHighRatingBus()
	{
		String value = "";
		float a = 0;
		float b = 0;
		List<WebElement> busRatings = driver.findElements(By.xpath("//*[@class = 'icon icon-ic-star d-block']/following-sibling::span"));
		int ratingCount = busRatings.size();
		for(int i = 0; i<ratingCount;i++)
		{
			//System.out.println("a :"+ a);
			//System.out.println("b :"+ b);
			value = busRatings.get(i).getText();
			b = Float.parseFloat(value);
			if(b>a)
			{
				a = b;
			}
			System.out.println(value);
		}
		//System.out.println("a-- :"+ a);
		//System.out.println("b-- :"+ b);
		String xpath = "//*[@class = 'icon icon-ic-star d-block']/following-sibling::span[text() = "+a+"]/ancestor::div[@class = 'clearfix bus-item-details']/following-sibling::div/div[text() = 'View Seats']";
		driver.findElement(By.xpath(xpath)).click();
		//return value;
		
	}
}
