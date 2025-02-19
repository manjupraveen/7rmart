package testscript;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import pages.ManageNewsPage;
import utilities.ExcelUtility;
import pages.LoginPage;


public class ManageNewsTest extends Base {
	
@Test
(description = "enter news information")
public void verifyEnterNewsInformation() {
	String username = ExcelUtility.getString(1, 0, "LoginPage");
	String password = ExcelUtility.getString(1, 1, "LoginPage");
	String url = ExcelUtility.getString(1, 0, "ManageNewsPage");
	String news = ExcelUtility.getString(1, 1, "ManageNewsPage");
	String expectedMessage = ExcelUtility.getString(1, 2, "ManageNewsPage");
	LoginPage loginpage = new LoginPage (driver);
	loginpage.enterUsernameOnUsernameField(username).enterPasswordOnPasswordField(password).clickLogin();
	ManageNewsPage managenewspage = new ManageNewsPage(driver);
	managenewspage.navigateToPage(url).enterNews(news).clickSave();
	managenewspage.getAlertText();
	String actualAlertTextDisplayed = managenewspage.getAlertText();
	assertEquals(actualAlertTextDisplayed,expectedMessage ,"unable to create news");
}
}
