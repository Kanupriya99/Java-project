package Page;

import java.awt.AWTException;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProfilepicturePage extends BasePage  {

	public ProfilepicturePage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
		@FindBy(xpath="//a[.//span[text()='My Info']]")
		WebElement myinfo;
		
		@FindBy(css =".orangehrm-edit-employee-image-wrapper")
		WebElement Profilepic;
		
		@FindBy(css =".oxd-icon-button.oxd-icon-button--solid-main.employee-image-action")
		WebElement AddButton;
		
		@FindBy(xpath ="//button[@type='submit']")
		WebElement SaveButton;
		
		@FindBy(xpath ="//img[contains(@src, 'viewPhoto/empNumber/7')]")
		WebElement Verfiy;
		
		public void Clickonprofilepic()
		{
			waitForVisibility(Profilepic);
			Profilepic.click();
		}
		
		public void Clickonaddbutton() throws AWTException, InterruptedException, UnsupportedFlavorException, IOException
		{
			waitForVisibility(AddButton);
			AddButton.click();
			uploadfile();
			
		} 
		
		
		public void Clickonsavebutton() throws InterruptedException
		{
			
			scrollingtoView(SaveButton);
			waitForVisibility(SaveButton);
			SaveButton.click();
			Thread.sleep(2000);
		}

		
		} 
	

