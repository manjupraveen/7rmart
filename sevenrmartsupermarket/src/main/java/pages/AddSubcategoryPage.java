package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import constants.Constant;
import utilities.FileUploadUtility;
import utilities.PageUtility;
import utilities.RandomUtility;

public class AddSubcategoryPage {
	public WebDriver driver;
	public AddSubcategoryPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
	
	
	
	@FindBy(xpath ="//a[@class='btn btn-rounded btn-danger']") WebElement newbutton;
	@FindBy(xpath ="//select[@id='cat_id']") WebElement category;
	@FindBy(xpath = "//input[@id='subcategory']") WebElement subcategory;
	@FindBy(xpath = "//input[@id='main_img']") WebElement chooseFile;
	@FindBy(xpath = "//button[@class='btn btn-danger']") WebElement saveButton;
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")WebElement alertBox;
	
	
	
	public AddSubcategoryPage navigateToSubcategoryPage(String url) {
		PageUtility utility = new PageUtility();
		 utility.navigateToPage(driver, url);
		 return this;
       
	}
	public AddSubcategoryPage clicknewSubCategory() {
		newbutton.click();
		return this;
	}
	
	public AddSubcategoryPage chooseselectCategory() {
		PageUtility utility = new PageUtility();
		utility.selectfromDropDownUsingVisibleText(category, "veggies");
		return this;
	}
	public AddSubcategoryPage enterSubcategory() {
		RandomUtility randomutility = new RandomUtility();
		String nameofSubcategory=randomutility.createSubcategory();
		subcategory.sendKeys(nameofSubcategory);
		return this;
	
}
	public AddSubcategoryPage chooseImageFile() {
		FileUploadUtility fileuploadutility = new FileUploadUtility();
		fileuploadutility.usingsendKeys(chooseFile, Constant.TESTDATAFILE1);
		return this;
		
	}
	public AddSubcategoryPage clickCreateSubcategory() {
		saveButton.click();
		return this;
	}
	public String getAlerttext() {
		String alertText = alertBox.getText();
		 String actualAlertText = alertText.substring(9);
	        return actualAlertText; 
		
	}
}
