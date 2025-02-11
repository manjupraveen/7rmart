package testscript;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import pages.AdminUserPage;
import pages.LoginPage;

public class AdminUserTest extends Base {
	
	@Test
	(description = "verify whether existing username can be added")
	public void verifyWhetherExistingUsernameCanBeCreated() {
		String username = "admin";
		String password = "admin";
		String newUsername = "Vihaan";
		String newPassword = "vichu";
		String userType= "Staff";
		String url = "https://groceryapp.uniqassosiates.com/admin/list-admin";
		String expectedAlertText = "Username already exists.";
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
		
		String username = "admin";
		String password = "admin";
		String searchUsername = "Vihaan123";
		String searchUserType = "Staff";
		String url = "https://groceryapp.uniqassosiates.com/admin/list-admin";
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
		String username = "admin";
		String password = "admin";
		String userType= "Staff";
		String url = "https://groceryapp.uniqassosiates.com/admin/list-admin";
		String expectedAlertText = "User Created Successfully";
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

