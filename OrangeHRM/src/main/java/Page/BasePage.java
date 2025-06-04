package Page;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
	
	protected WebDriver driver;
	protected WebDriverWait wait;
	
	// Constructor
		public BasePage(WebDriver driver) {
		this.driver =driver;
		PageFactory.initElements(driver, this);
		
	//Set wait time to 15 seconds
		this.wait = new WebDriverWait(driver,Duration.ofSeconds(15)); 
		}
		
		//utility methods
		public  void waitForVisibility(WebElement element) {
			wait.until(ExpectedConditions.visibilityOf(element));
		}
		
		public void waitForClickability(WebElement element1) {
			wait.until(ExpectedConditions.elementToBeClickable(element1));
		}
	    		
		public void uploadfile() throws AWTException, UnsupportedFlavorException, IOException, InterruptedException
		{
			//make object of robot class
			Robot robot = new Robot();
			
			// add sleep here for delay 
		    Thread.sleep(2000);
			
			//copy the file path 
			StringSelection stringselection = new StringSelection("C:\\Users\\Kanu\\Downloads\\rose.jpg");
			
			//
			Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringselection, null);
			
			
			//paste the file
			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_V);
			robot.keyRelease(KeyEvent.VK_CONTROL);
			robot.keyRelease(KeyEvent.VK_V);
			
			// press the enter
			Thread.sleep(2000);
			
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);
			Thread.sleep(2000);
		
		}
		
		
		public void scrollingtoView(WebElement element)
		{
			JavascriptExecutor  JS =(JavascriptExecutor)driver;// object
			JS.executeScript("arguments[0].scrollIntoView();",element);
			System.out.println(JS.executeScript("return window.pageYOffset;"));
		}

		

		
			
		}
	
		
		
	


