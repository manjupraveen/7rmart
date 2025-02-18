package testscript;


import static org.testng.Assert.assertTrue;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.LoginPage;
import utilities.ExcelUtility;

public class LoginTest extends Base {
	@Test
	(description = "verify whether user is able to login with correct username and password", groups = ("smoke"))
	public void verifyUerLoginWithValidUsernameandPassword() {
		String username = ExcelUtility.getString(1, 0, "LoginPage");
		String password = ExcelUtility.getString(1, 1, "LoginPage");
		LoginPage loginpage = new LoginPage (driver);
		loginpage.enterUsernameOnUsernameField(username).enterPasswordOnPasswordField(password).clickLogin();
		
		boolean isNavigatedtoHomePage = loginpage.whetherAdminUserTileIsDisplayed();
		assertTrue(isNavigatedtoHomePage, "User is not able to login with valid username and password");
	}
	@Test
	(description ="verify whether user is able to login with correct username and wrong password", groups = ("regression") )
	public void verifyUserLoginWithValidUsernameandInvalidPassword() {
		String username = ExcelUtility.getString(2, 0, "LoginPage");
		String password = ExcelUtility.getString(2, 1, "LoginPage");
		LoginPage loginpage = new LoginPage (driver);
		loginpage.enterUsernameOnUsernameField(username).enterPasswordOnPasswordField(password).clickLogin();
		
		
		boolean isAlertDisplayed = loginpage.alertIsDisplayed();
		assertTrue(isAlertDisplayed, "User is able to login evenif with valid username and invalid password");
		
	}
	@Test
	(description = "verify whether user is able to login with wrong username and correct password")
	public void verifyUserLoginWithWrongUsernameandValidPassword() {
		String username = ExcelUtility.getString(3, 0, "LoginPage");
		String password = ExcelUtility.getString(3, 1, "LoginPage");
		LoginPage loginpage = new LoginPage (driver);
		loginpage.enterUsernameOnUsernameField(username).enterPasswordOnPasswordField(password).clickLogin();
		
		
		boolean isAlertDisplayed = loginpage.alertIsDisplayed();
		assertTrue(isAlertDisplayed, "User is able to login even with invalid username and valid password");
	}
	@Test
	(description = "verify whether user is able to login with wrong username and correct password", dataProvider = "LoginProvider")
	public void verifyUserLoginWithInvalidUsernameandInvalidPassword(String username, String password) {
		//String username = ExcelUtility.getString(4, 0, "LoginPage");
		//String password = ExcelUtility.getString(4, 1, "LoginPage");
		LoginPage loginpage = new LoginPage (driver);
		loginpage.enterUsernameOnUsernameField(username).enterPasswordOnPasswordField(password).clickLogin();
		
		
		boolean isAlertDisplayed = loginpage.alertIsDisplayed();
		assertTrue(isAlertDisplayed, "User is able to login even if  username and password are invalid");
	}
	@DataProvider(name = "LoginProvider")
	public Object[][] getDataFromTestData() {
		return new Object[][] { { ExcelUtility.getString(4, 0, "LoginPage"), ExcelUtility.getString(4, 1, "LoginPage") },{"abc","abc"},
			{"hello" , "hello"},

		};
}
}
