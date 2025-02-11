package testscript;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import pages.AddSubcategoryPage;
import pages.LoginPage;

public class AddSubcategoryTest extends Base {
	@Test
	(description = "verifying subcategory creation")
	public void verifySubcategoryCreation() {
		String username = "admin";
		String password = "admin";
		String url = "https://groceryapp.uniqassosiates.com/admin/list-sub-category";
		String path = "C:\\Users\\hp\\OneDrive\\Desktop\\download.jpg";
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
		addsubcatpage.chooseImageFile(path);
		addsubcatpage.clickCreateSubcategory();
		addsubcatpage.getAlerttext();
		String actualAlertTextDisplayed = addsubcatpage.getAlerttext();
		assertEquals(actualAlertTextDisplayed,expectedAlertText ,"unable to add sub category");
		
		
	}

}
