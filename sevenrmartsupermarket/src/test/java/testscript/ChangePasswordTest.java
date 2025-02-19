package testscript;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import pages.ChangePasswordPage;
import pages.LoginPage;
import utilities.ExcelUtility;

public class ChangePasswordTest extends Base {
	@Test
	(description = "check whether the user is able to change password", retryAnalyzer= retry.Retry.class)
	public void verifyChangePasswordField() {
		String username = ExcelUtility.getString(1, 0, "LoginPage");
		String password = ExcelUtility.getString(1, 1, "LoginPage");
		String url = ExcelUtility.getString(1, 0, "ChangePasswordPage");
		String expectedAlertText = ExcelUtility.getString(1, 3, "ChangePasswordPage");
		String newpassword = ExcelUtility.getString(1, 2, "ChangePasswordPage");
		LoginPage loginpage = new LoginPage (driver);
		loginpage.enterUsernameOnUsernameField(username).enterPasswordOnPasswordField(newpassword).clickLogin();
		ChangePasswordPage changepasswordpage = new ChangePasswordPage(driver);
		changepasswordpage.navigateToChangePasswordPage(url).enterOldPassword(password).enterNewPassword(newpassword).enterConfirmNewPassword(newpassword).clickChangeButton();
		changepasswordpage.getAlerttext();
		String actualAlertTextDisplayed = changepasswordpage.getAlerttext();
		assertEquals(actualAlertTextDisplayed,expectedAlertText ,"unable to change password");
	}

}
