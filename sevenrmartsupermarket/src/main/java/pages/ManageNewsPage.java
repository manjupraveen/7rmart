package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.PageUtility;
public class ManageNewsPage {
		
	public WebDriver driver;
	PageUtility pageutility = new PageUtility();
		
	public ManageNewsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		}
		
		@FindBy(xpath = "//textarea[@id='news']") WebElement enterNews;
		@FindBy(xpath = "//button[@type='submit']") WebElement clickSave;
		@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")WebElement alertBox;
		public void navigateToPage(String url) {
			driver.navigate().to(url);
		}
		
		public void enterNews(String news) {
			enterNews.sendKeys(news);
		}
		public void clickSave() {
			clickSave.click();
		}
		 public String getAlertText() {
			 String alertText = alertBox.getText();
			 String actualAlertText = alertText.substring(9);
		        return actualAlertText; 
		 }
}
