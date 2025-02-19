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
	
	public ManageContactPage navigateToManageCoontactPage(String url) {
		PageUtility utility = new PageUtility();
		 utility.navigateToPage(driver, url);
		 return this;
       
	}
	public ManageContactPage clickActionButton() {
		actionButton.click();
		return this;
	}
	public ManageContactPage clearPhoneNumberField() {
		WaitUtility waitutility = new WaitUtility();
		waitutility.waitForElement(driver,phoneInputField );
		phoneInputField.clear();
		return this;
	}
	public ManageContactPage enterPhoneNumber() {
		RandomUtility randomutility = new RandomUtility();
		String phoneNumber=randomutility.createPhoneNumber();
		phoneInputField.sendKeys(phoneNumber);
		return this;
	
}
	public ManageContactPage scrollDown() {
		PageUtility utility = new PageUtility();
		utility.scrollToElement(driver, updateButton);
		return this;
	}
	
	public String getAlerttext() {
		String alertText = alertBox.getText();
		 String actualAlertText = alertText.substring(9);
	        return actualAlertText; 
		
	}
}
