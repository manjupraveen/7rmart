package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import com.github.javafaker.Faker;

import utilities.PageUtility;
import utilities.RandomUtility;
import utilities.WaitUtility;

public class AdminUserPage {
public WebDriver driver;
Faker faker = new Faker();
	
	public AdminUserPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}

	
	@FindBy(xpath ="//a[@class='btn btn-rounded btn-danger']") WebElement newUserButton;
	@FindBy(xpath = "//input[@id='username']") WebElement adminUsernameField;
	@FindBy(xpath = "//input[@id='password']") WebElement adminPasswordField;
	@FindBy(xpath = "//select[@id='user_type']") WebElement userTypeDropDown;
	@FindBy(xpath = "//button[@name='Create']") WebElement saveButton;
	@FindBy(xpath = "//button[@class='close']//parent::div") WebElement alertBox;
	@FindBy(xpath = "//a[@class='btn btn-rounded btn-primary']") WebElement searchButton;
	@FindBy(xpath="//input[@id='un']")WebElement usernameInputField;
	@FindBy(xpath = "//select[@id='ut']") WebElement searchAdminUserTypeDropDown;
	@FindBy(xpath = "//button[@value='sr']") WebElement searchButton1;
	@FindBy(xpath = "//table[@class='table table-bordered table-hover table-sm']//tbody//tr[1]//td[1]") WebElement table;
	
	
	
	public AdminUserPage navigateToAdminPage(String url) {
		 PageUtility utility = new PageUtility();
		 utility.navigateToPage(driver, url);
		 return this;
        
    }
	 public AdminUserPage clickAddNewUser() {
		 WaitUtility waitutility = new WaitUtility();
		 waitutility.waituntilElementtobeClickable(driver,newUserButton);
	     newUserButton.click();
	     return this;
	    }
	 public AdminUserPage enterNewUserDetails(String newUsername, String newPassword, String userType) {
		 PageUtility utility = new PageUtility();
		 utility.enterDataOnInputField(adminUsernameField, newUsername);
		 utility.enterDataOnInputField(adminPasswordField, newPassword);
	     utility.selectfromDropDownUsingValue(userTypeDropDown, "staff");
	     return this;
	    }
	 public AdminUserPage createAdminUser() {
		 RandomUtility randomutility = new RandomUtility();
		 String newUserName=randomutility.createAdminUserName();
		 adminUsernameField.sendKeys(newUserName);
		 String newPassword =randomutility.createPassword();
		 adminPasswordField.sendKeys(newPassword);
		 PageUtility utility = new PageUtility();
	     utility.selectfromDropDownUsingValue(userTypeDropDown, "staff");
	     return this;
	 }
	 public AdminUserPage clickSave() {
	        saveButton.click();
	        return this;
	    }
	 public String getAlertText() {
		 String alertText = alertBox.getText();
		 String actualAlertText = alertText.substring(9);
	        return actualAlertText; 
	    }
	 public String getAlertTextOfUserCreated() {
		 String alertText = alertBox.getText();
		 String actualAlertText = alertText.substring(9);
	        return actualAlertText; 
	    }
	 public AdminUserPage clickSearch() {
		 searchButton.click();
		 return this;
	 }
	 public AdminUserPage enterUsernameandUserTypeDetails(String searchUsername, String userType) {
		 PageUtility utility = new PageUtility();
		 utility.enterDataOnInputField(usernameInputField, searchUsername);
		 utility.selectfromDropDownUsingValue(searchAdminUserTypeDropDown, "staff");
		 return this;
		 
		}
	 public AdminUserPage clickSearchButton() {
		 searchButton1.click();
		 return this;
		 
	 } 
	 public String getSearchResult() {
		 String searchedUsername =  table.getText();
		 return searchedUsername;
	 }
}
