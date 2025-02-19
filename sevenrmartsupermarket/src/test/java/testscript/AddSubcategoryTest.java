package testscript;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import pages.AddSubcategoryPage;
import pages.LoginPage;
import utilities.ExcelUtility;

public class AddSubcategoryTest extends Base {
	LoginPage loginpage;
	AddSubcategoryPage addsubcatpage;
	@Test
	(description = "verifying subcategory creation")
	public void verifySubcategoryCreation() {
		String username = ExcelUtility.getString(1, 0, "LoginPage");
		String password = ExcelUtility.getString(1, 1, "LoginPage");
		String url = ExcelUtility.getString(1, 0, "SubcategoryPage");
		String expectedAlertText = ExcelUtility.getString(1, 2, "SubcategoryPage");
		loginpage = new LoginPage (driver);
		addsubcatpage =loginpage.enterUsernameOnUsernameField(username).enterPasswordOnPasswordField(password).clickLogin().
		navigateToSubcategoryPage(url).clicknewSubCategory().chooseselectCategory().enterSubcategory().chooseImageFile().clickCreateSubcategory();
		addsubcatpage.getAlerttext();
		String actualAlertTextDisplayed = addsubcatpage.getAlerttext();
		assertEquals(actualAlertTextDisplayed,expectedAlertText ,"unable to add sub category");
		
		
	}

}
