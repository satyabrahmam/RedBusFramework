package Generics;

import java.io.File;
import java.io.IOException;
import java.util.Calendar;
import java.util.GregorianCalendar;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;


public class ScreenShot {
private WebDriver driver; 
	
	// the driver information will be given by selenium test case 
	public ScreenShot(WebDriver driver){
		this.driver = driver; 
	}
	
	public void captureScreenShot(){
		
		// to be changed 
		String path = "C:\\Users\\AmbavarapuSatyabrahm\\Desktop\\RedBus\\Screenshots\\";
		String fileName ="";

		GregorianCalendar calendar = new GregorianCalendar(); 
		
		int date =  calendar.get(Calendar.DATE); 
		int minute = calendar.get(Calendar.MINUTE);
		int second = calendar.get(Calendar.SECOND); 
		
		
		fileName = new Integer(date).toString() + "-" + new Integer(minute).toString() +"-" +
					new Integer(second).toString() +".png"; 
		
		// 1. create file 
		// 2. capture screenshot from selenium 
		// 3. store it in physical driver 
		
		
		try {
			TakesScreenshot takeScreenShot  = (TakesScreenshot) driver; 
			File file = takeScreenShot.getScreenshotAs(OutputType.FILE);
			
			
			FileUtils.copyFile(file, new File(path +fileName));
		} catch (WebDriverException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		
	}
	

	public void captureScreenShot(String fileName){
		
		String path =  "C:\\Users\\AmbavarapuSatyabrahm\\Desktop\\RedBus\\Screenshots\\";
		ScreenShot a = new ScreenShot(driver);
		
		// 1. create file 
		// 2. capture screenshot from selenium 
		// 3. store it in physical driver 
		
		try {
			TakesScreenshot takeScreenShot  = (TakesScreenshot) driver; 
			File file = takeScreenShot.getScreenshotAs(OutputType.FILE);
			
			FileUtils.copyFile(file, new File(path+fileName+".png"));
		} catch (WebDriverException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}


}
