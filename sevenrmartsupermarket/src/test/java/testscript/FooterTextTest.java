package testscript;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import pages.FooterTextPage;
import pages.LoginPage;
import utilities.ExcelUtility;

public class FooterTextTest extends Base  {
@Test
(description = "checking footer text updation")
public void verifyfooterTextUpdation() {
	String username =  ExcelUtility.getString(1, 0, "LoginPage");
	String password = ExcelUtility.getString(1, 1, "LoginPage");
	String url = ExcelUtility.getString(1, 0, "FooterTextPage");
	String expectedAlertText =  ExcelUtility.getString(1, 2, "FooterTextPage");
	LoginPage loginpage = new LoginPage (driver);
	loginpage.enterUsernameOnUsernameField(username).enterPasswordOnPasswordField(password).clickLogin();
	FooterTextPage footertextpage = new FooterTextPage(driver);
	footertextpage.navigateToSubcategoryPage(url).clickActionButton().createEmail().scrollDown();
	footertextpage.getAlerttext();
	String actualAlertTextDisplayed = footertextpage.getAlerttext();
	assertEquals(actualAlertTextDisplayed,expectedAlertText ,"unable to update footer text");
}
}
