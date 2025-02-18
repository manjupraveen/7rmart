package testscript;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import pages.LoginPage;
import pages.MenuManagementPage;
import utilities.ExcelUtility;

public class MenuManagementTest extends Base {
	@Test
	(description ="checking menu management")
	public void verifynewMenuManagementInformation() {
		String username =  ExcelUtility.getString(1, 0, "LoginPage");
		String password = ExcelUtility.getString(1, 1, "LoginPage");
		String url = ExcelUtility.getString(1, 0, "MenuManagementPage");
		String expectedAlertText =  ExcelUtility.getString(1, 1, "MenuManagementPage");
		String menuName = ExcelUtility.getString(1, 2, "MenuManagementPage");
		LoginPage loginpage = new LoginPage (driver);
		loginpage.enterUsernameOnUsernameField(username);
		loginpage.enterPasswordOnPasswordField(password);
		loginpage.clickLogin();
		MenuManagementPage menumanagementpage = new MenuManagementPage(driver);
		menumanagementpage.navigateToMenuManagementPage(url);
		menumanagementpage.clickAddNewMenu();
		menumanagementpage.enetrMenuName(menuName);
		menumanagementpage.scrollDown();
		menumanagementpage.getAlerttext();
		String actualAlertTextDisplayed = menumanagementpage.getAlerttext();
		assertEquals(actualAlertTextDisplayed,expectedAlertText ,"unable to add new menu");
		
	}
	

}
