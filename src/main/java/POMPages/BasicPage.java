package POMPages;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class BasicPage {
	

	
private WebDriver driver; 
private ExtentTest test;

	public BasicPage(WebDriver driver, ExtentTest test) {
		this.driver = driver; 
		this.test = test;
		PageFactory.initElements(driver, this);
	}
	
	//Source Address WebElement
	@FindBy(xpath = "//*[@id = 'src']")
	private WebElement sourceAddress;
	
	//Destination Address WebElement
	@FindBy(xpath = "//*[@id = 'dest']")
	private WebElement destAddress;
	
	//Date selection
	@FindBy(xpath = "//*[@class = 'fl search-box date-box gtm-onwardCalendar']")
	private WebElement dateSelection;
	
	//table
	@FindBy(xpath = "//*[@id = 'rb-calendar_onward_cal']/table/tbody")
	private WebElement table;
	
	//Previous button in calendar
	@FindBy(xpath = "//*[@id = 'rb-calendar_onward_cal']/table/tbody/tr[1]/td[1]")
	private WebElement previousMonthBtn;
	
	//Next month button in calendar
	@FindBy(xpath = "//*[@id = 'rb-calendar_onward_cal']/table/tbody/tr[1]/td[3]")
	private WebElement nextMonthBtn;
	
	//Current Month in calendar
	@FindBy(xpath = "//*[@id = 'rb-calendar_onward_cal']/table/tbody/tr[1]/td[2]")
	private WebElement currentMonthTxt;
	
	//search button
	@FindBy(xpath = "//*[@id = 'search_btn']")
	private WebElement searchBtn;
	
	//Pilgrimages Link
	@FindBy(id = "pilgrimages")
	private WebElement pilgrimagesLink;
	
	public void clickOnPilgrimagesLink()
	{
		this.pilgrimagesLink.click();
	}
	
	public void selectDate(String date, String month)
	{ 
		String currne = getCurrentMonthValue();//Apr 2020
		//System.out.println(currne.substring(0,3)); -- Apr
		if((currne.substring(0,3)).equalsIgnoreCase(month))
		{
			
			selectCalendarDate(date);
		}
		else
		{
			clicknextMonthBtn();
			selectCalendarDate(date);
		}
		test.log(LogStatus.INFO, "Journey Date selected");	
	}
	public void selectCalendarDate(String date)
	{

		List<WebElement> row_table = this.table.findElements(By.xpath("//*[@id = 'rb-calendar_onward_cal']/table/tbody/tr"));
		int row_count = row_table.size();
		System.out.println("row count " +row_count);
		
		for(int row = 0 ; row <row_count ; row++)
		{
			
			List<WebElement> col_row = row_table.get(row).findElements(By.tagName("td"));
			int col_count = col_row.size();
			System.out.println("col count " +col_count);
		
			for(int col = 0 ; col <col_count ; col++)
			{
				if((col_row.get(col).getText()).equals(date))
				{
					col_row.get(col).click();
				}
			}
		
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	public void enterSourceAddress(String source)
	{
		this.sourceAddress.sendKeys(source);
		test.log(LogStatus.INFO, "Source value Entered");
		
	}
	
	public void enterDestinationAddress(String destination)
	{
		this.destAddress.sendKeys(destination);
		test.log(LogStatus.INFO, "Destination value Entered");
	}
	public void selectCalender()
	{
		this.dateSelection.click();
	}
	
	public void clickPreviousMonthBtn()
	{
		this.previousMonthBtn.click();
	}
	
	public void clicknextMonthBtn()
	{
		this.nextMonthBtn.click();
	}
	public String getCurrentMonthValue()
	{
		String currentMonth = "";
		currentMonth = this.currentMonthTxt.getText();
		
		return currentMonth;
	}
	public String getcurrentDate()
	{

		Date date = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy");
		String currentDate = sdf.format(date);
		//System.out.println(currentDate);
		return currentDate;
	}
	public void clickOnSearchBtn()
	{
		this.searchBtn.click();
		test.log(LogStatus.INFO, "Clicked on Search Button");
	}
}
