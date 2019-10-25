/* **************** ==>    Author: Muhammad Bilal Khawar  <==       **************** 
 * ****************        Version: 0.01                            **************** 
 * ****************        Completed: Friday, October 25, 2019      **************** 
 */

package weightwatchersassignment;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class WeightWatchTest extends BaseClass {
	
	public String TitleMatch;
	public List<WebElement> TitleName;

	@BeforeTest // Initializing the WebDriver
	public void setup() {
		BaseClass.setBrowserProperty();
		BaseClass.initialization();	
	}
	
	@Test(priority = 1)
// 2. Verify loaded page title Contains “Weight Loss”
	public void verifyStringInTheTitle() {
		String Title = driver.getTitle();
		System.out.println("Current Page Url: "+driver.getCurrentUrl()+"\n|"+"Current Page title: "+Title);
		Assert.assertTrue(Title.contains("Weight Loss"));

	}

		
	@Test(priority = 2)
// 3. On the right corner of the page, click on “Find a studio”
	public void findAStudioButtonClick() {
		driver.findElement(By.xpath("//*[@id=\'ela-menu-visitor-desktop-supplementa_find-a-studio\']/span")).click();
	}
	
// 4. Verify loaded page title contains “Meetings Near You”
	@Test(priority = 3)
	public void verifyStringInAFindAStudioPageTitle() {
		String Title = driver.getTitle();
		System.out.println("Current Page Url: "+driver.getCurrentUrl()+"\n|"+"Current Page title: "+Title);
		Assert.assertTrue(Title.contains("Meetings Near You"));

	}
// 5. In the search field, search for meetings for zip code: 10011	
	@Test (priority = 4)
	public void enterZipCodeAndSearch() {
		driver.findElement(By.xpath("//input[@type = 'text'][@id = 'meetingSearch']")).sendKeys("10011");
		driver.findElement(By.xpath("//button[@type = 'button']")).click();
		
	}
// 6. Print the title of the first result and the distance (located on the right of location title/name)	
	@Test (priority = 5)
	public void printTheTitleAndDistanceOfFirstResult() {
		
		TitleName = driver.findElements(By.xpath("//div[@class='meeting-location']//div//a/descendant::span[@ng-if = '!linkName']"));
	// xpath to locate the Title - using descendant concept
		List<WebElement> Distance = driver.findElements(By.xpath("//div[@class='meeting-location']//div//a/descendant::div[@ng-if = 'showDistance']"));
	// xpath to locate the distance - using descendant concept
		TitleMatch = TitleName.get(0).getText();
		System.out.println("Title of the First Seaarch Result: "+TitleMatch);
		System.out.println("Distance of the First Search Result:" +Distance.get(0).getText());	
/*
		System.out.println(TitleName.size());
		for ( int i = 0; i < TitleName.size(); i++)
		{
			//System.out.println(list.get(i).findElement(By.xpath("//span[@ng-if = '!linkName']")).getText());
			System.out.println(TitleName.get(i).getText());
			System.out.println(Distance.get(i).getText());
		}
		*/
		
	}
	
// 7. Click on the first search result and then, verify displayed location name matches with the name of the first searched result that was clicked.
	
	@Test (priority = 6)
	public void firstSearchClickAndNameMatch() {
		TitleName.get(0).click();
		String NewPageTitle = driver.findElement(By.xpath("//span[@ng-if='!linkName']")).getText();
		Assert.assertEquals(TitleMatch, NewPageTitle);
		System.out.println("Original Title: "+TitleMatch+" "+"New Page Title: "+ NewPageTitle);		
	}
	
	@Test (priority = 7)
// 8. From this location page, print TODAY’s hours of operation (located towards the bottom of the page)
	public void printTodaysHoursOfOperation() {
		Calendar calendar = Calendar.getInstance();
		Date date = calendar.getTime();
		String Day = new SimpleDateFormat("EE", Locale.ENGLISH).format(date.getTime());
		//System.out.println(Day);
		
		List<WebElement> DayNames = driver.findElements(By.xpath("//ul[@class = 'hours-list list-unstyled hours-list--count-7']//li/descendant::div[@class = 'hours-list-item-day']"));
		
		List<WebElement> OperationHours = driver.findElements(By.xpath("//ul[@class = 'hours-list list-unstyled hours-list--count-7']//li/descendant::div[@ng-repeat = 'meeting in day.meetings']"));
		//System.out.println("OperationHours: "+OperationHours.get(0).getText());
			
		
		for (int i = 0;i< DayNames.size();i++)
		{
			if(DayNames.get(i).getText().equalsIgnoreCase(Day)) {
				System.out.println("Today's Operation Hours: "+OperationHours.get(i).getText());
				System.out.println("You've got what you were looking for - Bye Bye :)");
				break;
			}
		}
		
		// Xpath for Studio Schedule:
		//List<WebElement> DayNames = driver.findElements(By.xpath("//div[@class='schedule-detailed']//div/descendant::div[@class = 'schedule-detailed-day-label']"));
				//System.out.println("DayNames: "+DayNames.get(0).getText());

				//List<WebElement> DayNamesAndSchedule = driver.findElements(By.xpath("//div[@class='schedule-detailed-day']"));
				//System.out.println("DayNamesAndSchedule: "+DayNamesAndSchedule.get(0).getText());

				// TimeHour Xpath
				//ul[@class = 'hours-list list-unstyled hours-list--count-7']//li/descendant
				
				//List<WebElement> DayNamesAndSchedule = driver.findElements(By.xpath("//ul[@class = 'hours-list list-unstyled hours-list--count-7']"));
				//System.out.println("DayNamesAndSchedule: "+DayNamesAndSchedule.get(0).getText());
	
	}
	
	@AfterTest
	public void tearDown()
	{
		driver.quit();
	}
}
