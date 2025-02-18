package pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.github.javafaker.Faker;

import utilities.PageUtility;
import utilities.WaitUtility;

public class MenuManagementPage {
	
		public WebDriver driver;
	
			public MenuManagementPage(WebDriver driver) {
				this.driver = driver;
				PageFactory.initElements(driver, this);
				
			}
	@FindBy(xpath = "//a[contains(@onclick,'click_button(1)')]") WebElement newButton;
	@FindBy(xpath = "//input[@id='name']")WebElement menuNameInputField;
	@FindBy(xpath = "//button[contains(@class,'btn-block-sm')]")WebElement saveButton;
	@FindBy(xpath = "//div[contains(@class,'alert-success ')]") WebElement alertBox;
	
			public void navigateToMenuManagementPage(String url) {
				 PageUtility utility = new PageUtility();
				 utility.navigateToPage(driver, url);
		        
		    }
			public void clickAddNewMenu() {
			     newButton.click();
			    }
			public void enetrMenuName(String menuName) {
				 PageUtility utility = new PageUtility();
				 utility.enterDataOnInputField(menuNameInputField, menuName);
			}
			public void scrollDown() {
				PageUtility utility = new PageUtility();
				utility.scrollToElement(driver, saveButton);
			}
			public String getAlerttext() {
				String alertText = alertBox.getText();
				 String actualAlertText = alertText.substring(9);
			        return actualAlertText; 
				
			}
}
