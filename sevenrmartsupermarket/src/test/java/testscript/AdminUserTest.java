package testscript;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import pages.AdminUserPage;
import pages.LoginPage;
import utilities.ExcelUtility;

public class AdminUserTest extends Base {
	
	@Test
	(description = "verify whether existing username can be added")
	public void verifyWhetherExistingUsernameCanBeCreated() {
		String username = ExcelUtility.getString(1, 0, "LoginPage");
		String password = ExcelUtility.getString(1, 1, "LoginPage");
		String newUsername = ExcelUtility.getString(1, 0, "AdminUserPage");
		String newPassword = ExcelUtility.getString(1, 1, "AdminUserPage");
		String userType= ExcelUtility.getString(1, 2, "AdminUserPage");
		String url = ExcelUtility.getString(1, 3, "AdminUserPage");
		String expectedAlertText = ExcelUtility.getString(1, 4, "AdminUserPage");
		LoginPage loginpage = new LoginPage (driver);
		loginpage.enterUsernameOnUsernameField(username);
		loginpage.enterPasswordOnPasswordField(password);
		loginpage.clickLogin();
		AdminUserPage adminUserPage =new AdminUserPage(driver);
		adminUserPage.navigateToAdminPage(url);
		adminUserPage.clickAddNewUser();
		adminUserPage.enterNewUserDetails(newUsername, newPassword, userType);
		adminUserPage.clickSave();
		adminUserPage.getAlertText();
		String actualAlertTextDisplayed = adminUserPage.getAlertText();
		assertEquals(actualAlertTextDisplayed,expectedAlertText ,"created already existing username");
	}
	@Test
	public void verifySearchAdminUser() {
		
		String username = ExcelUtility.getString(1, 0, "LoginPage");
		String password = ExcelUtility.getString(1, 1, "LoginPage");
		String searchUsername = ExcelUtility.getString(1, 5, "AdminUserPage");
		String searchUserType = ExcelUtility.getString(1, 6, "AdminUserPage");
		String url = ExcelUtility.getString(2, 3, "AdminUserPage");
		LoginPage loginpage = new LoginPage (driver);
		AdminUserPage adminUserPage =new AdminUserPage(driver);
		loginpage.enterUsernameOnUsernameField(username);
		loginpage.enterPasswordOnPasswordField(password);
		loginpage.clickLogin();
		adminUserPage.navigateToAdminPage(url);
		adminUserPage.clickSearch();
		adminUserPage.enterUsernameandUserTypeDetails(searchUsername, searchUserType);
		adminUserPage.clickSearchButton();
		adminUserPage.getSearchResult();
		String actualUsername = adminUserPage.getSearchResult();
		assertEquals(actualUsername,searchUsername, "Failed to find created username");
	}
	@Test
	(description = "verification of new admin user creation")
	public void verifyWhetherNewAdminUserIsCreated() {
		String username = ExcelUtility.getString(1, 0, "LoginPage");
		String password = ExcelUtility.getString(1, 1, "LoginPage");
		String userType= ExcelUtility.getString(1, 2, "AdminUserPage");
		String url = ExcelUtility.getString(3, 3, "AdminUserPage");
		String expectedAlertText = ExcelUtility.getString(2, 4, "AdminUserPage");
        LoginPage loginpage = new LoginPage (driver);
		loginpage.enterUsernameOnUsernameField(username);
		loginpage.enterPasswordOnPasswordField(password);
		loginpage.clickLogin();
		AdminUserPage adminUserPage =new AdminUserPage(driver);
		adminUserPage.navigateToAdminPage(url);
		adminUserPage.clickAddNewUser();
		adminUserPage.createAdminUser();
		adminUserPage.clickSave();
		adminUserPage.getAlertTextOfUserCreated();
		String actualAlertTextDisplayed = adminUserPage.getAlertText();
		assertEquals(actualAlertTextDisplayed,expectedAlertText ,"Unable to create new admin user");
	}
	

	

}

