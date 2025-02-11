package utilities;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class PageUtility {
	
	
	public void enterDataOnInputField(WebElement element, String data) {
		element.sendKeys(data);
	}
	public void navigateToPage( WebDriver driver,String url) {
        driver.navigate().to(url);
    } 
	
	
		
	public String cssValueOfWebElement(WebElement element, String property) {
		String cssValue = element.getCssValue(property);
		return cssValue;
		
	}
	public String attributeValueOfWebElement(WebElement element, String attribute) {
		String attributeValue = element.getAttribute(attribute);
		return attributeValue;
	}
	
	public void selectfromDropDownUsingValue(WebElement element,String value ){
		Select select = new Select(element);
        select.selectByValue(value);
	}
	public void selectfromDropDownUsingIndex(WebElement element,int index ){
		Select select = new Select(element);
        select.selectByIndex(index);
	}
	public void selectfromDropDownUsingVisibleText(WebElement element,String visibleText ){
		Select select = new Select(element);
        select.selectByVisibleText(visibleText);
	}
	public void actionMouseHover(WebDriver driver,WebElement element){
		Actions actions = new Actions(driver);
		actions.moveToElement(element).build().perform();
	}
	public void actionDoubleClick(WebDriver driver,WebElement element) {
		Actions actions = new Actions(driver);
		actions.doubleClick(element).perform();
	}
	
	public void actionRightClick(WebDriver driver,WebElement element) {
		Actions actions = new Actions(driver);
		actions.contextClick(element).perform();
	}
	
	public void actiondargandDrop(WebDriver driver,WebElement element, WebElement element1) {
		Actions actions = new Actions(driver);
		actions.dragAndDrop(element, element1).build().perform();
	}
	public void acceptAlert(WebDriver driver) {
		driver.switchTo().alert().accept();
	}
	public void dismissAlert(WebDriver driver) {
		driver.switchTo().alert().dismiss();
	}
	public String getAlertText(WebDriver driver) {
		
		String alertText = driver.switchTo().alert().getText();
		return alertText;
	}
	public void switchToIFrame(WebDriver driver,WebElement iFrameElement) {
		driver.switchTo().frame(iFrameElement);
	}
	public void switchToIFrameByIndex(WebDriver driver,WebElement element,int index ) {
		driver.switchTo().frame(index);
	}
	public void switchToIFrameById(WebDriver driver,String id) {
		driver.switchTo().frame(id);
	}
	public void scrollToElement(WebDriver driver,WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", element);
		
	}
	public void scrollFromTop(WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,200)", "");
	}
	public void scrollFromBottom(WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,-200)", "");
		
	}
	public void scrollToPageHeight(WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0, document.body.scrollHeight)");
	}
	
}
	
