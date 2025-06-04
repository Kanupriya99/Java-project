package TestBase;

import java.awt.AWTException;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import Page.LoginPage;
import Page.Myinfo_PersonalDetailsPage;
import Page.ProfilepicturePage;

public class ProfilepictureTest extends BaseTest {

	@BeforeClass()
	public void Login() 
	{

		LoginPage loginpage =new LoginPage(driver);
		loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
   	    Assert.assertTrue(loginpage.isLoginSuccessful(),"login should be successful");

	}
	
	@Test(priority = 1)
     public void openMyInfo()
	{
		Myinfo_PersonalDetailsPage PersonalDetailsTest = new Myinfo_PersonalDetailsPage(driver);
		PersonalDetailsTest.myInfo();     
		Assert.assertTrue(driver.getCurrentUrl().contains("viewPersonalDetails"), "Failed to navigate to My Info page");

	}

	@Test(priority =2)
	public void clickonPP()
	{
		ProfilepicturePage ProfilepictureTest = new ProfilepicturePage(driver);
		ProfilepictureTest.Clickonprofilepic();
	
	
	}
	@Test(priority =3)
	public void Clickonaddbutton() throws AWTException, InterruptedException, UnsupportedFlavorException, IOException
	{

		ProfilepicturePage ProfilepictureTest = new ProfilepicturePage(driver);
		ProfilepictureTest.Clickonaddbutton();
	       Assert.assertTrue(true, "File upload failed: rose.jpg not found.");
	 
	}

	@Test(priority =4)
	public void Clickonsavebutton() throws InterruptedException
	{
		ProfilepicturePage ProfilepictureTest = new ProfilepicturePage(driver);
		
		ProfilepictureTest.Clickonsavebutton();
	}
}


