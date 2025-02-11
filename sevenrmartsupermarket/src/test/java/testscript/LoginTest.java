package testscript;


import static org.testng.Assert.assertTrue;
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
		loginpage.enterUsernameOnUsernameField(username);
		loginpage.enterPasswordOnPasswordField(password);
		loginpage.clickLogin();
		boolean isNavigatedtoHomePage = loginpage.whetherAdminUserTileIsDisplayed();
		assertTrue(isNavigatedtoHomePage, "User is not able to login with valid username and password");
	}
	@Test
	(description ="verify whether user is able to login with correct username and wrong password", groups = ("regression") )
	public void verifyUserLoginWithValidUsernameandInvalidPassword() {
		String username = "admin";
		String password = "123";
		LoginPage loginpage = new LoginPage (driver);
		loginpage.enterUsernameOnUsernameField(username);
		loginpage.enterPasswordOnPasswordField(password);
		loginpage.clickLogin();
		boolean isAlertDisplayed = loginpage.alertIsDisplayed();
		assertTrue(isAlertDisplayed, "User is able to login evenif with valid username and invalid password");
		
	}
	@Test
	(description = "verify whether user is able to login with wrong username and correct password")
	public void verifyUserLoginWithWrongUsernameandValidPassword() {
		String username = "admn";
		String password = "admin";
		LoginPage loginpage = new LoginPage (driver);
		loginpage.enterUsernameOnUsernameField(username);
		loginpage.enterPasswordOnPasswordField(password);
		loginpage.clickLogin();
		boolean isAlertDisplayed = loginpage.alertIsDisplayed();
		assertTrue(isAlertDisplayed, "User is able to login even with invalid username and valid password");
	}
	@Test
	(description = "verify whether user is able to login with wrong username and correct password")
	public void verifyUserLoginWithInvalidUsernameandInvalidPassword() {
		String username = "admn";
		String password = "123";
		LoginPage loginpage = new LoginPage (driver);
		loginpage.enterUsernameOnUsernameField(username);
		loginpage.enterPasswordOnPasswordField(password);
		loginpage.clickLogin();
		boolean isAlertDisplayed = loginpage.alertIsDisplayed();
		assertTrue(isAlertDisplayed, "User is able to login even if  username and password are invalid");
	}	
}
