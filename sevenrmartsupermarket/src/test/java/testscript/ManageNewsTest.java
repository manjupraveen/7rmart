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
	loginpage.enterUsernameOnUsernameField(username);
	loginpage.enterPasswordOnPasswordField(password);
	loginpage.clickLogin();
	ManageNewsPage addcategorypage = new ManageNewsPage(driver);
	addcategorypage.navigateToPage(url);
	addcategorypage.enterNews(news);
	addcategorypage.clickSave();
	addcategorypage.getAlertText();
	String actualAlertTextDisplayed = addcategorypage.getAlertText();
	assertEquals(actualAlertTextDisplayed,expectedMessage ,"unable to create news");
}
}
