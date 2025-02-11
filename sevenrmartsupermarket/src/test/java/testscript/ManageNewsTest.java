package testscript;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import pages.ManageNewsPage;
import pages.LoginPage;
import utilities.PageUtility;

public class ManageNewsTest extends Base {
	@Test
	(description = "enter category informations")
	public void verifyAddCategory() {
		String username = "admin";
		String password = "admin";
		String category = "hair care";
		String path = "C:\\Users\\hp\\OneDrive\\Desktop\\shampoo_300x300.jpg";
		String url = "https://groceryapp.uniqassosiates.com/admin/Category/add";
		LoginPage loginpage = new LoginPage (driver);
		loginpage.enterUsernameOnUsernameField(username);
		loginpage.enterPasswordOnPasswordField(password);
		loginpage.clickLogin();
		ManageNewsPage addcategorypage = new ManageNewsPage(driver);
		addcategorypage.navigateToPage(url);
		addcategorypage.enterCategory(category);
		addcategorypage.chooseImage(path);
		addcategorypage.showTopMenu();
		addcategorypage.showLeftMenu();
		addcategorypage.clickSaveButton();
		
	}
@Test
(description = "enter news information")
public void verifyEnterNewsInformation() {
	String username = "admin";
	String password = "admin";
	String url = "https://groceryapp.uniqassosiates.com/admin/News/add";
	String news = "message from obsqura";
	String expectedMessage = "News Created Successfully";
	LoginPage loginpage = new LoginPage (driver);
	loginpage.enterUsernameOnUsernameField(username);
	loginpage.enterPasswordOnPasswordField(password);
	loginpage.clickLogin();
	ManageNewsPage addcategorypage = new ManageNewsPage(driver);
	addcategorypage.navigateToPage(url);
	addcategorypage.enterNews(news);
	addcategorypage.clickSave();
	addcategorypage.getAlertText();
	String actualAlertTextDisplayed = addcategorypage.getAlertText();
	assertEquals(actualAlertTextDisplayed,expectedMessage ,"unable to create news");
}
}
