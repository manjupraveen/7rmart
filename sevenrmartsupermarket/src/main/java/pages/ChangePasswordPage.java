package pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.PageUtility;

public class ChangePasswordPage {
	public WebDriver driver;
	public ChangePasswordPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
	@FindBy(xpath = "//input[@name='old_pwd']")WebElement oldPasswordField;
	@FindBy(xpath = "//input[@name='new_pwd']")WebElement newPasswordField;
	@FindBy(xpath ="//input[@name='conf_password']")WebElement confirmPasswordField;
	@FindBy(xpath = "//button[contains(@class,'btn-dark')]") WebElement changeButton;
	@FindBy(xpath = "//div[contains(@class,'alert')]") WebElement alertBox;
	
	
	
	
	
	public void navigateToChangePasswordPage(String url) {
		PageUtility utility = new PageUtility();
		 utility.navigateToPage(driver, url);
	}

	public void enterOldPassword(String oldpassword) {
		PageUtility utility = new PageUtility();
		utility.enterDataOnInputField(oldPasswordField, oldpassword);
	}
	public void enterNewPassword(String newpassword) {
		PageUtility utility = new PageUtility();
		utility.enterDataOnInputField(newPasswordField, newpassword);
	}
	public void enterConfirmNewPassword(String newpassword) {
		PageUtility utility = new PageUtility();
		utility.enterDataOnInputField(confirmPasswordField, newpassword);
	}
	public void clickChangeButton() {
		changeButton.click();
	}
	public String getAlerttext() {
		String alertText = alertBox.getText();
		 String actualAlertText = alertText.substring(9);
	        return actualAlertText; 
		
	}
}

