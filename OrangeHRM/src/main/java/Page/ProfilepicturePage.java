package Page;

import java.awt.AWTException;

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
		
		public void Clickonprofilepic()
		{
			waitForVisibility(Profilepic);
			Profilepic.click();
		}
		
		public void Clickonaddbutton() throws AWTException
		{
			waitForVisibility(AddButton);
			AddButton.click();
			uploadfile();
		} 
		
		public void Clickonsavebutton()
		{
			waitForVisibility(SaveButton);
			SaveButton.click();
		}

		public boolean isProfilePicModalVisible() {
			// TODO Auto-generated method stub
			return false;
		} 
	}

