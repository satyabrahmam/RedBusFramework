package Generics;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class BrowserSetup {
	
	private static WebDriver driver; 
	//BROWSERS
	 String CHROME ="CHROME";
	 String FIREFOX = "FIREFOX";
	 String IE ="IE";
	
	//KEYS
	 String CHROME_KEY ="webdriver.chrome.driver"; 
	 String FIREFOX_KEY ="webdriver.firefox.marionette"; 
	 String IE_KEY ="webdriver.ie.driver";
	
	
	// PATH 
	 String CHROME_PATH="C:\\Users\\AmbavarapuSatyabrahm\\Downloads\\chromedriver_win32\\chromedriver.exe";
	 String FIREFOX_PATH ="";
	 String IE_PATH ="";
	
	public WebDriver openBrowser(String browser)
	{
		if(CHROME.equals(browser)){
			System.setProperty(CHROME_KEY, CHROME_PATH);
			driver = new ChromeDriver();
		
			
		}else if(FIREFOX.equals(browser)){
			System.setProperty(FIREFOX_KEY, FIREFOX_PATH);
			driver = new FirefoxDriver();
			
		
		
		}
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		return driver;
	}
	
	

}
