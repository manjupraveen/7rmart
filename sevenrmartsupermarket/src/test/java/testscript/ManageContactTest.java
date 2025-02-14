package testscript;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import pages.LoginPage;
import pages.ManageContactPage;
import utilities.ExcelUtility;

public class ManageContactTest extends Base {
	@Test
	(description = "checking update of contact details")
	public void verifyContactDetailUpdate() {
		String username =  ExcelUtility.getString(1, 0, "LoginPage");
		String password = ExcelUtility.getString(1, 1, "LoginPage");
		String url = ExcelUtility.getString(1, 0, "ManageContactPage");
		String expectedAlertText =  ExcelUtility.getString(1, 1, "ManageContactPage");
		LoginPage loginpage = new LoginPage (driver);
		loginpage.enterUsernameOnUsernameField(username);
		loginpage.enterPasswordOnPasswordField(password);
		loginpage.clickLogin();
		ManageContactPage managecontactpage = new ManageContactPage(driver);
		managecontactpage.navigateToManageCoontactPage(url);
		managecontactpage.clickActionButton();
		managecontactpage.clearPhoneNumberField();
		managecontactpage.enterPhoneNumber();
		managecontactpage.scrollDown();
		managecontactpage.getAlerttext();
		String actualAlertTextDisplayed = managecontactpage.getAlerttext();
		assertEquals(actualAlertTextDisplayed,expectedAlertText ,"unable to update contact");
	}

}
