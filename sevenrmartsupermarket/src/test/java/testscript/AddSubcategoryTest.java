package testscript;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import pages.AddSubcategoryPage;
import pages.LoginPage;
import utilities.ExcelUtility;

public class AddSubcategoryTest extends Base {
	@Test
	(description = "verifying subcategory creation")
	public void verifySubcategoryCreation() {
		String username = ExcelUtility.getString(1, 0, "LoginPage");
		String password = ExcelUtility.getString(1, 1, "LoginPage");
		String url = ExcelUtility.getString(1, 0, "SubcategoryPage");
		String expectedAlertText = "Sub Category Created Successfully";
		LoginPage loginpage = new LoginPage (driver);
		loginpage.enterUsernameOnUsernameField(username);
		loginpage.enterPasswordOnPasswordField(password);
		loginpage.clickLogin();
		AddSubcategoryPage addsubcatpage = new AddSubcategoryPage(driver);
		addsubcatpage.navigateToSubcategoryPage(url);
		addsubcatpage.clicknewSubCategory();
		addsubcatpage.chooseselectCategory();
		addsubcatpage.enterSubcategory();
		addsubcatpage.chooseImageFile();
		addsubcatpage.clickCreateSubcategory();
		addsubcatpage.getAlerttext();
		String actualAlertTextDisplayed = addsubcatpage.getAlerttext();
		assertEquals(actualAlertTextDisplayed,expectedAlertText ,"unable to add sub category");
		
		
	}

}
