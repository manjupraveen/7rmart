package pages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.PageUtility;
import utilities.RandomUtility;


public class FooterTextPage {
	public WebDriver driver;
	public FooterTextPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(xpath = "//table//tbody//tr[1]//td[4]//child::a") WebElement actionButton;
	@FindBy(xpath = "//input[@id='email']") WebElement emailField;
	@FindBy(xpath = "//button[contains(@class,'btn')]") WebElement updateButton;
	@FindBy(xpath = "//div[contains(@class,'alert')]") WebElement alertBox;
	
	public void navigateToSubcategoryPage(String url) {
		PageUtility utility = new PageUtility();
		 utility.navigateToPage(driver, url);
       	}
	public void clickActionButtony() {
		actionButton.click();
	}
	public void createEmail() {
		RandomUtility randomutility = new RandomUtility();
		String email=randomutility.createSubcategory();
		emailField.sendKeys(email);
	
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
