package pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.WebDriver;

public class CommonMethod {
	public static void clickAutoSuggest(WebDriver driver) throws AWTException, InterruptedException {
		// driver.findElement(By.xpath(("//ul[@id='react-autosuggest-1']/li[1])"))).click();
		Robot rb = new Robot();

		rb.keyPress(KeyEvent.VK_DOWN);
		// rb.keyRelease(KeyEvent.VK_DOWN);
		rb.keyPress(KeyEvent.VK_ENTER);
		rb.keyRelease(KeyEvent.VK_ENTER);
		rb.keyPress(KeyEvent.VK_UP);
		rb.keyRelease(KeyEvent.VK_UP);
		Thread.sleep(3000);
	}
}
