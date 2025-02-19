package testscript;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import constants.Constant;
import utilities.ScreenShotUtility;
import utilities.WaitUtility;

public class Base {

	
		public WebDriver driver;
	@BeforeMethod
	@Parameters("browser")
	
		public void initialiseBrowser(String browser) throws Exception{
		Properties prop = new Properties() ;
		FileInputStream fs = new FileInputStream(Constant.CONFIGFILE);
		prop.load(fs);
		
		if(browser.equalsIgnoreCase("chrome")) {
			 driver = new ChromeDriver();
		}
		else if(browser.equalsIgnoreCase("firefox"))
		{
			driver = new FirefoxDriver();
		}
		else if (browser.equalsIgnoreCase("Edge"))
		{
			driver = new EdgeDriver();
		}
		else {
			throw new Exception ("wrong browser");
		}
				 driver.get(prop.getProperty("url"));
				 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(WaitUtility.IMPLICIT_WAIT));
				 driver.manage().window().maximize();
		}
	@AfterMethod
	public void browserQuit(ITestResult iTestResult) throws IOException {
		if (iTestResult.getStatus() == ITestResult.FAILURE) {
			ScreenShotUtility scrshot = new ScreenShotUtility();
			scrshot.getScreenShot(driver, iTestResult.getName());
		}

		driver.quit();
	}
}
