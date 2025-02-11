package utilities;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.openqa.selenium.WebElement;

public class FileUploadUtility {
public void usingsendKeys(WebElement element, String path) {
	element.sendKeys(path);
	
}
public void usingRobotClass(WebElement element, String path) throws AWTException {
	element.click();
	StringSelection stringselection = new StringSelection(path);
	Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringselection,null);
	 
	 Robot robot = new Robot();
	 robot.keyPress(KeyEvent.VK_ENTER);
	 
      //releasing enter
      robot.keyRelease(KeyEvent.VK_ENTER);
      robot.delay(50);
      robot.keyPress(KeyEvent.VK_CONTROL);
      robot.keyPress(KeyEvent.VK_V);
     
     
      robot.keyRelease(KeyEvent.VK_CONTROL);
      robot.keyRelease(KeyEvent.VK_V);
      
      robot.keyPress(KeyEvent.VK_ENTER);
      
     
     // r.delay(90);
      robot.keyRelease(KeyEvent.VK_ENTER);
      robot.delay(50);
      
}
	
}


