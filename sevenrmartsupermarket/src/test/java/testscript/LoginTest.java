package testscript;


import static org.testng.Assert.assertTrue;
import org.testng.annotations.Test;
import pages.LoginPage;

public class LoginTest extends Base {
	@Test
	(description = "verify whether user is able to login with correct username and password")
	public void verifyValidUsernameandPassword() {
		String username = "admin";
		String password = "admin";
		LoginPage loginpage = new LoginPage (driver);
		loginpage.enterUsernameOnUsernameField(username);
		loginpage.enterPasswordOnPasswordField(password);
		loginpage.clickLogin();
		boolean isNavigatedtoHomePage = loginpage.whetherAdminUserTileIsDisplayed();
		assertTrue(isNavigatedtoHomePage, "User is not able to login with valid username and password");
	}
	@Test
	(description ="verify whether user is able to login with correct username and wrong password" )
	public void verifyValidUsernameandInvalidPassword() {
		String username = "admin";
		String password = "123";
		LoginPage loginpage = new LoginPage (driver);
		loginpage.enterUsernameOnUsernameField(username);
		loginpage.enterPasswordOnPasswordField(password);
		loginpage.clickLogin();
		boolean isAlertDisplayed = loginpage.alertIsDisplayed();
		assertTrue(isAlertDisplayed, "User is able to login with valid username and invalid password");
		
	}
	@Test
	(description = "verify whether user is able to login with wrong username and correct password")
	public void verifyWrongUsernameandValidPassword() {
		String username = "admn";
		String password = "admin";
		LoginPage loginpage = new LoginPage (driver);
		loginpage.enterUsernameOnUsernameField(username);
		loginpage.enterPasswordOnPasswordField(password);
		loginpage.clickLogin();
		boolean isAlertDisplayed = loginpage.alertIsDisplayed();
		assertTrue(isAlertDisplayed, "User is able to login with invalid username and valid password");
	}
	@Test
	(description = "verify whether user is able to login with wrong username and correct password")
	public void verifyInvalidUsernameandInvalidPassword() {
		String username = "admn";
		String password = "123";
		LoginPage loginpage = new LoginPage (driver);
		loginpage.enterUsernameOnUsernameField(username);
		loginpage.enterPasswordOnPasswordField(password);
		loginpage.clickLogin();
		boolean isAlertDisplayed = loginpage.alertIsDisplayed();
		assertTrue(isAlertDisplayed, "User is able to login with invalid username and invalid password");
	}	
}
