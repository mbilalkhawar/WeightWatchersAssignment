package weightwatchersassignment;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class TestUtil extends BaseClass {
	
	public static long IMPLICIT_WAIT = 10;
	public static long PAGE_TIMEOUT = 40;
	
	public void captureScreenShot(String username) {
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(src, new File("//Volumes//Biaz -MedD1//bill//biaz//WeightWatchers_ByBilal//resources//"+(username)+".png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	

}
}
