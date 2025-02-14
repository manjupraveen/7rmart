package testscript;


import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;


import pages.CategoryPage;
import pages.LoginPage;


	public class CategoryTest extends Base {
		@Test
		(description = "enter category informations")
		public void verifyAddCategory() {
			String username = "admin";
			String password = "admin";
			String category = "hair care";
			String path = "C:\\Users\\hp\\OneDrive\\Desktop\\shampoo_300x300.jpg";
			String url = "https://groceryapp.uniqassosiates.com/admin/Category/add";
			String expectedMessage ="";
			LoginPage loginpage = new LoginPage (driver);
			loginpage.enterUsernameOnUsernameField(username);
			loginpage.enterPasswordOnPasswordField(password);
			loginpage.clickLogin();
			CategoryPage addcategorypage = new CategoryPage(driver);
			addcategorypage.navigateToPage(url);
			addcategorypage.enterCategory(category);
			addcategorypage.chooseImage(path);
			addcategorypage.showTopMenu();
			addcategorypage.showLeftMenu();
			addcategorypage.clickSaveButton();
			//String actualAlertTextDisplayed = addcategorypage.getAlertText();
			//assertEquals(actualAlertTextDisplayed,expectedMessage ,"unable to create news");
			
		}

}
