package POMPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.relevantcodes.extentreports.ExtentTest;

public class PilgrimagesPage {
	private WebDriver driver; 
	private ExtentTest test;

	public PilgrimagesPage(WebDriver driver,ExtentTest test) 
	{
		this.driver = driver; 
		this.test = test;
		PageFactory.initElements(driver, this);
	}
	
	public void clickOnTravelPlace(String destination, String source)
	{
		if(destination.equalsIgnoreCase("Shirdi"))
		{
			destination = "Shirdi Package";
		}
		else if(destination.equalsIgnoreCase("Tirupati"))
		{
			destination = "Tirupati (Package Tour)";
		}
		
		String xpath = "//*[@data-name = '"+destination+"']/li[@data-name = '"+source+"']";
		driver.findElement(By.xpath(xpath)).click();
		
		//*[@data-name = Tirupati (Package Tour)]/li[@data-name = Chennai]
		//*[@data-name = 'Tirupati (Package Tour)']/li[@data-name = 'Chennai']
	}
	

}
