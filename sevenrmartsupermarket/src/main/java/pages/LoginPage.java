package pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.PageUtility;

public class LoginPage {

	public WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(xpath = "//input[@name='username']") WebElement usernameField;
	@FindBy(xpath ="//input[@name='password']") WebElement passwordField;
	@FindBy(xpath = "//button[@type='submit']") WebElement signinButton;
	@FindBy(xpath = "//div[@class='row']//child::div[@class='col-lg-3 col-6'][1]")WebElement adminUserTile;
	@FindBy(xpath = "//button[@class='close']//parent::div")WebElement alert;
	public LoginPage enterUsernameOnUsernameField(String username) {
		 PageUtility utility = new PageUtility();
		 utility.enterDataOnInputField(usernameField, username);
	return this;
	}
	public LoginPage enterPasswordOnPasswordField(String password) {
		 PageUtility utility = new PageUtility();
		 utility.enterDataOnInputField(passwordField, password);
		 return this;
	}
	public AddSubcategoryPage clickLogin() {
		signinButton.click();
		return new AddSubcategoryPage(driver);
	}
	public boolean whetherAdminUserTileIsDisplayed() {
		boolean adminUserTileDisplay = adminUserTile.isDisplayed(); 
		return adminUserTileDisplay;
	}
	public boolean alertIsDisplayed() {
		boolean alertDisplay = alert.isDisplayed();
		return alertDisplay;
	}
}
