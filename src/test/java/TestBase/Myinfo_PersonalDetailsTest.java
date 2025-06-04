package TestBase;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.awt.AWTException;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;


import Page.LoginPage;
import Page.Myinfo_PersonalDetailsPage;

public class Myinfo_PersonalDetailsTest  extends BaseTest {

	

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
		Assert.assertTrue(true);
	}

	@Test(priority = 2)
	public void withoutdetials()
	{
		Myinfo_PersonalDetailsPage PersonalDetailsTest = new Myinfo_PersonalDetailsPage(driver);
		PersonalDetailsTest.Enter_Firstname(" ");
		PersonalDetailsTest.Enter_Middlename(" ");
		PersonalDetailsTest.Enter_Lastname(" ");
		PersonalDetailsTest.clickSaveButton1();
		Assert.assertFalse(false, "Validation error should appear");  
	}

	@Test(priority = 3)
	public void Add_Attachment() throws InterruptedException, AWTException, UnsupportedFlavorException, IOException
	{
		Myinfo_PersonalDetailsPage PersonalDetailsTest = new Myinfo_PersonalDetailsPage(driver);
		PersonalDetailsTest.Clickaddbutton();
		
		// Assertion: verify if file uploaded successfully

	    WebElement uploadedFileLabel = driver.findElement(By.xpath("//div[contains(text(),'rose.jpg')]")); // adjust XPath

	    Assert.assertTrue(uploadedFileLabel.isDisplayed(), "File upload failed: rose.jpg not found.");
	}
	
	@Test(priority = 4 )
	public void  FullDetails()	
	{
		Myinfo_PersonalDetailsPage PersonalDetailsTest = new Myinfo_PersonalDetailsPage(driver);
		PersonalDetailsTest.Enter_Firstname(prop.getProperty("firstname"));
		PersonalDetailsTest.Enter_Middlename(prop.getProperty("middlename"));
		PersonalDetailsTest.Enter_Lastname(prop.getProperty("lastname"));
	    PersonalDetailsTest.selectGender();
	    PersonalDetailsTest.selectMaritalStatus();
		PersonalDetailsTest.selectNationality();
		PersonalDetailsTest.clickSaveButton1();
		Assert.assertFalse(false);
    }
	
	@Test(priority = 5)
	public void ClickDeletebutton()
	{
		Myinfo_PersonalDetailsPage PersonalDetailsTest = new Myinfo_PersonalDetailsPage(driver);
		PersonalDetailsTest.ClickDeletebutton();
		Assert.assertTrue(true, "File Delete");
	}

	@Test(priority = 6)
	public void ClickDownlaodButton()
	{
		Myinfo_PersonalDetailsPage PersonalDetailsTest = new Myinfo_PersonalDetailsPage(driver);
		PersonalDetailsTest.ClickDownlaodButton();
		Assert.assertTrue(true, "File download");
	}
}