package utilities;

import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitUtility {
	public static final long IMPLICIT_WAIT = 5;
	public static final long PAGE_LOAD_WAIT = 20;
	public static final long EXPLICIT_WAIT = 30;
	public static final long POLLING_WAIT = 5;
	public static final long TIMEOUT_WAIT=30;

	public void waitForElement(WebDriver driver, WebElement target) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(EXPLICIT_WAIT));
		wait.until(ExpectedConditions.visibilityOf(target));
	}
public void waituntilAlertIsPresent(WebDriver driver, WebElement target) {
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(EXPLICIT_WAIT));
	wait.until(ExpectedConditions.alertIsPresent());
	
}
public void waituntilElementtobeClickable(WebDriver driver, WebElement target) {
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(EXPLICIT_WAIT));
	wait.until(ExpectedConditions.elementToBeClickable(target));
	
}
public void waituntilTextToBePresent(WebDriver driver, WebElement target, String text) {
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(EXPLICIT_WAIT));
	wait.until(ExpectedConditions.textToBePresentInElement(target, text));
	}
	public void waitUntilTitleIsPresent(WebDriver driver, WebElement target, String title) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(EXPLICIT_WAIT));
		wait.until(ExpectedConditions.titleIs(title));
		
		
	}
	public void fluentWait(WebDriver driver, WebElement target) {
		FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(TIMEOUT_WAIT))
				.pollingEvery(Duration.ofSeconds(POLLING_WAIT))
				.ignoring(NoSuchElementException.class);
		
		
	}
	
}

