package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.PageUtility;
import utilities.RandomUtility;
import utilities.WaitUtility;

public class ManageContactPage {
public WebDriver driver;
	
	public ManageContactPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(xpath = "//a[@class='btn btn-sm btn btn-primary btncss']") WebElement actionButton;
	@FindBy(xpath = "//input[@id='phone']") WebElement phoneInputField;
	@FindBy(xpath = "//div[@class='card-footer center']//child::button") WebElement updateButton;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']") WebElement alertBox;
	
	public void navigateToManageCoontactPage(String url) {
		PageUtility utility = new PageUtility();
		 utility.navigateToPage(driver, url);
       
	}
	public void clickActionButton() {
		actionButton.click();
	}
	public void clearPhoneNumberField() {
		WaitUtility waitutility = new WaitUtility();
		waitutility.waitForElement(driver,phoneInputField );
		phoneInputField.clear();
	}
	public void enterPhoneNumber() {
		RandomUtility randomutility = new RandomUtility();
		String phoneNumber=randomutility.createPhoneNumber();
		phoneInputField.sendKeys(phoneNumber);
	
}
	public void scrollDown() {
		PageUtility utility = new PageUtility();
		utility.scrollToElement(driver, updateButton);
	}
	
	public String getAlerttext() {
		String alertText = alertBox.getText();
		 String actualAlertText = alertText.substring(9);
	        return actualAlertText; 
		
	}
}
