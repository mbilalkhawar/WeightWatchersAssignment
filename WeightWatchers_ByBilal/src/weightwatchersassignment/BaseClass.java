package weightwatchersassignment;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseClass {
	public static WebDriver driver;
	public static WebElement webelement;
	
	public static void setBrowserProperty() {
		 System.setProperty("Webdriver.chrome.driver", "//Volumes//Biaz -MedD1//bill//biaz//WeightWatchers_ByBilal//resources//chromedriver");
		 driver = new ChromeDriver();	
	}
	

	public static void initialization() {
		// TODO Auto-generated method stub
		 driver.get("https://www.weightwatchers.com/us/");
		 driver.manage().window().maximize();
		 driver.manage().deleteAllCookies();
		 driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_TIMEOUT, TimeUnit.SECONDS);
		 driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		 
		
	}
}


